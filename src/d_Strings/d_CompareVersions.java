package d_Strings;

public class d_CompareVersions {
    public static void main(String[] args) {
        String version1 = "1.2";
        String version2 = "1.10";

        d_CompareVersions compareVersions = new d_CompareVersions();
        int result = compareVersions.compareVersion(version1, version2);
        System.out.println("Result: " + result);
    }

    public int compareVersion(String version1, String version2) {

        String arr1[] = version1.split("\\.");
        String arr2[] = version2.split("\\.");



        //Rmember this function from Math class
        int maxLength = Math.max(arr1.length,arr2.length);

        for(int i=0; i<maxLength; i++){
            //use parseInt() function to convert values like 0010 = 10.
            //Ignores leading zeros.
            int num1 = i<arr1.length?Integer.parseInt(arr1[i]):0;
            int num2 = i<arr2.length?Integer.parseInt(arr2[i]):0;


            if(num1>num2) return 1;
            if(num1<num2) return -1;

        }

        //This has to be outside because both the versions are compared and none of the above 2 conditions are satisfied.
        return 0;

    }
}
