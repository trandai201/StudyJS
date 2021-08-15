var express = require('express')
var router = express.Router();
var db = require('../db');
var authMidleware = require('../midlelwares/auth.midleware')

var validate = require('../validate/user.validate')


var controller = require('../controller/user.controller')


router.get('/',authMidleware.requireAuth, controller.index);


router.get('/search', controller.search);



router.get('/create', controller.create);

router.post('/create',validate.postCreate  , controller.postCreate)
router.get('/cookie',function(request,response){
    console.log(request.cookies)
    response.send("Heloo You!!!!!!")
})

router.get('/:id',controller.view)

module.exports = router;