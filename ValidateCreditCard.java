package test.java.com.example.demo;

public class ValidateCreditCard {
    // Main Method
    public static void main(String[] args) {
        String cardNumber = "4440-9674-8418-1607";
        String cardNo = cardNumber.replace("-", "").trim();
        System.out.println(cardNumber + " is " + (validityCheck(Long.parseLong(cardNo)) ? "valid" : "invalid"));
    }

    // Return true if the card number is valid
    public static boolean validityCheck(Long cardNumber) {
        return (isValidSize(cardNumber) >= 13 && isValidSize(cardNumber) <= 16) && (prefixMatch(cardNumber, 4)
                || prefixMatch(cardNumber, 5) || prefixMatch(cardNumber, 37) || prefixMatch(cardNumber, 6))
                && ((sumDoubleEven(cardNumber) + sumOdd(cardNumber)) % 10 == 0);
    }

    //  Starting from right to left of the card number add all the digits at the odd places.
    public static int sumDoubleEven(long cardNumber) {
        int sum = 0;
        String num = cardNumber + "";
        for (int i = isValidSize(cardNumber) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        return sum;
    }

    // Return this cardNumber if it is a single digit, otherwise,
    // return the sum of the two digits
    public static int getDigit(int cardNumber) {
        if (cardNumber < 9)
            return cardNumber;
        return cardNumber / 10 + cardNumber % 10;
    }

    // Return sum of odd-place digits in cardNumber
    public static int sumOdd(long cardNumber) {
        int sum = 0;
        String num = cardNumber + "";
        for (int i = isValidSize(cardNumber) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }

    // Return true if the digit d is a prefix for cardNumber
    public static boolean prefixMatch(long cardNumber, int d) {
        return getPrefix(cardNumber, isValidSize(d)) == d;
    }

    // Return the number of digits in d
    public static int isValidSize(long d) {
        String num = d + "";
        return num.length();
    }

    // Return the first k number of digits from
    // number. If the number of digits in number
    // is less than k, return number.
    public static long getPrefix(long cardNumber, int k) {
        if (isValidSize(cardNumber) > k) {
            String num = cardNumber + "";
            return Long.parseLong(num.substring(0, k));
        }
        return cardNumber;
    }

}
