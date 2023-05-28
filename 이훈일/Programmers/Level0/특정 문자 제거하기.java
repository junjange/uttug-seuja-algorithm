class Solution {
    public String solution(String my_string, String letter) {
        String newString = my_string.replaceAll(letter, "");
        return newString;
    }
}
