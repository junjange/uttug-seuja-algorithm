import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        String[] strArray = my_string.split("");
        return Arrays.asList(strArray).stream().distinct().collect(Collectors.joining());
    }
}
