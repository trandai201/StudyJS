var dem = 0;

var name = JSON.parse(localStorage.getItem('nameUser')).name
var nameUs = document.getElementById('us')
 nameUs.innerText = nameUs.textContent +" "+ name;


function them() {
    var name = document.getElementById("name")
    var phone = document.getElementById("phone")
     x = 'xoa("person-'+String(dem)+'")'
    
    var str =         '      <div  id="person-'+dem+'" class="row">    <div class="col-lg-9 row">       <div class=" col-lg-8">'+name.value+'</div>      <div class=" col-lg-4">'+phone.value+'</div> </div>   <div class="col-lg-3">       <div class="col-auto">          <button type="button" onclick="" class="btn btn-primary mb-2">Gọi</button>        <button type="button" onclick='+x+' class="btn btn-primary mb-2">Xóa</button></div>         </div>                    </div>'


    dem++
    var m = document.getElementById('as')
    m.innerHTML =  str+m.innerHTML
    name.value  =""
    phone.value  =""

}
function xoa(id){
    
    console.log('1'+typeof str)

    console.log(id)
    var temp  = document.getElementById(id)
    temp.remove()
}