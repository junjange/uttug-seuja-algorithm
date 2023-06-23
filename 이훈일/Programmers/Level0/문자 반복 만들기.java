import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int n) {
        String[] strArray = my_string.split("");
        String newStr = Arrays.stream(strArray).map(s -> s.repeat(n)).collect(Collectors.joining());
        return newStr;
    }
}
