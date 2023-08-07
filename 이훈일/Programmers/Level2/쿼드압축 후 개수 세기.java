class Solution {

    int[] result = new int[]{0,0};

    public int[] solution(int[][] arr) {
        int len = arr.length;
        division(arr,0 ,0 ,len);
        return this.result;
    }

    public void division(int[][] arr, int x, int y, int q) {
        int start = arr[x][y];
        int bool = 2;

        if (q == 1){
            this.result[start] += 1;
            return;
        }

        for(int i = x; i < x+q; i++) {
            for(int j = y; j < y+q; j++) {
                if(start != arr[i][j]) {
                    bool += 1;
                    break;
                }
            }
        }

        if(bool == 2) {
            this.result[start] += 1;
        } else {
            q = (Integer)q/2;
            division(arr, x, y, q);
            division(arr, x, y+q, q);
            division(arr, x+q, y, q);
            division(arr, x+q, y+q, q);
        }
    }
}
