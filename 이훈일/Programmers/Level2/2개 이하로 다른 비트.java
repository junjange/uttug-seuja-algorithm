class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            
            if(number % 2 == 0) {
                answer[i] = number + 1;
            } else {
                String numBin = Long.toString(number, 2);
                int index = numBin.lastIndexOf("0");
                String result = "";
                
                if(index == -1) {
                    result = "10" + numBin.substring(1, numBin.length());
                } else {
                    result = numBin.substring(0, index) + "10" + numBin.substring(index+2, numBin.length());
                }
                
                answer[i] = Long.parseLong(result, 2);
            }
        }
        
        return answer;
    }
}
