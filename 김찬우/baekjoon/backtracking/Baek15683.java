package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek15683 {

    static int n,m;
    static int[][] arr;

    static ArrayList<int[]> list = new ArrayList<>();

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];



        visited = new boolean[n][m];

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<m; j++){

                int num = Integer.parseInt(st.nextToken());

                if(num !=0){
                    visited[i][j] = true;
                    list.add(new int[]{i,j});
                }

                arr[i][j] = num;
            }

        }




    }

    static void back(int depth){

        if(depth == list.size()){
            return;
        }

        for(int i=0; i < list.size(); i++){

            int[] point = list.get(i);

            if(arr[point[0]][point[1]] == 1){

                for( int j =0; j<4; j++){


                }

            }else if(arr[point[0]][point[1]] == 2){

                for( int j =0; j<4; j++){

                }

            }else if(arr[point[0]][point[1]] == 3){

                for( int j =0; j<4; j++){

                }

            }else if(arr[point[0]][point[1]] == 4){

                for( int j =0; j<4; j++){

                }

            } else if (arr[point[0]][point[1]] == 5) {


            }

        }

    }

}
