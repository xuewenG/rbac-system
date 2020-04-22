const success = function (data) {
  return {
    code: '0000',
    msg: 'success',
    data: data
  }
}
const failed = function (code, msg) {
  return {
    code,
    msg
  }
}
module.exports = {
  success,
  failed
}
