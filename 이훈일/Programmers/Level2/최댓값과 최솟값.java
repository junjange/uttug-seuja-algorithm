import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int[] iArr = Arrays.stream(sArr).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(iArr);
        String answer = iArr[0] + " " + iArr[iArr.length - 1];
        return answer;
    }
}
