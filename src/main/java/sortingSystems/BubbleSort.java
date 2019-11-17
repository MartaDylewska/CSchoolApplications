package sortingSystems;

public class BubbleSort {

    public static int[] doBubbleSort(int[] tabOfInts){

        for (int i = 0; i < tabOfInts.length; i++)
            for (int j = 0; j < tabOfInts.length-i-1 ; j++) {
                int temp = tabOfInts[j];
                if(tabOfInts[j]>tabOfInts[j+1]){
                    tabOfInts[j] = tabOfInts[j+1];
                    tabOfInts[j+1] = temp;
                }
            }


        return tabOfInts;
    }
}
