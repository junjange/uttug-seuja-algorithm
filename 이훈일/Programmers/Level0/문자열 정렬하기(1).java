import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        String changeStr = my_string.replaceAll("[^0-9]", "");
        String[] strArray = changeStr.split("");
        int[] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(intArray);
        return intArray;
    }
}
