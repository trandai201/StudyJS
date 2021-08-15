var db = require('../db');
var md5 = require('md5');
module.exports.login = function(request, response) {


    response.render('./auth/login.pug', {
        users: db.get("listUser").value()
    })
}
module.exports.postLogin = function(request, response) {

    var email = request.body.email;
    var password = request.body.password;

    var user = db.get('listUser').find({ email: email }).value();

    if (!user) {
        response.render('./auth/login', {
            errors: ['Sai Email !'],
            values: request.body
        })
        return;
    }
    var hashedPassword = md5(password);
    if (user.password !== hashedPassword) {
        response.render('./auth/login', {
            errors: ['Sai Mat Khau!'],
            values: request.body
        })
        return;

    }




    response.cookie('userID', user.id);
    response.redirect('/users');
}

Dangkytinchi: function() {
        $(".chon_lhp").click(function() {
                var id_lophp = $(this).attr("hp_id"); //29377
                var khung_id = $(this).attr("khung_id"); //
                var id_lop_thuchanh = 0;
                var total_lop_th = $(this).attr('lop_th');
                var is_check = true;
                if (total_lop_th > 0) {
                    if ($('input[name="thuchanh_' + id_lophp + '"]').is(":checked")) {
                        //id_lop_thuchanh = $('input[name="thuchanh_'+id_lophp+'"]').is(":checked").val();
                        id_lop_thuchanh = $("input[name='thuchanh_" + id_lophp + "']:checked").val();
                    }
                }
                if (total_lop_th > 0) {
                    if (id_lop_thuchanh == 0) {
                        jAlert("Vui lòng chọn lớp thực hành cho lớp học phần này");
                        is_check = false;
                        return false;
                    } else {
                        is_check = true;
                    }
                }
                if (is_check) {
                    $.post(base_url + "sinhvien/chon_lop_hp/", {
                        'id_lophp': id_lophp,
                        'id_thuchanh': id_lop_thuchanh
                    }, function(data) {
                        if (data.error == 0) {
                            $.fancybox.close();
                            window.location = url_redirect;
                        } else {
                            jAlert(data.msg);
                        }
                    }, 'json')
                }
                /*
                $.post(base_url + "sinhvien/chon_lop_hp/",{'id_lophp':id_lophp},function(data){
                    if(data.error == 0){
                        $.fancybox.close();
                        window.location = base_url+"sinhvien/dangky";
                    }else{
                        jAlert(data.msg);
                    }
                },'json')*/
            }
        }

        $.post(base_url + "sinhvien/chon_lop_hp/", {
            'id_lophp': '1432',
            'id_thuchanh': '1'
        }, function() {

        }, 'json').then(function() {
            window.location = base_url + "sinhvien/dangkylophp";
        })