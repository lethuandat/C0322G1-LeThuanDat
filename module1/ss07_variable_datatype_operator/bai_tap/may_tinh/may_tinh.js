function add() {
    let a = parseFloat(document.getElementById("number1").value);
    let b = parseFloat(document.getElementById("number2").value);
    let cSum = a + b;
    document.getElementById("result").innerText = "Kết quả: " + a + " cộng " + b + " = " +  cSum;
}
function sub() {
    let a = parseFloat(document.getElementById("number1").value);
    let b = parseFloat(document.getElementById("number2").value);
    let cSub = a - b;
    document.getElementById("result").innerText = "Kết quả: " + a + " trừ " + b + " = " +  cSub;
}
function mul() {
    let a = parseFloat(document.getElementById("number1").value);
    let b = parseFloat(document.getElementById("number2").value);
    let cMul = a * b;
    document.getElementById("result").innerText = "Kết quả: " + a + " nhân " + b + " = " +  cMul;
}
function div() {
    let a = parseFloat(document.getElementById("number1").value);
    let b = parseFloat(document.getElementById("number2").value);
    let cDiv = a /b ;
    document.getElementById("result").innerText = "Kết quả: " + a + " chia " + b + " = " + cDiv;
}