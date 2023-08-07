class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            while(count < index) {
                if(c+1 > 122) {
                    c = 'a';
                }else {
                    c = (char)(c+1);
                }
                if(!skip.contains(Character.toString(c))) {
                    count++;
                }
            }
            answer += Character.toString(c);
        }
        System.out.println(answer);
        return answer;
    }
}
