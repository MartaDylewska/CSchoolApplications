package xmasTree;

public class TreeWithNumbers {

    public static void printTree(int limit) {

        int count = 1;
        StringBuilder sbOdd = new StringBuilder();
        sbOdd.append(count);

        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit * 2; j++) {
                StringBuilder sbReverse = new StringBuilder(sbOdd).reverse();
                if (j < (limit - i) || j > (limit + i)) {
                    System.out.print(" ");
                } else if (i == 0) {
                    System.out.print(count);
                } else if (i % 2 != 0 && j == limit - i) {
                    System.out.print(sbOdd + " " + sbReverse);
                } else if (i % 2 == 0 && j == limit - i) {
                    count++;
                    System.out.print(sbOdd + " " + count + " " + sbReverse);
                    sbOdd.append(" ").append(count);

                }
            }
            System.out.println();
        }
    }

    public static void printXmasTreeWithNumbers(int size) {
        int endOfLine = 1;
        int countOdd = 1;
        int countEven = 2;
        int freeSpace = size;

        if (size <= 0)
            System.out.println();
        else {
            for (int row = 1; row <= size; row++) {
                int currentNumber = 0;
                for (int col = 1; col <= freeSpace; col++) {
                    System.out.print(" ");
                }
                for (int col = 1; col <= endOfLine; col++) {
                    if (row % 2 != 0) {
                        if (col <= countOdd)
                            currentNumber++;
                        else
                            currentNumber--;
                    } else {
                        if (col < countEven)
                            currentNumber++;
                        else if (col > countEven)
                            currentNumber--;
                    }
                    System.out.print(currentNumber + " ");
                }
                System.out.println();
                endOfLine++;
                freeSpace--;
                if (row % 2 != 0) {
                    countOdd++;
                } else {
                    countEven++;
                }
            }
        }
    }
}
