package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek6603 {

    static int n;

    static boolean[] visited;
    static int[] result;
    static int[] arr;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        // 입력을 받는다 0이 들어오면 종료
        // List를 만들고 정렬을 한다. 백트레킹을 돎면서 6개를 뽑는다.

        // 시간복잡도
        // 13의 제곱이지만 백트레킹을 통해 가지치기


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            n = Integer.parseInt(st.nextToken());

            if (n == 0)
                break;

            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            result = new int[6];
            visited = new boolean[n];
            rec(0, 0);

            System.out.println(sb);


        }


    }
    public static void rec(int start, int depth){

        if(depth == 6){
            for(int i=0; i<6; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=start; i<n; i++){

            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                rec(i+1,depth+1);
                visited[i] = false;
            }

        }

    }


}
