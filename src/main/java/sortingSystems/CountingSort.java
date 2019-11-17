package sortingSystems;

import java.util.Arrays;

public class CountingSort {

    public static int[] doCountingSort(int[] tabOfInts) {
        int intMax = getMaxValue(tabOfInts);
        int intMin = getMinValue(tabOfInts);

        int[] subTable = createSubsidaryTable(intMax, intMin);
        int[] indexTable = createIndexTable(tabOfInts, subTable);
        int[] sumTable = createSumTable(indexTable);
        int[] finalTable = createFinalTable(tabOfInts, subTable, sumTable);

        return finalTable;

    }

    public static int[] createFinalTable(int[] enteredTable, int[] subsidaryTable, int[] sumTable) {
        int[] finalTable = new int[enteredTable.length];
        int indexFromSubsidaryTable = 0;
        for (int i = 0; i < enteredTable.length; i++) {
            for (int j = 0; j < subsidaryTable.length; j++) {
                if (enteredTable[i] == subsidaryTable[j]) {
                    indexFromSubsidaryTable = j;
                }

            }
            int elemFromSumTable = sumTable[indexFromSubsidaryTable];
            int newPositionForFinalTable = elemFromSumTable - 1;
            finalTable[newPositionForFinalTable] = enteredTable[i];
            sumTable[indexFromSubsidaryTable] -= 1;

        }

        return finalTable;
    }

    public static int[] createSumTable(int[] indexTable) {
        int[] sumTable = new int[indexTable.length];

        int result = indexTable[0];
        sumTable[0] = result;

        for (int i = 1; i < indexTable.length; i++) {
            result += indexTable[i];
            sumTable[i] = result;
        }

        return sumTable;
    }

    public static int[] createIndexTable(int[] enteredTable, int[] subsidaryTable) {

        int count = 0;
        int[] indexTable = new int[subsidaryTable.length];

        for (int i = 0; i < subsidaryTable.length; i++) {
            for (int j = 0; j < enteredTable.length; j++) {
                if (enteredTable[j] == subsidaryTable[i]) {
                    count++;
                }


            }
            indexTable[i] = count;
            count = 0;

        }
        return indexTable;

    }

    public static int getMaxValue(int[] numbers) {
        int maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }

    public static int getMinValue(int[] numbers) {
        int minValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        return minValue;
    }

    public static int[] createSubsidaryTable(int maxVal, int minVal) {
        int count = maxVal - minVal + 1;
        int[] subTable = new int[count];
        int val1 = minVal;
        for (int i = 0; i < subTable.length; i++) {
            subTable[i] = val1;
            val1++;
        }

//System.out.println(Arrays.toString(subTable));
        return subTable;
    }
}
