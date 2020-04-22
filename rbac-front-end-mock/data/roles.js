const Mock = require('mockjs')

const Roles = []

for (let i = 0; i < 4; i++) {
  Roles.push(Mock.mock({
    roleId: Mock.Random.increment(),
    roleName: Mock.Random.cname(),
    // roleCode: Mock.Random.integer(10000, 90000),
    // superCode: Mock.Random.integer(10000, 90000),
    description: Mock.Random.csentence()
  }
  ))
}

module.exports = Roles
