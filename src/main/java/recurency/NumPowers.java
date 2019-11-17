package recurency;

//zadanie - potęgowanie liczb

public class NumPowers {

    public static int generateNumberPower2(int base, int index){

        if(index ==  1)
            return base;

        return base*generateNumberPower2(base, index - 1);

        }


}
