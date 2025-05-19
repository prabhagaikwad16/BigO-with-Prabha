package f_Recursion_and_backtracking;

public class g_Pow_Without_Resursion {
    public static void main(String[] args) {
        double x= 2;
        int n = 10;

        g_Pow_Without_Resursion pow = new g_Pow_Without_Resursion();
        double result = pow.myPow(x, n);
        System.out.println("Result = "+result);
    }

    public double myPow(double x, int n) {

        if(n == 0){
            return 1;
        }

        long N = n;
        if(n<0){
             x = 1/x;
             //As we are already performing x = 1/x in case if n is negative then we need t convert n to positive.
            //Note--> consider 'N' and not 'n' as in case of negative minimum integer value it will overflow and result will be inconsistent.
             N = -N;
        }

        double ans = 1;
        while(N>0){
            if(N%2==0){
               x *= x;
               N = N/2;
            }else{
                ans *= x;
                N = N-1;
            }
        }
        return ans;
    }
}
