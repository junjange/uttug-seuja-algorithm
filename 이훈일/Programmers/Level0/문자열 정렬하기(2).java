import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] chArray = my_string.toCharArray();
        Arrays.sort(chArray);
        String str = new String(chArray);
        return str;
    }
}
