package com.example.codingtest.backTracking;

import java.util.*;
import java.io.*;


public class Baek19949 {

    static int[] arr;
    static int[] result;

    static int cnt =0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr =new int[10];
        result =new int[10];

        for(int i=0; i<10; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0);

        System.out.println(cnt);

    }

    static void bfs(int depth){

        if(depth == 10){

            int sum = 0;

            for(int i=0; i<10; i++){

                if(result[i] == arr[i]){
                    sum++;
                }

                if (sum >= 5){
                    cnt++;
                    return;
                }
            }
            return;
        }

        for(int i=1; i<=5; i++){

            if(depth >= 2 && result[depth-1] == i && result[depth-2] == i){
                continue;
            }
            result[depth] = i;
            bfs(depth+1);

        }
    }
}
