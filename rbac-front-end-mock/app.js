const express = require('express')
const path = require('path')
const cookieParser = require('cookie-parser')
const logger = require('morgan')

const roleRouter = require('./routes/role')
const staffRouter = require('./routes/staff')
const organizationRouter = require('./routes/organization')
const groupRouter = require('./routes/group')

const app = express()

app.all('*', function (req, res, next) {
  res.header('Access-Control-Allow-Origin', 'http://localhost:8080')
  res.header('Access-Control-Allow-Headers', 'Content-Type,Content-Length, Authorization, Accept,X-Requested-With')
  res.header('Access-Control-Allow-Methods', 'PUT,POST,GET,DELETE,OPTIONS')
  res.header('X-Powered-By', ' 3.2.1')
  res.header('Access-Control-Allow-Credentials', true)
  if (req.method === 'OPTIONS') res.send(200)
  else next()
})

app.use(logger('dev'))
app.use(express.json())
app.use(express.urlencoded({ extended: false }))
app.use(cookieParser())
app.use(express.static(path.join(__dirname, 'public')))

app.use('/staff', staffRouter)
app.use('/role', roleRouter)
app.use('/organization', organizationRouter)
app.use('/group', groupRouter)

module.exports = app
