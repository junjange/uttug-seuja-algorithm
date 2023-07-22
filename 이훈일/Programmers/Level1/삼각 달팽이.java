class Solution {
    public int[] solution(int n) {
        int[] dix = new int[]{1,0,-1};
        int[] diy = new int[]{0,1,-1};

        int[][] arr = new int[n][];
        for(int i = 0; i < n; i++) {
            arr[i] = new int[i+1];
        }

        int x = -1;
        int y = 0;
        int num = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-i; j++) {
                x += dix[i%3];
                y += diy[i%3];
                arr[x][y] = ++num;
            }
        }

        int[] answer = new int[num];
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                answer[count] = arr[i][j];
                count++;
            }
        }

        return answer;
    }
}
