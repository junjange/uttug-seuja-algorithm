class Solution {
    public int[] solution(String s) {
        int[] result = new int[2];
        while(!s.equals("1")) {
            String rep = s.replaceAll("0", "");
            result[1] += s.length() - rep.length();
            s = Integer.toString(rep.length(), 2);
            result[0]++;
        }
        
        return result;
    }
}
