package d_Strings;

public class c_Check_2Strings_If_Anagram {
    public static void main(String[] args) {

        c_Check_2Strings_If_Anagram check2StringsIfAnagram = new c_Check_2Strings_If_Anagram();

        String s = "anagram";
        String t = "nagaram";
        System.out.println(check2StringsIfAnagram.isAnagram(s,t));
    }

    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        //By default it will be initialized to 0
        int arr[] = new int[26];
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            arr[index]++;
        }

        for(int i=0; i<t.length(); i++){
            int index = t.charAt(i) - 'a';
            arr[index]--;
            //if any character is mismatching then it will set index to -1. Note--> as number of characters are already checked at first.
            if(arr[index]<0){
                return false;
            }
        }

        return true;
    }
}
