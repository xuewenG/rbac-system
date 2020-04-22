const express = require('express')
const router = express.Router()
const result = require('../util/result')
const Roles = require('../data/roles')

router.post('/get', function (req, res, next) {
  const resp = result.success({
    roles: Roles,
    totalPage: 18
  })
  res.send(resp)
})

router.post('/delete', (req, resp) => {
  resp.send(result.success())
})

router.post('/edit', (req, resp) => {
  resp.send(result.success())
})

router.post('/add', (req, resp) => {
  resp.send(result.success())
})

module.exports = router
