class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            String binary1 = Integer.toString(arr1[i], 2);
            String binary2 = Integer.toString(arr2[i], 2);
            
            if(binary1.length() != n){
                binary1 = "0".repeat(n-binary1.length()) + binary1;
            }
            if(binary2.length() != n){
                binary2 = "0".repeat(n-binary2.length()) + binary2;
            }
            
            String[] strArr1 = binary1.split("");
            String[] strArr2 = binary2.split("");
            
            for(int j = 0; j < strArr2.length; j++) {
                if(strArr2[j].equals("1")) {
                    strArr1[j] = "1";
                }
            }
            
            String changeStr = String.join("", strArr1).replaceAll("1","#");
            answer[i] = changeStr.replaceAll("0", " ");
        }
        return answer;
    }
}
