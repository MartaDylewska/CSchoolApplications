package snailArray;

import java.util.Arrays;

public class SnailArray {

    public static void doSnailPrint(int size, String sign){
        String[][] tab2D = generateTab2D(size);
        snailPrint(tab2D,sign);
    }
    //wykonuje "ślimaka" na tablicy
    public static void snailPrint(String tab2D[][], String sign){
        int i;
        int rowStart=0;
        int columnStart=0;
        int rowEnd = tab2D.length;
        int columnEnd = tab2D.length;
        int count = findNUmOfSigns(tab2D);
        //w każdym przejściu zmniejszam rozmiar tablicy
        while(count>0) {
            //wypelniam pierwszy wiersz
            for(i = columnStart; i<columnEnd;i++){
                if(count>0) {
                    tab2D[rowStart][i] = sign;
                    count--;
                }
            }
            rowStart++;

            //wypelniam ostatnią kolumnę
            for(i = rowStart; i < rowEnd; i++){
                if(count>0) {
                    tab2D[i][columnEnd - 1] = sign;
                    count--;
                }
            }
            columnEnd--;

            //wypełniam ostatni wiersz
            if(rowStart < rowEnd) {
                for (i = columnEnd-1; i>= columnStart ; i--) {
                    if(count>0) {
                        tab2D[rowEnd - 1][i] = sign;
                        count--;
                    }
                }
                rowEnd--;
            }

            //wypełniam pierwszą kolumnę bez ostatniego wyrazu
            if(columnStart<columnEnd){
                for(i = rowEnd - 1; i > rowStart; i--){
                    if(count>0) {
                        tab2D[i][columnStart] = sign;
                        count--;
                    }
                }
                columnStart++;
            }
            //zaczynam zmniejszać rozmiar tablicy
            rowStart++;
            columnEnd--;
            rowEnd--;
            //wypełniam miejsce rozgraniczające tablicę wewnętrzną i zewnętrzną
            if(count>0){
                tab2D[rowStart][columnStart] = sign;
                count--;
            }
            //kończę zmniejszać rozmiar tablicy
            columnStart++;
        }
        print2Darray(tab2D);
    }
    //generuje tablicę o wielkości n x n
    public static String[][] generateTab2D(int size){
        String[][] tab2D = new String[size][size];
        for (int i = 0; i < tab2D.length; i++) {
            for (int j = 0; j <tab2D[i].length ; j++) {
                tab2D[i][j] = " ";
            }

        }
        return tab2D;
    }
    //drukuje macierz w postaci kwadratowej
    public static void print2Darray(String[][] tab2D){
        for (int i = 0; i <tab2D.length ; i++) {
            System.out.println(Arrays.toString(tab2D[i]));
        }
    }
    //znajduje liczbę znaków sign dla tablicy o danym rozmiarze
    public static int findNUmOfSigns(String[][] tab2D) {
        int tabSize = tab2D.length;
        int count = 1;
        int delta = 2;
        if (tabSize == 1)
            count = 1;
        else {
            for(int i = 2;i<=tabSize;i++){

                count+=delta;
                if(i%2 == 0){
                    delta+=2;
                }
            }
        }
        return count;
    }
}
