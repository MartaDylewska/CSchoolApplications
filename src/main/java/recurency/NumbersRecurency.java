package recurency;

//różne zadania rekurencyjne

public class NumbersRecurency {

    // 3, 10
    //drukowanie po kolei  liczby start + kroki tyle razy ile pokazuje ilość
   public static void sysout3(int start, int krok, int ilosc){
       if(ilosc >= 0){
           System.out.println(start);
           sysout3(start+ krok,krok, ilosc-1);

       }
    }

    //liczenie liczby cyfr w danej liczbie int
   /* public static void recurencyCount(int numberToExamine, int sum){
       if(numberToExamine!=0){
           recurencyCount(numberToExamine/10,sum+=1);
       }
       if(numberToExamine == 0){
           System.out.println(sum);
       }
    }
*/
    public static int recurencyCount(int numberToExamine){

       if(numberToExamine==0){
           return 0;
       }
        return recurencyCount(numberToExamine/10)+1;
    }

    //liczy sumę cyfr w liczbie zadanej jako numberToExamine
    public static int recurencySum(int numberToExamine){
        if(numberToExamine< 10)
            return numberToExamine;
        return numberToExamine%10 +recurencyCount(numberToExamine/10);
    }

    //liczenie silni
    public static int strongNumRecurency(int limit){
        if(limit<2)
            return 1; //silnia z 0 i 1 wynosi 1
        return limit*strongNumRecurency(limit-1);
    }

    //liczenie n-tego wyrazu w ciągu, w którym dodaje się step
    public static int nNumberInSeries(int indexNumber, int base, int step){
       if(indexNumber==0)
           return base;
       return nNumberInSeries(indexNumber-1,base+step,step);
    }

    //n-ty wyraz ciągu Fibonacciego
    public static int nNumberInFibonacci(int indexNumber){

       if(indexNumber==1 || indexNumber ==2)
           return 1;

        return nNumberInFibonacci(indexNumber-1)+nNumberInFibonacci(indexNumber-2);

    }

}
