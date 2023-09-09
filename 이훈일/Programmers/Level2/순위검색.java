class Solution {
    public int[] solution(String[] info, String[] query) {
        for(int i = 0; i < query.length; i++) {
            String replaced = query[i].replaceAll(" and", "");
            String[] qArr = replaced.split(" ");
            String[] iArr = info[i].split(" ");
        
            if(Integer.parseInt(stack.pop()) > Integer.parseInt(iArr[0])) {
                break;
            }
            for(int j = 0; j < 3; j++) {
                if(!qArr[i].equals("-")) {
                    if()
                }
            }
        }
    }
}
