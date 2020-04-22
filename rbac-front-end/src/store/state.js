const local = sessionStorage.getItem('state')
const state = local ? JSON.parse(local) : {
  hasLogin: false,
  staffInfo: {
    staffName: ''
  },
  roles: []
}
export default state
