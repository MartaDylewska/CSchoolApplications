package numberSystems;

public class BinarySubtract {

    public static String showBinarySubtractionResult(String binaryNum1, String binaryNum2){
        return "Subtraction result: " + subtractTwoBinaryNums(binaryNum1,binaryNum2);
    }

    public static String subtractTwoBinaryNums(String binaryNum1, String binaryNum2){

        String firstBinChain = sortEnteredNumbers(binaryNum1,binaryNum2)[0];
        String secondBinChain = sortEnteredNumbers(binaryNum1,binaryNum2)[1];


        int[] firstIntBinChain = createIntArrFromBinString(secondBinChain);
        int[] secondIntBinChain = createIntArrFromBinString(firstBinChain);


        int rest = 0;
        int subtr;
        String result = "";

        for(int j = secondBinChain.length()-1; j >= 0;j--){
            subtr = firstIntBinChain[j] - secondIntBinChain[j] + rest;

            if(subtr == -1){
                rest = -1;
                result=1 + result;
            }
            else if (subtr == 0) {
                rest = 0;
                result=0 + result;
            }
            else if (subtr == 1){
                rest = 0;
                result =1 + result;
            }
            else if (subtr == -2){
                rest = -1;
                result = 0 + result;
            }

        }

        String finalResult = removeZeroes(result);

        return finalResult;

    }

    //-----UKLADA WARTOSCI W TABLICE [0] = MNIEJSZA, [1] = WIEKSZA--------------
    public static String[] sortEnteredNumbers(String binaryNum1, String binaryNum2){

        String[] sortedNums;

        if(binaryNum1.length() != binaryNum2.length()){
            sortedNums = makeBinaryNumsEqualLength(binaryNum1,binaryNum2);
        }
        else {
            sortedNums = checkBiggerBinNum(binaryNum1,binaryNum2);
        }

        return sortedNums;
    }

    public static String[] makeBinaryNumsEqualLength(String binaryNum1, String binaryNum2){

        String longerBinChain;
        String shorterBinChain;

        if(binaryNum1.length()>=binaryNum2.length()){
            longerBinChain = binaryNum1;
            shorterBinChain = binaryNum2;
        }
        else {
            longerBinChain = binaryNum2;
            shorterBinChain = binaryNum1;
        }

        String extraZeroes = "";
        int count = longerBinChain.length() - shorterBinChain.length();

        if(count!=0)
            for(int i = 0;i < count;i++)
                extraZeroes+=0;

        String shorterBinChain2 = extraZeroes + shorterBinChain;

        return new String[] {shorterBinChain2,longerBinChain};

    }

    public static int[] createIntArrFromBinString(String binNum){

        String[] strBinChain = binNum.split("");
        int[] intBinChain = new int[binNum.length()];
        for(int i = 0; i<binNum.length();i++){
            intBinChain[i] = Integer.parseInt(strBinChain[i]);
        }

        return intBinChain;
    }

    //-----ZWRACA TABLICE STRINGOW POSORTOWANYCH (TZN MNIEJSZA JEST PIERWSZA)-----------
    //PRZELICZA PO DRODZE BINARNE NA DECYMALNE
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

    public static String removeZeroes (String binaryExp){

        int i = 0;

        while(i<binaryExp.length() && binaryExp.charAt(i) == '0')
            i++;
        StringBuffer sb = new StringBuffer(binaryExp);
        sb.replace(0,i,"");

        return sb.toString();

    }


}
