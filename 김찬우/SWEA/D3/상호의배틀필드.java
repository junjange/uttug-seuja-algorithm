import java.io.*;
import java.util.*;
 
public class Solution {
 
    static char[][] map = new char[20][20];
    static int h,w,n;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T  = Integer.parseInt(st.nextToken());
 
        for (int test_case =1; test_case <=T; test_case++) {
 
            int direction = 0;
            int tankX = 0;
            int tankY = 0;
 
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
 
            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
 
                for (int j=0; j<w; j++) {
                    map[i][j] = str.charAt(j);
 
                    if (map[i][j] == '<') {
                        direction = 2;
                        tankX = i;
                        tankY = j;
                        map[i][j] = '.';
                    }else if (map[i][j] == '>') {
                        direction = 3;
                        tankX = i;
                        tankY = j;
                        map[i][j] = '.';
                    }else if (map[i][j] == '^') {
                        direction = 0;
                        tankX = i;
                        tankY = j;
                        map[i][j] = '.';
                    }else if (map[i][j] == 'v') {
                       direction = 1;
                        tankX = i;
                        tankY = j;
                        map[i][j] = '.';
                    }
 
                }
 
            }
 
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine());
            String str  = st.nextToken();
 
            char[] command = str.toCharArray();
 
            for (char c : command) {
 
                if (c == 'U') {
                    direction = 0;
 
                    int nx = tankX + dx[direction];
                    int ny = tankY + dy[direction];
 
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w ) {
                        continue;
                    }
 
                    if (map[nx][ny] == '.') {
                        tankX = nx;
                        tankY = ny;
                    }
 
 
                }else if (c == 'D') {
                    direction = 1;
                    int nx = tankX + dx[direction];
                    int ny = tankY + dy[direction];
 
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] != '.') {
                        continue;
                    }
 
                    if (map[nx][ny] == '.') {
                        tankX = nx;
                        tankY = ny;
                    }
 
                }else if (c == 'L') {
                    direction = 2;
                    int nx = tankX + dx[direction];
                    int ny = tankY + dy[direction];
 
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] != '.') {
                        continue;
                    }
 
                    if (map[nx][ny] == '.') {
                        tankX = nx;
                        tankY = ny;
                    }
 
                }else if (c == 'R') {
                    direction = 3;
                    int nx = tankX + dx[direction];
                    int ny = tankY + dy[direction];
 
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] != '.') {
                        continue;
                    }
 
                    if (map[nx][ny] == '.') {
                        tankX = nx;
                        tankY = ny;
                    }
 
                }else if (c == 'S') {
 
                    int nx = tankX;
                    int ny = tankY;
 
                    while (true) {
 
                        nx += dx[direction];
                        ny += dy[direction];
 
                        if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '#') {
                            break;
                        }
 
                        if (map[nx][ny] == '*') {
                            map[nx][ny] = '.';
                            break;
                        }
 
                    }
 
                }
 
            }
 
            if (direction == 0) {
                map[tankX][tankY] ='^';
 
            }else if (direction == 1) {
                map[tankX][tankY] ='v';
 
            }else if (direction == 2) {
                map[tankX][tankY] ='<';
 
            }else if (direction == 3) {
                map[tankX][tankY] ='>';
            }
 
            System.out.print("#"+test_case+" ");
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
 
 
        }
 
    }
 
}
