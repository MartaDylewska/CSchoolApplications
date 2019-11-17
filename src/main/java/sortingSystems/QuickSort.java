package sortingSystems;

import java.util.Arrays;

public class QuickSort {

    public static int[] doQuickSort(int[] enteredNumbers){
        int n = enteredNumbers.length-1;
        int[] newArr = doMyQuickSort(enteredNumbers,0,n);
        return newArr;
        //return Arrays.toString(newArr);
    }

    public static int[] doMyQuickSort(int[] enteredNumbers, int low, int high){
        if(low<high){
            int pi = partition(enteredNumbers, low, high);
            doMyQuickSort(enteredNumbers, low, pi-1);
            doMyQuickSort(enteredNumbers, pi+1,high);
        }
        return enteredNumbers;

    }

    private static int partition(int[] enteredNumbers, int low, int high){
        int pivot  = enteredNumbers[high];
        int i = low - 1;
        for(int j = low; j<high;j++){
            if(enteredNumbers[j]<=pivot){
                i++;
                int temp = enteredNumbers[i];
                enteredNumbers[i] = enteredNumbers[j];
                enteredNumbers[j] = temp;
            }
        }

        int tempFinal = enteredNumbers[i+1];
        enteredNumbers[i+1] = enteredNumbers[high];
        enteredNumbers[high] = tempFinal;

        return i+1;
    }
}
