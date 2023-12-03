package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek14889 {

    public static int[][] arr;
    public static int n;
    public static int min = Integer.MAX_VALUE;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {

        // 아이디어
        // 경우의 순서를 생각하지 않고 뽑는다
        // for을 돌면서 하나를 선택한다.
        // start값을 들어오는 값으로 해준다.
        // depth가 3이면 종류

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visit = new boolean[n];


        for(int i=0; i<n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++){

                arr[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        rec(0,0);

        System.out.println(min);


    }

    public static void rec(int start, int depth){

        if(depth == n/2){

            diff();
            return;

        }

        for(int i = start; i<n; i++){

            visit[i] = true;
            rec(i+1,depth+1);
            visit[i] =false;
        }

    }

    public static void diff(){
        int start = 0;
        int link = 0;

        for(int i=0; i<n-1; i++){

            for(int j =i+1; j<n; j++ ){

                if(visit[i] && visit[j]){
                    start+=arr[i][j];
                    start+=arr[j][i];
                }else if(!visit[i] && !visit[j]){
                    link+=arr[i][j];
                    link+=arr[j][i];
                }

            }
        }

        int result = Math.abs(start - link);

        if (result == 0){
            System.out.println(result);
            System.exit(0);
        }

        min=Math.min(min,result);

    }


}
