class Solution {
    public int solution(String my_string) {
        my_string = 0 + my_string;
        String[] strArray = my_string.replaceAll("[^0-9]+", " ").split(" ");
        int sum = 0;
        for(int i = 0; i < strArray.length; i++) {
            sum += Integer.valueOf(strArray[i]);
        }
        
        return sum;
    }
}
