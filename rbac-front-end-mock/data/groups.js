const Mock = require('mockjs')

const Groups = []

for (let i = 0; i < 40; i++) {
  Groups.push(Mock.mock({
    groupId: Mock.Random.increment(),
    groupName: Mock.Random.cname(),
    groupTypeId: /00[0123456789]/,
    groupCode: /00[0123456789]/,
    superGroupCode: /00[0123456789]/,
    validStart: Mock.Random.date('yyyy-MM-dd'),
    validEnd: Mock.Random.date('yyyy-MM-dd'),
    groupDesc: Mock.Random.csentence(),
    cityId: /00[0123456789]/
  }
  ))
}

module.exports = Groups
