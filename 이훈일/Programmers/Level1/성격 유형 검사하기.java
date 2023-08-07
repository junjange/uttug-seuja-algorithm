class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] pesonality = new String[]{"RT","CF","JM","AN"};
        int[] score = new int[4];

        for(int i = 0; i < survey.length; i++) {
            String[] surveyArr = survey[i].split("");
            String first = surveyArr[0];
            if(first.equals("A") || first.equals("N")){
                if(first.equals("A")) {
                    score[3] += (choices[i]-4) * -1;
                } else{
                    score[3] += choices[i]-4;
                }
            } else if(first.equals("C") || first.equals("F")){
                if(first.equals("C")) {
                    score[1] += (choices[i]-4)* -1;
                } else{
                    score[1] += (choices[i]-4);
                }
            } else if(first.equals("J") || first.equals("M")){
                if(first.equals("J")) {
                    score[2] += (choices[i]-4)*-1;
                } else{
                    score[2] += choices[i] -4;
                }
            } else{
                if(first.equals("R")) {
                    score[0] += (choices[i] - 4) * -1;
                } else{
                    score[0] += choices[i]-4;
                }
            }
        }
        String answer = "";

        for(int i = 0; i < score.length; i++){
            String[] perArr = pesonality[i].split("");
            if(score[i] >= 0){
                answer += perArr[0];
            } else{
                answer += perArr[1];
            }
        }

        return answer;
    }
}
