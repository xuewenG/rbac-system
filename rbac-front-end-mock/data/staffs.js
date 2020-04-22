const Mock = require('mockjs')
const Organizations = require('./organizations')
const Roles = require('./roles')
const Groups = require('./groups')

const Staffs = []

const RoleIds = []
Roles.forEach(role => {
  RoleIds.push(role.roleId)
})

const OrganizationIds = []
Organizations.forEach(organization => {
  OrganizationIds.push(organization.orgaId)
})

const GroupIds = []
Groups.forEach(group => {
  GroupIds.push(group.groupId)
})

for (let i = 0; i < 100; i++) {
  Staffs.push(
    Mock.mock({
      staffId: Mock.Random.increment(),
      staffName: Mock.Random.cname(),
      staffState: /[01]/,
      staffIdStatus: /0[1234567]/,
      'group|1': GroupIds,
      'organization|1': OrganizationIds,
      roles: function () {
        const newRoles = []
        for (let i = 0; i < Math.floor(Math.random() * 4) + 1; i++) {
          newRoles.push(RoleIds[(Math.floor(Math.random() * 4))])
        }
        // 去重
        const singleNewRoles = [newRoles[0]]
        for (let i = 1; i < newRoles.length; i++) {
          if (newRoles.indexOf(newRoles[i]) === i) singleNewRoles.push(newRoles[i])
        }
        return singleNewRoles
      },
      petName: Mock.Random.cname()
    })
  )
}

module.exports = Staffs
