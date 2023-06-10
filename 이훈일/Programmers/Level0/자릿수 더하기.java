class Solution {
    public int solution(int n) {
        String str = n + "";
        String[] strArray = str.split("");
        int sum = 0;
        for(int i = 0; i < strArray.length; i++) {
            sum += Integer.parseInt(strArray[i]);
        }
        return sum;
    }
}
