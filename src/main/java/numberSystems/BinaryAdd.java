package numberSystems;


public class BinaryAdd {

    public static String showBinaryAddResult(String binaryNum1, String binaryNum2){
        return "Addition result: " + addTwoBinaryNums(binaryNum1,binaryNum2);
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

    public static String addTwoBinaryNums (String binaryNum1, String binaryNum2){

        String shorterBinChain = makeBinaryNumsEqualLength(binaryNum1,binaryNum2)[0];
        String longerBinChain = makeBinaryNumsEqualLength(binaryNum1,binaryNum2)[1];

        String[] firstStrBinChain = longerBinChain.split("");

        String[] secondStrBinChain = shorterBinChain.split("");

        int[] firstIntBinChain = new int[longerBinChain.length()];
        for(int i = 0; i<longerBinChain.length();i++){
            firstIntBinChain[i] = Integer.parseInt(firstStrBinChain[i]);
        }

        int[] secondIntBinChain = new int[shorterBinChain.length()];
        for(int i = 0; i<shorterBinChain.length();i++){
            secondIntBinChain[i] = Integer.parseInt(secondStrBinChain[i]);
        }

        int rest = 0;
        int sum;
        String result = "";

        for(int j = longerBinChain.length()-1; j >= 0;j--){
            sum = firstIntBinChain[j] + secondIntBinChain[j] + rest;

            if(sum == 0){
                rest = 0;
                result=0 + result;
            }
            else if (sum == 1) {
                rest = 0;
                result=1 + result;
            }
            else if (sum == 2){
                rest = 1;
                result =0 + result;
            }
            else {
                rest = 1;
                result =1 + result;
            }
        }

        if(rest==1){
            result = "1" + result;
        }
        return result;

    }


}
