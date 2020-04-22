import {HAS_LOGIN_MUTATION, ROLES_MUTATION, STAFF_INFO_MUTATION} from './mutations-type'

export default {
  async loginAction ({ state, commit }, {staffInfo, roles}) {
    commit(HAS_LOGIN_MUTATION, true)
    commit(STAFF_INFO_MUTATION, staffInfo)
    commit(ROLES_MUTATION, roles)
    sessionStorage.setItem('state', JSON.stringify(state))
  },
  async logoutAction ({ state, commit }) {
    commit(HAS_LOGIN_MUTATION, false)
    sessionStorage.setItem('state', JSON.stringify(state))
  }
}
