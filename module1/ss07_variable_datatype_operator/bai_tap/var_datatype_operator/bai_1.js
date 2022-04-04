let inputpPhys, inputpChem, inputpBio;

inputpPhys = prompt("Enter the Physical point");
inputpChem = prompt("Enter the Chemistry point");
inputpBio = prompt("Enter the Biology point");

let Phys = parseInt(inputpPhys);
let Chem = parseInt(inputpChem);
let Bio = parseInt(inputpBio);

document.write("Điểm Lý là: " + Phys);
document.write("<br>Điểm Hóa là: " + Chem);
document.write("<br>Điểm Sinh là: " + Bio);

let total = Phys + Chem + Bio;
document.write("<br>Tổng điểm là: " + total);

let average = total / 3;
document.write("<br>Điểm trung bình là: " + average);



