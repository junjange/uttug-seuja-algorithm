package com.example.codingtest.implement;

import java.io.*;
import java.util.*;

public class Baek3190 {

    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static char[] direction = new char[Integer.MAX_VALUE];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());

        for (int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char b = st.nextToken().charAt(0);
            direction[a] = b;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {1,1});
        map[1][1] = 2;

        int[] head = {1,1};
        int cnt = 0;
        int d = 0;

        while (true) {

            int x = head[0] + dx[d];
            int y = head[1] + dy[d];
            cnt++;

            if (x <= 0 || x > n || y <=0 || y > n || map[x][y] == 2) {
                break;
            }


            if (map[x][y] == 1) {
                map[x][y] = 2;

                head[0] = x;
                head[1] = y;

                queue.offer(new int[] {x,y});

            }else {


                map[x][y] = 2;

                head[0] = x;
                head[1] = y;

                queue.offer(new int[]{x,y});

                int[] node = queue.poll();

                map[node[0]][node[1]] = 0;


            }


            if (direction[cnt] == 'D'){

                d = (d+1) % 4;

            }else if (direction[cnt] == 'L') {

                if (d-1 >= 0) {
                    d -=1;
                }else {
                    d = 3;
                }
            }




        }

        System.out.println(cnt);





    }
}

