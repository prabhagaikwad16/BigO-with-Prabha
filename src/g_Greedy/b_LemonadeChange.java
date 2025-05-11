package g_Greedy;

public class b_LemonadeChange {
    public static void main(String[] args) {

        int bills[] = {5,5,10,10,20};

        b_LemonadeChange lemonadeChange = new b_LemonadeChange();
        boolean result = lemonadeChange.lemonadeChange(bills);
        System.out.println("Result = "+result);
    }


    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){
                five++;
            }
            else if(bills[i] == 10){
                if(five>0){
                    ten++;
                    five--;
                }else{
                    return false;
                }
            }
            else if(bills[i] == 20){
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five = five-3;
                }
                else{
                    return false;
                }
            }else{
                return false;
            }
        }

        return true;
    }
}
