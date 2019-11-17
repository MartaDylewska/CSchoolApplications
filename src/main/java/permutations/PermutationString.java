package permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationString {

    public static void showNonRepeatingPermutations(String str){
        List<String> tempStrings = new ArrayList<>();
        //dodawanie pierwszej kombinacji - jednego znaku
        tempStrings.add(str.substring(0,1));
        //dodawanie dwóch kolejnych kombinacji dwuznakowych
        tempStrings.add(str.substring(0,2));
        tempStrings.add((str.substring(1,2)+str.substring(0,1)));

        int factorialTotal = factorialNumRecurency(str.length());
        String currString = "";

        if(str.length()>=2) {
            for (int i = 2; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (i == 2) {
                    for (int j = 2; j >= 1; j--) {
                        currString = tempStrings.get(j);
                        for (int k = 0; k <= currString.length(); k++) {
                            tempStrings.add(insertCharAt(k, currString, letter));
                        }
                    }
                } else {
                    int startListIndex = calculateStartListIndex(i);
                    int endListIndex = startListIndex - factorialNumRecurency(i);

                    for (int j = startListIndex; j > endListIndex; j--) {
                        currString = tempStrings.get(j);
                        for (int k = 0; k <= currString.length(); k++) {
                            tempStrings.add(insertCharAt(k, currString, letter));
                        }
                    }
                }
            }
        }

        Set<String> finalList = new HashSet<>();
        for (int i = tempStrings.size()-1; i > tempStrings.size()-1-factorialTotal ; i--) {
            finalList.add(tempStrings.get(i));
        }
        for(String s: finalList){
            System.out.println(s);
        }

    }

    //liczenie silni
    public static int factorialNumRecurency(int limit){
        if(limit<2)
            return 1; //silnia z 0 i 1 wynosi 1
        return limit*factorialNumRecurency(limit-1);
    }
    //wstawianie nowego znaku w danym Stringu
    public static String insertCharAt(int i, String str, char letter){
        String start = str.substring(0,i);
        String end = str.substring(i);
        return start + letter + end;
    }
    //wyliczanie początkowego indeksu do pobierania stringów z listy
    public static int calculateStartListIndex(int i){
        int index = 2;
        for(int j = i; i>=3;i--){
            index += factorialNumRecurency(i);
        }
        return index;
    }

}
