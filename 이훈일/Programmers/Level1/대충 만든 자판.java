class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i = 0; i < targets.length; i++) {
            String[] targetArr = targets[i].split("");
            int count = 0;
            for(String s : targetArr) {
                int index = -1;
                for(String key : keymap) {
                    if(key.contains(s)) {
                        if(index < 0){
                            index = key.indexOf(s) + 1;
                        }else{
                            if(index > key.indexOf(s)) {
                                index = key.indexOf(s) + 1;
                            }
                        }
                    }
                }
                if(count != -1) {
                    if(index == -1){
                        count = -1;
                    } else {
                        count += index;
                    }
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
