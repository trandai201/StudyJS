const { response } = require("express")
var db = require('../db')

module.exports.requireAuth = function(request,response,next){
    var userID = request.cookies.userID;
    if(!request.cookies.userID){
        response.redirect("/auth/login");
        return;
    }

    var user = db.get('listUser').find({id : request.cookies.userID }).value();
    if(!userID == user.id){
        response.redirect("/auth/login");
        return;
    }
    next();
}