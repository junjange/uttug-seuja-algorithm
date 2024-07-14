package com.example.codingtest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2775 {
    public static void main(String[] args) throws IOException {


        int[][] arr = new int[15][15];

        for(int j=0; j<15; j++){

            arr[0][j] = j;

        }

        for(int i=1; i<15; i++){

            for(int j=1; j<15; j++){

                for(int z=1; z<=j; z++){

                    arr[i][j] += arr[i-1][z];

                }

            }

        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            int y = Integer.parseInt(st.nextToken());
            System.out.println(arr[x][y]);

        }



    }

}
