const express = require('express')
const router = express.Router()
const result = require('../util/result')
const Mock = require('mockjs')

const Groups = require('../data/groups')

router.post('/get', (req, resp) => {
  const { searchWord, page, pageSize } = req.body
  const selectedGroups = Groups.filter(group => {
    if (searchWord && group.groupName.indexOf(searchWord) === -1) {
      return false
    }
    return true
  })
  const total = selectedGroups.length
  let listGroups = []
  if (page === '') {
    listGroups = selectedGroups
  } else {
    listGroups = selectedGroups.filter(
      (u, index) => index < pageSize * page && index >= pageSize * (page - 1)
    )
  }
  resp.send(result.success({ groups: listGroups, total: total }))
})

router.post('/add', (req, resp) => {
  const newGroup = req.body.requestData
  newGroup.groupId = Mock.Random.increment()
  Groups.push(newGroup)
  resp.send(result.success())
})

router.post('/edit', (res, resp) => {
  const newGroup = res.body.requestData
  console.log(newGroup)
  Groups.forEach(group => {
    if (newGroup.groupId === group.groupId) {
      Object.assign(group, newGroup)
    }
  })
  resp.send(result.success())
})

router.post('/delete', (res, resp) => {
  const ids = res.body.ids
  ids.forEach(id => {
    for (let i = 0; i < Groups.length; i++) {
      if (id === Groups[i].groupId) {
        Groups.splice(i, 1)
        break
      }
    }
  })
  resp.send(result.success())
})

module.exports = router
