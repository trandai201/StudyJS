var banPhim = [
    ["1", "2", "3"],
    ["4", "5", "6"],
    ["7", "8", "9"],
    ["*", "2", "t"], // chết rồi em bị đau đầu :((((((((()))))))))
]
banPhim.

var container = document.getElementById('container') // em thấy đmmm
for (var x of banPhim) {
    var div = document.createElement("div");
    for (var s of x) {
        var btn = document.createElement("button");
        btn.textContent = s
        div.appendChild(btn);
    }

    container.appendChild(div)

}