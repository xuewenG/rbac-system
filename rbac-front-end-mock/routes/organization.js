const express = require('express')
const router = express.Router()
const result = require('../util/result')
const Mock = require('mockjs')

const Organizations = require('../data/organizations')

router.post('/get', (req, resp) => {
  const { searchWord, page, pageSize } = req.body
  const selectedOrganizations = Organizations.filter(organization => {
    if (searchWord && organization.orgaName.indexOf(searchWord) === -1) {
      return false
    }
    return true
  })
  const total = selectedOrganizations.length
  let listOrganizations = []
  if (page === '') {
    listOrganizations = selectedOrganizations
  } else {
    listOrganizations = selectedOrganizations.filter(
      (u, index) => index < pageSize * page && index >= pageSize * (page - 1)
    )
  }
  resp.send(result.success({ organizations: listOrganizations, total: total }))
})

router.post('/add', (req, resp) => {
  const newOrganization = req.body.requestData
  newOrganization.orgaId = Mock.Random.increment()
  Organizations.push(newOrganization)
  resp.send(result.success())
})

router.post('/edit', (res, resp) => {
  const newOrganization = res.body.requestData
  Organizations.forEach(organization => {
    if (newOrganization.orgaId === organization.orgaId) {
      Object.assign(organization, newOrganization)
    }
  })
  resp.send(result.success())
})

router.post('/delete', (res, resp) => {
  const ids = res.body.ids
  ids.forEach(id => {
    for (let i = 0; i < Organizations.length; i++) {
      if (id === Organizations[i].orgaId) {
        Organizations.splice(i, 1)
        break
      }
    }
  })
  resp.send(result.success())
})

module.exports = router
