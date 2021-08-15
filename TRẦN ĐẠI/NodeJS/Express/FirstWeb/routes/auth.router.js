var express = require('express')
var router = express.Router();
var db = require('../db');

var validate = require('../validate/user.validate')


var controller = require('../controller/auth.controller.js')




router.get('/login', controller.login);
router.post('/login', controller.postLogin);




module.exports = router;