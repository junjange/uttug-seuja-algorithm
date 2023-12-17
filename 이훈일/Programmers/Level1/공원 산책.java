import java.util.HashMap;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        HashMap<Character, int[]> map = new HashMap<>(){{
            put('E', new int[]{0,1});
            put('W', new int[]{0,-1});
            put('S', new int[]{1,0});
            put('N', new int[]{-1,0});
        }};
        int[] start = new int[2];
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(String.valueOf(park[i].charAt(j)).equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
    
        for(int i = 0; i < routes.length; i++) {
            int[] dxdy = map.get(routes[i].charAt(0));
            int n = (int) routes[i].charAt(2) - '0';
            int dx = dxdy[0];
            int dy = dxdy[1];
            Boolean canGo = true;
            int curX = start[0];
            int curY = start[1];
            for(int j = 0; j < n; j++) {
                curX += dx;
                curY += dy;
                if(curX<0 || curX>=park.length || curY<0 || curY>=park[0].length()) {
                    canGo = false;
                    break;
                }
                if(String.valueOf(park[curX].charAt(curY)).equals("X")) {
                    canGo = false;
                    System.out.println("X");
                    break;
                }
            }
            if(canGo) {
                start[0] = curX;
                start[1] = curY;
            }
        }
        return start;
    }
}
