const Mock = require('mockjs')

const Organizations = []

for (let i = 0; i < 40; i++) {
  Organizations.push(Mock.mock({
    orgaId: Mock.Random.increment(),
    orgaName: Mock.Random.cname(),
    orgaTypeId: /00[0123456789]/,
    orgaState: /[012]/,
    cityFlag: /[01]/,
    orgaCode: /00[0123456789]/,
    superOrgaCode: /00[0123456789]/,
    orgaDesc: Mock.Random.csentence(),
    areaCode: /00[0123456789]/,
    orderNum: /00[0123456789]/,
    updateTime: Mock.Random.date('yyyy-MM-dd')
  }
  ))
}

module.exports = Organizations
