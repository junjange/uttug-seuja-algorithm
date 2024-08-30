package com.example.codingtest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek7568 {

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 모든 사람들을 확인하면서 2차원 배열로 확인한다.

        // 시간 복잡도
        // 50*50*50*50
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] result = new int[n];
        int count;

        for(int p=0; p<n; p++){

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int wight  = Integer.parseInt(st.nextToken());
            int height  = Integer.parseInt(st.nextToken());

            arr[p][0] = wight;
            arr[p][1] = height;

        }

        for(int i=0; i<n; i++){

            count = 0;

            for(int j=0; j<n; j++){

                if(arr[i][0] < arr[j][0] && arr[i][1]<arr[j][1]){
                    count++;
                }

            }

            result[i] = count+1;

        }

        for(int num : result){
            System.out.print(num+" ");
        }

    }
}
