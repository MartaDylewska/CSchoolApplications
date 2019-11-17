package sortingSystems;

import java.util.Arrays;

public class InsertionSort {

    public static String doInsertionSort(int[] enteredNumbers){
        return Arrays.toString(doMyInsertionSort(enteredNumbers));
    }

    public static int[] doMyInsertionSort(int[] enteredNumbers){

        int tabLength = enteredNumbers.length;

       int[] sortedNums = new int[tabLength];
        if(enteredNumbers[1]>enteredNumbers[0]){
            sortedNums[0] = enteredNumbers[0];
            sortedNums[1] = enteredNumbers[1];
        }
        else {
            sortedNums[1] = enteredNumbers[0];
            sortedNums[0] = enteredNumbers[1];
        }

        int currElem;

        for(int i = 2; i<tabLength;i++){
            currElem = enteredNumbers[i];
            int j = i-1;
                while (currElem<sortedNums[j] && j>=0){
                    sortedNums[j+1] = sortedNums[j];
                    j = j-1;
                }
                sortedNums[j+1] = currElem;
            }


        return sortedNums;
    }
}
