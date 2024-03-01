package com.example.codingtest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek10814 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n= Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][2];

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr,new Comparator<>(){

            @Override
            public int compare(String[] o1, String[] o2){

                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);

            }

        });

        for (int i=0; i<n; i++){

            for(int j=0; j<2; j++){
                System.out.print(arr[i][j]+" ");

            }

            System.out.println();

        }





    }
}
