package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek2529 {

    static int k;
    static String[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Long> list =  new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        k = Integer.parseInt(st.nextToken());

        arr = new String[k+1];
        result = new int[k+1];
        visited = new boolean[10];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=1 ;i<k+1; i++){
            arr[i] = st.nextToken();
        }

        backTrack(0);

        Long max = Collections.max(list);
        Long min = Collections.min(list);

        String reMax = String.valueOf(max);
        String reMin = String.valueOf(min);

        if(reMax.length() < k+1){
            reMax = "0" + reMax;
        }

        if(reMin.length() < k+1){
            reMin = "0" + reMin;
        }

        System.out.println(reMax);
        System.out.println(reMin);


    }

    static void backTrack(int depth){

        if(depth == k+1){

            sb.setLength(0);

            for(int i=0; i<k+1; i++){

               sb.append(result[i]);
            }

            list.add(Long.valueOf(sb.toString()));

            return;
        }

        for(int i=0; i < 10; i++){

            if (!visited[i]) {

                if(depth == 0){
                    visited[i] =true;
                    result[depth] = i;
                    backTrack(depth+1);
                    visited[i] =false;
                    continue;
                }

                if(arr[depth].equals("<")){

                    if(result[depth-1] < i){
                        visited[i] =true;
                        result[depth] = i;
                        backTrack(depth+1);
                        visited[i] =false;
                    }

                }else{

                    if(result[depth-1] > i){
                        visited[i] =true;
                        result[depth] = i;
                        backTrack(depth+1);
                        visited[i] =false;
                    }

                }

            }
        }
    }
}
