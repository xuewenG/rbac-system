import Vue from 'vue'
import Router from 'vue-router'
import Login from '../pages/Login'
import StaffManage from '../components/StaffManage'
import Manage from '../pages/Manage'
import RoleManage from '../components/RoleManage'
import PrivilegeManage from '../components/PrivilegeManage'
import GroupManage from '../components/GroupManage'
import OrganizationManage from '../components/OrganizationManage'
import MenuManage from '../components/MenuManage'
import store from '../store'
import EnterpriseManage from '../components/EnterpriseManage'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      redirect: '/manage/staff'
    }, {
      path: '/login',
      name: 'Login',
      component: Login,
      meta: {
        requireAuth: false
      }
    }, {
      path: '/manage',
      name: 'Manage',
      component: Manage,
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: 'staff',
          name: 'StaffManage',
          component: StaffManage,
          meta: {
            requireAuth: true
          }
        },
        {
          path: 'role',
          name: 'RoleManage',
          component: RoleManage,
          meta: {
            requireAuth: true
          }
        },
        {
          path: 'privilege',
          name: 'PrivilegeManage',
          component: PrivilegeManage,
          meta: {
            requireAuth: true
          }
        },
        {
          path: 'menu',
          name: 'MenuManage',
          component: MenuManage,
          meta: {
            requireAuth: true
          }
        },
        {
          path: 'group',
          name: 'GroupManage',
          component: GroupManage,
          meta: {
            requireAuth: true
          }
        },
        {
          path: 'organization',
          name: 'OrganizationManage',
          component: OrganizationManage,
          meta: {
            requireAuth: true
          }
        },
        {
          path: 'enterprise',
          name: 'EnterpriseManage',
          component: EnterpriseManage,
          meta: {
            requireAuth: true
          }
        }
      ]
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.getters.hasLogin) {
      next()
    } else {
      next({
        name: 'Login',
        query: { redirect: to.fullPath }
      })
    }
  } else {
    next()
  }
})

export default router
