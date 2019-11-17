package numberSystems;
import java.util.HashMap;
import java.util.Map;

public class HybridConvertions {

    public static String convertBinToOct (String binaryNum){

        StringBuilder sb = new StringBuilder();
        String triplet = "";
        while (binaryNum.length()%3!=0){
            binaryNum = 0+binaryNum;
        }

        Map<String,String> mapOfBinNums= createMapForBinToOct();

        for(int i = 0; i<binaryNum.length();i+=3) {
            triplet = binaryNum.substring(i,i+3);
            if(mapOfBinNums.containsKey(triplet)){
                sb.append(mapOfBinNums.get(triplet));
            }
        }

        return removeZeroes(sb.toString());
    }

    public static String convertBinToHex (String binaryNum){
        StringBuilder sb = new StringBuilder();
        String quadruplet = "";
        while (binaryNum.length()%4!=0){
            binaryNum = 0+binaryNum;
        }

        Map<String,String> mapOfDecNums= createMapForBinToHex();


        for(int i = 0; i<binaryNum.length();i+=4) {
            quadruplet = binaryNum.substring(i,i+4);
            if(mapOfDecNums.containsKey(quadruplet)){
                sb.append(mapOfDecNums.get(quadruplet));
            }
        }

        return removeZeroes(sb.toString());

    }

    public static String convertHexToBin (String hexNum){

        StringBuilder sb = new StringBuilder();

        Map<String,String> mapOfHexNums= createMapForHexToBin();

        for(int i = 0; i<hexNum.length();i++) {
            String currentChar = String.valueOf(hexNum.charAt(i));
            if(mapOfHexNums.containsKey(currentChar)){
                sb.append(mapOfHexNums.get(currentChar));
            }
        }

        return removeZeroes(sb.toString());

    }

    public static String convertHexToOct (String hexNum){

        String HexConvToBin = convertHexToBin(hexNum);

        String result = convertBinToOct(HexConvToBin);

        return result;
    }

    public static String convertOctToBin (String octNum){

        StringBuilder sb = new StringBuilder();

        Map<String,String> mapOfOctNums= createMapForOctToBin();

        for(int i = 0; i<octNum.length();i++) {
            String currentChar = String.valueOf(octNum.charAt(i));
            if(mapOfOctNums.containsKey(currentChar)){
                sb.append(mapOfOctNums.get(currentChar));
            }
        }

        return removeZeroes(sb.toString());
    }

    public static String convertOctToHex (String octNum){

        String OctConvToBin = convertOctToBin(octNum);

        String result = convertBinToHex(OctConvToBin);

        return result;
    }

    public static String removeZeroes (String binaryExp){

        int i = 0;

        while(i<binaryExp.length() && binaryExp.charAt(i) == '0')
            i++;
            StringBuffer sb = new StringBuffer(binaryExp);
            sb.replace(0,i,"");

        return sb.toString();

    }

    public static Map<String,String> createMapForBinToOct(){

        Map<String,String> mapOfDecNums= new HashMap<>();
        mapOfDecNums.put("000","0");
        mapOfDecNums.put("001","1");
        mapOfDecNums.put("010","2");
        mapOfDecNums.put("011","3");
        mapOfDecNums.put("100","4");
        mapOfDecNums.put("101","5");
        mapOfDecNums.put("110","6");
        mapOfDecNums.put("111","7");

        return mapOfDecNums;
    }

    public static Map<String,String > createMapForBinToHex(){

        Map<String,String> mapOfDecNums= new HashMap<>();
        mapOfDecNums.put("0000","0");
        mapOfDecNums.put("0001","1");
        mapOfDecNums.put("0010","2");
        mapOfDecNums.put("0011","3");
        mapOfDecNums.put("0100","4");
        mapOfDecNums.put("0101","5");
        mapOfDecNums.put("0110","6");
        mapOfDecNums.put("0111","7");
        mapOfDecNums.put("1000","8");
        mapOfDecNums.put("1001","9");
        mapOfDecNums.put("1010","A");
        mapOfDecNums.put("1011","B");
        mapOfDecNums.put("1100","C");
        mapOfDecNums.put("1101","D");
        mapOfDecNums.put("1110","E");
        mapOfDecNums.put("1111","F");

        return mapOfDecNums;
    }

    public static Map<String,String > createMapForHexToBin(){

        Map<String,String> mapOfHexNums= new HashMap<>();
        mapOfHexNums.put("0","0000");
        mapOfHexNums.put("1","0001");
        mapOfHexNums.put("2","0010");
        mapOfHexNums.put("3","0011");
        mapOfHexNums.put("4","0100");
        mapOfHexNums.put("5", "0101");
        mapOfHexNums.put("6", "0110");
        mapOfHexNums.put("7","0111");
        mapOfHexNums.put("8","1000");
        mapOfHexNums.put("9","1001");
        mapOfHexNums.put("A","1010");
        mapOfHexNums.put("B","1011");
        mapOfHexNums.put("C","1100");
        mapOfHexNums.put("D","1101");
        mapOfHexNums.put("E","1110");
        mapOfHexNums.put("F","1111");

        return mapOfHexNums;
    }

    public static Map<String,String> createMapForOctToBin(){
        Map<String,String> mapOfBinNums= new HashMap<>();
        mapOfBinNums.put("0","000");
        mapOfBinNums.put("1","001");
        mapOfBinNums.put("2","010");
        mapOfBinNums.put("3","011");
        mapOfBinNums.put("4","100");
        mapOfBinNums.put("5","101");
        mapOfBinNums.put("6","110");
        mapOfBinNums.put("7","111");

        return mapOfBinNums;
    }
}
