import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] filArr = Arrays.stream(arr).filter(a -> a % divisor == 0).toArray();
        Arrays.sort(filArr);
        int[] noArr = new int[]{-1};
        return filArr.length == 0? noArr : filArr;
    }
}
