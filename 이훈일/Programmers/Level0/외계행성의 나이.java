
class Solution {
    public String solution(int age) {
        String answer = "";
        while (0 < age) {
            int remain = age % 10 + 97;
            age = age / 10;
            char charRemain = (char) remain;
            answer = charRemain + answer;

        }
        return answer;
    }
}
