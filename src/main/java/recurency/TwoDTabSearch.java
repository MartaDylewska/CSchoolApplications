package recurency;

//zadanie - za pomocą konsoli przeszukujemy całą tablicę 2D i wypisujemy wszystkie wartości z komentarzem
//dodatni, ujemny, wynosi 0;

public class TwoDTabSearch {

    public static void doRecursiveSearch(int[][] tab, int row, int col) {

        int long_row = tab.length;
        int long_col = tab[tab.length - 1].length;

        //zabezpieczenie przed przekroczeniem końca tablicy
        if (row < long_row && col < long_col) {
            if (tab[row][col] == 0) {
                System.out.println("Wartość " + tab[row][col] + " wynosi 0");
            } else if (tab[row][col] < 0) {
                System.out.println("Wartość " + tab[row][col] + " ujemna");
            } else if (tab[row][col] > 0) {
                System.out.println("Wartość " + tab[row][col] + " dodatnia");
            }
            //dopóki nie dojdzie do końca danego wiersza to zwiększa kolumny o 1
            if (col + 1 <= long_row) {
                doRecursiveSearch(tab, row, col + 1);
            //na koniec kolumny się zerują i zaczynamy od początku kolejnego wiersza
            } else if (row + 1 < long_col) {
                doRecursiveSearch(tab, row + 1, 0);
            }
        }
    }

    //metoda sprawdzająca - zwykła iteracja po liczbach

    public static void search2DTab(int[][] tab) {
        int k = tab.length;
        int j = tab[k - 1].length;

        //System.out.println("k: " + k + ", j: " + j);
        for (int i = 0; i < k; i++) {
            for (int z = 0; z < j; z++) {
                if (tab[i][z] == 0) {
                    System.out.println("Wartość [" + i + "][" + z + "] rowna 0");
                } else if (tab[i][z] > 0) {
                    System.out.println("Wartość [" + i + "][" + z + "] większa od 0");
                } else {
                    System.out.println("Wartość [" + i + "][" + z + "] mniejsza od 0");
                }
            }

        }
    }
}
