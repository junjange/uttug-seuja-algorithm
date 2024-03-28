package com.example.codingtest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Baek11651 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n= Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){

                if(o1[1] - o2[1] == 0){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }

            }
        });


        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }
}
