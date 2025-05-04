package g_greedy;

import java.util.Arrays;

public class a_AssignCookies {

    public static void main(String[] args) {

        int g[] = {1,2,3};
        int s[] = {1,1};

        a_AssignCookies aAssignCookies = new a_AssignCookies();
        int result = aAssignCookies.findContentChildren(g, s);
        System.out.println("Result = "+result);
    }

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        while(i<g.length && j<s.length){

            if(g[i]<=s[j]){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i;
    }
}
