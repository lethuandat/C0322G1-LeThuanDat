package utils;

public class MyException {
    public static void checkNegativeNumber(int numb) throws NegativeNumberException{
        if (numb < 0) {
            throw new NegativeNumberException("Cannot enter the negative number.");
        }
    }
}
