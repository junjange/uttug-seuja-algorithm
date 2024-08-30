package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek15656 {

    static int[] arr;
    static int n,m;

    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // 아이디어
        // for 문 정렬 모든 경우를 확인 중복을 수용한다. depth가 m일 때 종료

        // 시간 복잡도
        // 7에 7승

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

        rec(0);

        System.out.println(sb);



    }
    public static void rec(int depth){

        if(depth==m){
            for(int i=0; i<m; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            result[depth] = arr[i];
            rec(depth+1);
        }

    }


}
