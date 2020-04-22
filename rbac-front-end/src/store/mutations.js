import {HAS_LOGIN_MUTATION, ROLES_MUTATION, STAFF_INFO_MUTATION} from './mutations-type'

export default {
  [HAS_LOGIN_MUTATION] (state, hasLogin) {
    state.hasLogin = hasLogin
  },
  [STAFF_INFO_MUTATION] (state, staffInfo) {
    state.staffInfo = staffInfo
  },
  [ROLES_MUTATION] (state, roles) {
    state.roles = roles
  }
}
