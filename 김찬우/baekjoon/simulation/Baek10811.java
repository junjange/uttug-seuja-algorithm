package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10811 {

    static int[] arr;
    static int n,m;

    static int left,right;

    static int[] reverseArr;

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 바구니를 만든다 n+1 그리고 사이값들을 돌면서 새로운 배열을 만들어 넣고 다시 본 배열에 넣어준다
        // 시간 복잡도
        // 100*100*100

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = i;
        }



        for(int i=0; i<m; i++){

            st =  new StringTokenizer(br.readLine(), " ");

            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());

            if(left == right){
                continue;
            }

            reverseArr = new int[right-left+1];

            int k=0;
            for (int j = right; j >= left; j--){
                reverseArr[k] = arr[j];
                k++;
            }
            k=0;

            for (int j = left; j <= right; j++){
                arr[j] = reverseArr[k];
                k++;
            }


        }

        for (int i =1; i<=n; i++) {

            System.out.print(arr[i]+" ");
        }




    }
}
