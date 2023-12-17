package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek15666 {

    static int[] arr;
    static int n,m;
    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 배열 생성 rec를 start 부터 시작 해서 돈다
        // before 변수를 통해서 전 숫자를 비교
        // depth == m 종료

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        rec(0,0);

        System.out.println(sb);


    }

    public static void rec(int start, int depth){

        if(depth == m){

            for(int i=0; i<m; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;

        for(int i=start; i<n; i++){

            if(before != arr[i]){
                result[depth] = arr[i];
                before = arr[i];
                rec(i,depth+1);
            }

        }
    }
}
