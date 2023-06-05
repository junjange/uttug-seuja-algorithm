class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] stringArray = my_string.split("");
        String string_num1 = stringArray[num1];
        String string_num2 = stringArray[num2];
        stringArray[num1] = string_num2;
        stringArray[num2] = string_num1;
        String joinString = String.join("", stringArray);
        return joinString;
    }
}
