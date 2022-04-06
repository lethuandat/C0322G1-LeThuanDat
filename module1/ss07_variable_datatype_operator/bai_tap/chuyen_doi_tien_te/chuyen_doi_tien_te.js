function convertFunction() {
    //Lấy giá trị ô From Currency
        let FromCur = document.getElementById("FromCur").value;
    //Lấy giá trị ô To Currency
        let ToCur = document.getElementById("ToCur").value;
    //Lấy giá trị ô Amount
        let amountCur = document.getElementById("amount").value;
    if (FromCur == ToCur)
    {
        document.getElementById("resultCurrency").innerHTML = "Result = " + amountCur + " " + ToCur;
    }
    if (FromCur === "USD" && ToCur === "VND")
    {
        document.getElementById("resultCurrency").innerHTML = "Result = " + amountCur * 23000 + " " + ToCur;
    }
    if (FromCur === "VND" && ToCur === "USD")
    {
        document.getElementById("resultCurrency").innerHTML = "Result = " + amountCur / 23000 + " " + ToCur;
    }

}
