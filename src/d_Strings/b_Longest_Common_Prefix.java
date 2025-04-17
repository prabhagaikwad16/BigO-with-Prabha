package d_Strings;

public class b_Longest_Common_Prefix {
    public static void main(String[] args) {
        b_Longest_Common_Prefix lcp = new b_Longest_Common_Prefix();

        // Test case 1: Empty input array
        System.out.println("output = "+lcp.findLongestCommonPrefix(new String[]{})); // Expected: ""

        // Test case 2: Null input array
        System.out.println("output = "+lcp.findLongestCommonPrefix(null)); // Expected: ""

        // Test case 3: Single string in array
        System.out.println("output = "+lcp.findLongestCommonPrefix(new String[]{"abc"})); // Expected: "abc"

        // Test case 4: All strings are identical
        System.out.println("output = "+lcp.findLongestCommonPrefix(new String[]{"apple", "apple", "apple"})); // Expected: "apple"

        // Test case 5: No common prefix
        System.out.println("output = "+lcp.findLongestCommonPrefix(new String[]{"dog", "cat", "bird"})); // Expected: ""

        // Test case 6: Prefix length reduces quickly
        System.out.println("output = "+lcp.findLongestCommonPrefix(new String[]{"flower", "flow", "flight"})); // Expected: "fl"

        // Test case 7: Strings with different lengths
        System.out.println("output = "+lcp.findLongestCommonPrefix(new String[]{"abc", "ab", "a"})); // Expected: "a"

        // Test case 8: Common prefix is empty
        System.out.println("output = "+lcp.findLongestCommonPrefix(new String[]{"", "abc", "xyz"})); // Expected: ""

        // Test case 9: All strings are empty
        System.out.println("output = "+lcp.findLongestCommonPrefix(new String[]{"", "", ""})); // Expected: ""

        // Test case 10: Common prefix is the whole string
        System.out.println("output = "+lcp.findLongestCommonPrefix(new String[]{"ab", "ab"})); // Expected: "ab"
    }

    public String findLongestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        // Reduce prefix until it matches the start of all strings
        for(int i = 1; i < strs.length; i++) {
            while(!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

}
