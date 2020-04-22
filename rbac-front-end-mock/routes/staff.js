const express = require('express')
const router = express.Router()
const Mock = require('mockjs')
const result = require('../util/result')
const Staffs = require('../data/staffs')
const Groups = require('../data/groups')
const Organizations = require('../data/organizations')
const Roles = require('../data/roles')

router.post('/login', (req, res) => {
  const body = req.body
  let resp
  if (body.staffAccount !== '1' || body.password !== '123') {
    resp = result.failed('4101', '密码错误!')
  } else {
    resp = result.success({
      staffInfo: {
        staffId: '1',
        staffName: 'xuewen',
        staffState: '1',
        staffIdStatus: '01',
        dLevelId: '1',
        dlModulus: 1.0,
        secondPost: '1',
        dutyId: '1',
        secondDuty: '1',
        organizationId: '1',
        postId: '1',
        staffAccount: '1',
        disableBeginDate: '2019-08-14T10:03:01.000+0000',
        disableEndDate: '2019-08-14T10:03:05.000+0000',
        updateTime: '2019-08-14T10:03:07.000+0000',
        batchNo: '1',
        workEfficiency: 1,
        petName: 'xuewenG'
      }
    })
  }
  res.send(resp)
})

router.post('/logout', (req, res) => {
  res.send(result.success())
})

router.post('/get', (req, resp) => {
  const { searchWord, page, pageSize } = req.body
  const selectedStaffs = Staffs.filter(staff => {
    if (searchWord && staff.staffName.indexOf(searchWord) === -1) {
      return false
    }
    return true
  })
  const total = selectedStaffs.length
  const listStaffs = selectedStaffs.filter(
    (u, index) => index < pageSize * page && index >= pageSize * (page - 1)
  )
  resp.send(result.success({ staffs: listStaffs, total: total }))
})

router.post('/add', (req, resp) => {
  const newStaff = req.body.newStaff
  newStaff.staffId = Mock.Random.increment()
  Staffs.push(newStaff)
  resp.send(result.success())
})

router.post('/edit', (res, resp) => {
  const newStaff = res.body.requestData
  Staffs.forEach(staff => {
    if (newStaff.staffId === staff.staffId) {
      Object.assign(staff, newStaff)
    }
  })
  resp.send(result.success())
})

router.post('/delete', (res, resp) => {
  const ids = res.body.ids
  ids.forEach(id => {
    for (let i = 0; i < Staffs.length; i++) {
      if (id === Staffs[i].staffId) {
        Staffs.splice(i, 1)
        break
      }
    }
  })
  resp.send(result.success())
})

module.exports = router
