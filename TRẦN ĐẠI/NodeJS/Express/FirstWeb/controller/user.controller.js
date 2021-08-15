var db = require('../db');
const shortid = require('shortid');

module.exports.index = function index(request, response) {
    response.render('users/index.pug', {
        users: db.get("listUser").value()
    })
}
 module.exports.search = function (requset, response) {
    let keyWord = requset.query.name
    var result = db.get("listUser").value().filter(function (x) {
        //console.log(x.name.toLowerCase() + "  " + keyWord.toLowerCase() + "  " + x.name.toLowerCase().indexOf(keyWord.toLowerCase()));
        return x.name.toLowerCase().indexOf(keyWord.toLowerCase()) != -1;
    })
    response.render('users/index.pug', {
        users: result
    })
}

module.exports.create = function (request, response) {

    response.render('users/create.pug')

}

module.exports.postCreate = function (request, response) {
    console.log
    var item = { id: shortid.generate(),
        name: request.body['name'],
    phone : request.body['number'] }
   
    db.get("listUser").push(item).write();
    response.redirect('/users')
}

module.exports.view = function (request, response) {
    let id = request.params.id;
    var user = db.get('listUser').find({id: id}).value();
  
     response.render("./users/view.pug",{
         user : user
     });
}