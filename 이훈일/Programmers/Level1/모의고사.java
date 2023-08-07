import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer1 = new int[]{1,2,3,4,5};
        int[] answer2 = new int[]{2,1,2,3,2,4,2,5};
        int[] answer3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        int[] cnt = new int[]{0,0,0};
        List<Integer> answerCnt = new ArrayList<>(){{
            add(0);
            add(0);
            add(0);
        }};

        int[] result = null;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == answer1[cnt[0]++]) {
                answerCnt.set(0,answerCnt.get(0)+1);
            }
            if(answers[i] == answer2[cnt[1]++]) {
                answerCnt.set(1,answerCnt.get(1)+1);
            }
            if(answers[i] == answer3[cnt[2]++]) {
                answerCnt.set(2,answerCnt.get(2)+1);
            }

            if(cnt[0] == 5) {
                cnt[0] = 0;
            }
            if(cnt[1] == 8) {
                cnt[1] = 0;
            }
            if(cnt[2] == 10) {
                cnt[2] = 0;
            }
        }
        System.out.println(answerCnt.get(0));
        System.out.println(answerCnt.get(1));
        System.out.println(answerCnt.get(2));

        List<Integer> copyAnswerCnt = new ArrayList<>(){{
            add(answerCnt.get(0));
            add(answerCnt.get(1));
            add(answerCnt.get(2));
        }};

        Collections.sort(answerCnt);

        if(answerCnt.get(2).equals(answerCnt.get(1))) {
            if(answerCnt.get(1).equals(answerCnt.get(0))){
                result = new int[]{1,2,3};
            }else {
                int[] arr = new int[2];
                arr[0] = copyAnswerCnt.indexOf(answerCnt.get(2))+1;
                copyAnswerCnt.set(copyAnswerCnt.indexOf(answerCnt.get(2)),-1);
                arr[1] = copyAnswerCnt.indexOf(answerCnt.get(1))+1;
                result = arr;
                Arrays.sort(result);
            }
        }else {
            result = new int[]{copyAnswerCnt.indexOf(answerCnt.get(2))+1};
        }

        return result;
    }
}
