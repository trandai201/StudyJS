var font = document.getElementById("inputState");
var text = document.getElementById("exampleFormControlTextarea1");
var b = document.getElementById("buttonBold");
var i = document.getElementById("buttonItalic");
var u = document.getElementById("buttonUnderLine");
var colorPicker = document.getElementById("exampleColorInput");
var s = document.getElementById("selectSize");
var radioButton = document.getElementsByName('options')
var areaRadioButton = document.getElementById('areaRadioButton')
var post = document.getElementById('post')

function changeFont() {
	text.style.fontFamily = font.value;
}
function boldUp() {
	if (b.className == "btn btn-light") {
		text.style.fontWeight = "bold"
		b.className = "btn btn-primary"
	} else {
		text.style.fontWeight = ""
		b.className = "btn btn-light"
	}

}

function italics() {
	if (i.className == "btn btn-light") {
		text.style.fontStyle = "italic"
		i.className = "btn btn-primary"
	} else {
		text.style.fontStyle = ""
		i.className = "btn btn-light"
	}

} function underLine() {
	if (u.className == "btn btn-light") {
		text.style.textDecorationLine = "underline"
		u.className = "btn btn-primary"
	} else {
		text.style.textDecorationLine = ""
		u.className = "btn btn-light"
	}

}

function changeColor() {
	text.style.color = colorPicker.value

}

function changeSize() {
	text.style.fontSize = s.value + "px"

}


function changeAlignLeft() {
	text.style.textAlign = 'left'

}
function changeAlignRight() {
	text.style.textAlign = 'right'

}
function changeAlignCenter() {
	text.style.textAlign = 'center'
	hukm();

}
function hukm() {
	// var p = document.createElement('p');
	// p.style.fontFamily = text.style.fontFamily;
	// p.style.fontWeight = text.style.fontWeight;
	// p.style.fontStyle = text.style.fontStyle;
	// p.style.textDecorationLine = text.style.textDecorationLine;
	// p.style.color = text.style.color;
	// p.style.fontSize = text.style.fontSize;
	// p.style.textAlign = text.style.textAlign;
	// p.textContent = text.value
	return p = {
		fontFamily : text.style.fontFamily,
		fontWeight   : text.style.fontWeight,
		fontStyle  :  text.style.fontStyle,
		textDecorationLine  :  text.style.textDecorationLine,
		color  :  text.style.color,
		fontSize  : text.style.fontSize,
		textAlign  :  text.style.textAlign,
		text : 	text.value
	};

}

function postUp() {
	let ct = document.getElementById('content')
	console.log(hukm())
	localStorage.setItem('head', JSON.stringify(hukm()))
	localStorage.setItem('content',ct.value)
	window.location="home.html"

}



radioButton[0].addEventListener('click', changeAlignLeft)
radioButton[2].addEventListener('click', changeAlignRight)
radioButton[1].addEventListener('click', changeAlignCenter)
font.addEventListener("change", changeFont);
b.addEventListener('click', boldUp)
i.addEventListener('click', italics)
u.addEventListener('click', underLine)
colorPicker.addEventListener('input', changeColor)
s.addEventListener("change", changeSize);
post.addEventListener('click', postUp)







