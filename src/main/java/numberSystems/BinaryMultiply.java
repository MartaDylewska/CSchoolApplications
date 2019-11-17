package numberSystems;

public class BinaryMultiply {

    public static String showBinaryMultiplyResult(String binaryNum1, String binaryNum2){
        return "Multiplication result: " + multiplyTwoBinaryNumbers(binaryNum1,binaryNum2);
    }

    public static String[] sortBinaryNumbersByLength(String binaryNum1, String binaryNum2){
        String shorterBinNumber;
        String longerBinNumber;

        if(binaryNum1.length()>binaryNum2.length()){
            shorterBinNumber = binaryNum2;
            longerBinNumber = binaryNum1;
        }

        else {
            shorterBinNumber = binaryNum1;
            longerBinNumber = binaryNum2;
        }

        return new String[]{shorterBinNumber,longerBinNumber};
    }
    public static String multiplyTwoBinaryNumbers(String binaryNum1, String binaryNum2){

        String shorterBinNumber = sortBinaryNumbersByLength(binaryNum1,binaryNum2)[0];
        String longerBinNumber = sortBinaryNumbersByLength(binaryNum1,binaryNum2)[1];

        //----------TWORZENIE WIERSZA ZEROWEGO--------
        //----WIERSZ ZEROWY WSTAWIANY GDY CYFRA JEST MNOŻONA PRZEZ 0----------

        String zeroesBinary = "";

        for(int i = 0; i< longerBinNumber.length();i++){
            zeroesBinary +="0";
        }

        String[] tabOfResults = new String[shorterBinNumber.length()];
        String result = "";
        for(int j = shorterBinNumber.length()-1; j>=0;j--){
            if(shorterBinNumber.charAt(j) == '0'){
                result = zeroesBinary;
                for(int k = shorterBinNumber.length()-1; k>j;k--){
                    result+="0";
                }

            }
            else {
                result = longerBinNumber;
                for (int k = shorterBinNumber.length()-1; k>j;k--) {
                    result += "0";
                }
            }
            tabOfResults[j] = result;
        }

        String finalResult = "0";
        for(int i = 0; i<tabOfResults.length;i++) {
            finalResult = BinaryAdd.addTwoBinaryNums(finalResult, tabOfResults[i]);
        }

        return finalResult;
    }

}
