package numberSystems;


import static numberSystems.BinarySubtract.createIntArrFromBinString;
import static numberSystems.BinarySubtract.removeZeroes;

public class BinaryDivide {

    public static String showBinaryDivideResult(String binaryNum1, String binaryNum2){

        String[] results = divideTwoBinaryNumbers(binaryNum1,binaryNum2);
        return "Division result: " + results[0] + ", rest: " + results[1];
    }

    public static String [] divideTwoBinaryNumbers(String binaryNum1, String binaryNum2){
        //---przypisujemy wartosci dzielnej (wieksza liczba) i dzielnika (mniejsza liczba)
        String dividendBinary = checkBiggerBinNum(binaryNum1,binaryNum2)[1];
        String dividerBinary = checkBiggerBinNum(binaryNum1,binaryNum2)[0];

        int i = 0;
        String partialDividend;
        String result = "";
        String lastNumberFromDividend = "";
        String rest = "" ;
        partialDividend = dividendBinary.substring(0,dividerBinary.length());

        while(result.length()!=(dividendBinary.length()-dividerBinary.length())){

            lastNumberFromDividend = String.valueOf(dividendBinary.charAt(i+dividerBinary.length()));

            if(isDividendBigger(partialDividend,dividerBinary)){
                result+="1";
                rest = BinarySubtract.subtractTwoBinaryNums(partialDividend,dividerBinary);
                partialDividend = rest + lastNumberFromDividend;
            }
            else {
                result += "0";
                partialDividend+=lastNumberFromDividend;
                rest +=lastNumberFromDividend;
            }

          i++;

        }

        if(isDividendBigger(partialDividend,dividerBinary)) {
            result += "1";
            rest = BinarySubtract.subtractTwoBinaryNums(partialDividend,dividerBinary);
        }
        else {
            result += "0";
            rest += lastNumberFromDividend;
        }
        //wynik końcowy pozbawiony zer oraz wynik reszty wpisuję do tablicy
        String[] results = new String[]{removeZeroes(result),rest};
        return results;
    }

    public static boolean isDividendBigger(String dividendBinary, String dividerBinary ) {

        int[] nums1 = createIntArrFromBinString(dividendBinary);
        int[] nums2 = createIntArrFromBinString(dividerBinary);

        int result1 = 0;
        int result2 = 0;

        for (int i = nums1.length - 1; i >= 0; i--) {
            if (nums1[i] == 1)
                result1 += Math.pow(2.0, nums1.length - 1 - i);
        }

        for (int j = nums2.length - 1; j >= 0; j--) {
            if (nums2[j] == 1)
                result2 += Math.pow(2.0, nums2.length - 1 - j);
        }

        if (result1 >= result2)
            return true;

        return false;
    }

    public static String[] checkBiggerBinNum(String binaryNum1, String binaryNum2){


        int[] nums1 = createIntArrFromBinString(binaryNum1);
        int[] nums2 = createIntArrFromBinString(binaryNum2);

        String[] sortedNumbers = new String[2];

        int result1 = 0;
        int result2 = 0;

        for(int i = nums1.length-1;i>=0;i--){
            if(nums1[i] ==1){
                result1 +=Math.pow(2.0,nums1.length-1-i);
            }
        }

        for(int j = nums2.length-1;j>=0;j--){
            if(nums2[j] ==1){
                result2 +=Math.pow(2.0,nums2.length-1-j);
            }
        }

        if(result1>result2){
            sortedNumbers[0] = binaryNum2;
            sortedNumbers[1] = binaryNum1;
        }

        else {
            sortedNumbers[0] = binaryNum1;
            sortedNumbers[1] = binaryNum2;
        }

        return sortedNumbers;


    }
}
