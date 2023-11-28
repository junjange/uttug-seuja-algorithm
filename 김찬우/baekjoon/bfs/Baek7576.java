package com.example.codingtest.bfs;

import java.util.*;

public class Baek7576 {

    static int[][] arr;
    static int m;
    static int n;
    static Queue<int[]> queue;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) {

        // 알고리즘
        // arr[i][j] == 1 인 것들을 queue에 넣고 bfs를 돌면서 arr[i][j] 의 상하좌우를 보면서 이전 위치 +1을 넣어준다
        // bfs를 다 돈후 가장 큰값을 찾는다. 만약에 0 이 존재하면 -1을 리터한다.

        // 시간복잡도
        // bfs(node + 간선)--> 1000*1000 + 1000*1000*4 = 5백만

        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][m];
        queue = new LinkedList<>();


        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }

        }



        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(arr[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }

            }

        }

        bfs();

        int max = Integer.MIN_VALUE;

        loop:
        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(arr[i][j] == 0){
                    max = 0;
                    break loop;
                }

                if(arr[i][j] != 0 && arr[i][j] > max){
                    max = arr[i][j];
                }

            }
        }

        System.out.println(max-1);



    }

    public static void bfs(){

        while(!queue.isEmpty()){

            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];

            for(int i=0; i<4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= n || nx < 0 ||ny >= m || ny < 0 ){
                    continue;
                }

                if(arr[nx][ny] == 0){
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new int[]{nx,ny});
                }

            }


        }

    }


}
