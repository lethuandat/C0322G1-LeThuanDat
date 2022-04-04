let inputWidth;
let inputHeight;

inputWidth = prompt("Enter the width");
inputHeight = prompt("Enter the height");

let width = parseInt(inputWidth);
let height = parseInt(inputHeight);

document.write("The width is: </br>" + width);
document.write("<br> The height is: </br>" + height);

let area = width * height;
document.write("<br> The area is: " + area);