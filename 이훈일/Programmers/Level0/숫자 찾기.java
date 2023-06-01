class Solution {
    public int solution(int num, int k) {
        String strNum = "" + num;
        String strK = "" + k;
        int index = strNum.indexOf(strK);
        if(index == -1){
            return -1;
        } else {
            return index + 1;
        }
    }
}
