package d_Strings;

public class a_Reverse_Words_In_String {

    public static void main(String[] args) {

        a_Reverse_Words_In_String reverseWordsInString = new a_Reverse_Words_In_String();
        String example = "Hello World!";
        String reversedString = reverseWordsInString.reverseWords(example);
        System.out.println("Reversed String : " + reversedString);
    }

    public String reverseWords(String s) {

        // Split by one or more spaces (\\s+ → whitespace, + → one or more)
        String arr[] = s.trim().split("\\s+");

        // Reverse the array in-place
        int start = 0, end = arr.length - 1;
        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        // Join words with a single space between them
        return String.join(" ", arr);
    }

}
