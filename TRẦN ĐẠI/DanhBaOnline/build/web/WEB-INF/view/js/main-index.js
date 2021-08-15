
var listAccount = JSON.parse(localStorage.getItem('listAccount'))
console.log(listAccount)


function doLogin(){
  console.log('sai ')
  var name = document.getElementById("name")
  var pass = document.getElementById("pass")
  for(let t of listAccount){
    if(t.name == name.value && t.pass == pass.value){
        var nameUser = {
          name : name.value
        }
        localStorage.setItem('nameUser',JSON.stringify(nameUser))

        window.location.href = "/home.html";
    }
  }
  var p = document.getElementById('p')
  p.innerText = 'Sai mật khẩu hoặc tên đăng nhập'

}


function addAccount(){
  var nameNewAccount = document.getElementById("nameNewAccount")
  var passwordNewAccount = document.getElementById("passwordNewAccount")
  var repasswordNewAccount = document.getElementById("repasswordNewAccount")
  var er = document.getElementById("error")
  for(let temp of listAccount){
    if(nameNewAccount.value == temp.name){
      er.innerText = "Đã trùng tên với tài khoản trước đó"
    }else{
      if(passwordNewAccount.value != repasswordNewAccount.value ){
        er.innerText = "mật khẩu không khớp"
      }else{
        var us = {
          name :  nameNewAccount.value,
          pass : passwordNewAccount.value
        }
        listAccount.push(us)
        localStorage.setItem('listAccount',JSON.stringify(listAccount))

      $("#notification").animate({top : '-232px'},600).animate({top : '-232px'},600).animate({top : '-700px'},600)
    setTimeout(() => {location.reload();  }, 1800);      
    return   
      }
    }
  }
   


    //   $("#notification").animate({top : '-232px'},600).animate({top : '-232px'},600).animate({top : '-700px'},600)
    // setTimeout(() => {location.reload();  }, 1800); 


}