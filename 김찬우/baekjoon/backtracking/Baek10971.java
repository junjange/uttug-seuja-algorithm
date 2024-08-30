package com.example.codingtest.backTracking;

import java.util.*;
import java.io.*;

public class Baek10971 {

    static int n;

    static int[][] arr;

    static int min = Integer.MAX_VALUE;

    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n];
        result = new int[n];

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++){

                arr[i][j] =Integer.parseInt(st.nextToken());

            }
        }

        backTracking(0);

        System.out.println(min);



    }

    static public void backTracking(int depth) {

        if(depth == n){

            int r = getResult(result);

            if (r !=-1){
                min = Math.min(r,min);
            }

            return;
        }

        for (int i=0; i<n; i++) {

            if(!visited[i]){
                visited[i] =true;
                result[depth] = i;
                backTracking(depth+1);
                visited[i] =false;
            }

        }

    }

    public static int getResult(int[] result) {

        int sum = 0;

        for(int i=0; i < result.length-1; i++){

            int num = arr[result[i]][result[i + 1]];

            if (num == 0) {
                return -1;
            }else{
                sum += arr[result[i]][result[i+1]];

            }


        }

        int check = arr[result[result.length - 1]][result[0]];


        if(check == 0){
            return -1;
        }

        sum += arr[result[result.length-1]][result[0]];


        return sum;


    }

}
