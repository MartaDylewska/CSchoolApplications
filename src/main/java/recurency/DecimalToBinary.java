package recurency;

//zamiana systemu dziesiętnego na binarny

public class DecimalToBinary {

    public static void decimalToBinary(int decNumber){
        if(decNumber>0){
            decimalToBinary(decNumber/2);
            System.out.print( decNumber%2);
        }
    }

    public static int find(int decimal_number)
    {
        if (decimal_number == 0)
            return 0;

        else

            return (decimal_number % 2 + 10 *
                    find(decimal_number / 2));
    }

}
