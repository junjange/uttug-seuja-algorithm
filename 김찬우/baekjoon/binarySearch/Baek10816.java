package com.example.codingtest.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");

        int[] arr = new int[n];

        for(int i=0; i<n; i++){

            arr[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine()," ");
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");


        for(int i=0; i<m; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr,key) - lowerBound(arr,key)).append(" ");

        }

        System.out.println(sb);


    }

    public static int lowerBound(int[] arr, int key){

        int low = 0;
        int high = arr.length;

        while (low<high){

            int mid = (low+high)/2;

            if(key <= arr[mid]){
                high = mid;
            }else{
                low =mid+1;
            }

        }
        return high;
    }

    public static int upperBound(int[] arr, int key){
        int low = 0;
        int high = arr.length;

        while (low < high){

            int mid = (low+high)/2;

            if(key >= arr[mid]){
                low = mid+1;
            }else{
                high = mid;
            }

        }
        return high;
    }






}
