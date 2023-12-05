package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek15665 {

    static int[] arr;
    static int[] result;
    static int n,m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 배열 만들기
        // 중복이 가능하기 때문에 rec에 for 0 ~ n까지 돌면서 모든 경우의 수
        // 변수 before을 통해서 같은 depth에 있는 것들이 중복이 되지 않도록 함 // 정렬을 했기 때문에 가능

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr= new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        rec(0);
        System.out.println(sb);


    }

    public static void rec(int depth){

        if(depth == m){

            for(int i=0; i<m; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;

        for(int i=0; i<n; i++){

            if(arr[i] != before){
                before = arr[i];
                result[depth] = arr[i];
                rec(depth+1);
            }

        }
    }
}
