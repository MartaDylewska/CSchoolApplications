package sortingSystems;

import java.util.Arrays;

public class SelectionSort {

    public static String doSelectionSort(int[] enteredNumbers){
        return Arrays.toString(doMySelectionSort(enteredNumbers));
    }

    public static int[] doMySelectionSort(int[] enteredNumbers){

        int currentMinVal;
        int currIndex;

        for (int i = 0; i < enteredNumbers.length ; i++) {
            int temp = enteredNumbers[i];
            currentMinVal = getMinValue(enteredNumbers,i);
            currIndex = getArrayIndex(enteredNumbers,currentMinVal,i);

            if(temp != currentMinVal){
                enteredNumbers[i] = currentMinVal;
                enteredNumbers[currIndex] = temp;
            }

        }
        return enteredNumbers;
    }

    public static int getMinValue(int[] numbers, int i) {
        int minValue = numbers[i];
        for (int j = i; j < numbers.length; j++) {
            if (numbers[j] < minValue) {
                minValue = numbers[j];
            }
        }
        return minValue;
    }

    public static int getArrayIndex(int[] tab,int elementValue, int j) {

        int indexOfElement=0;
        for(int i=j;i<tab.length;i++){

            if(tab[i]==elementValue){
                indexOfElement=i;
                break;
            }
        }
        return indexOfElement;
    }

}
