import Vue from 'vue'
import {hasAnyRole} from './permission'

const directives = [
  hasAnyRole
]

directives.forEach(directive => {
  Vue.use(directive)
})
