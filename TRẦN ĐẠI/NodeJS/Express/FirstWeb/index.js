var express = require("express");
var bodyParser = require("body-parser");
const { request, response } = require("express");
var userRoutes = require('./routes/user.route');
var authRouter = require('./routes/auth.router')

var cookieParser = require('cookie-parser')

var app = express();
var port = 3000;

app.use(express.json()) // for parsing application/json
app.use(express.urlencoded({ extended: true })) // for parsing application/x-www-form-urlencoded
app.use(cookieParser())


app.set('view engine', 'pug');
app.set('views', './views');


app.get('/', function (request, response) {
    const {cookies} = request
    console.log(cookies)
    response.render("index", {
        name: "trandai"
    });

});

app.use(express.static('public'))

app.use('/users',userRoutes);
app.use('/auth',authRouter)


app.listen(port, function () {
    console.log("Server listen  on port : " + port);
});