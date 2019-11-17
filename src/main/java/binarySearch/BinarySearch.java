package binarySearch;

public class BinarySearch {

    public static int doBinarySearch(int elToFind, int[] sortedArray){

        //początkowe wartości granic przedziału równe rozmiarowi tablicy
        int leftBoundary = 0;
        int rightBoundary = sortedArray.length;

        //obecny index, dla którego poszukujemy liczby
        int currIndex;
        int indexToFind = -1;

        boolean ifEquals = false;

        while(ifEquals==false || (leftBoundary - rightBoundary)==1){

            currIndex = (leftBoundary+rightBoundary)/2;

            if( elToFind == sortedArray[currIndex]){
                ifEquals = true;
                indexToFind = currIndex;
            }

            else if (elToFind > sortedArray[currIndex]){
                leftBoundary = currIndex;
            }

            else {
                rightBoundary = currIndex;
            }
        }
        return indexToFind;

    }
}
