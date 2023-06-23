import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        char[] beforeCharArray = before.toCharArray();
        char[] afterCharArray = after.toCharArray();
        Arrays.sort(beforeCharArray);
        Arrays.sort(afterCharArray);
        String newBefore = new String(beforeCharArray);
        String newAfter = new String(afterCharArray);
        return newBefore.equals(newAfter) ? 1 : 0;
    }
}
