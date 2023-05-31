
class Solution {
    public int solution(int n) {
        int num = 2;
        int multiNum = n;
        while(multiNum % 6 != 0) {
            multiNum = n * num;
            num++;
        }
        return multiNum/6;
    }
}
