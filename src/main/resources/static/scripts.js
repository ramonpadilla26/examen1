
var colorButton = document.getElementById("color");
var colorDiv = document.getElementById("color_val");
colorButton.onchange = function() {
    colorDiv.innerHTML = colorButton.value;
    colorDiv.style.color = colorButton.value;
}

