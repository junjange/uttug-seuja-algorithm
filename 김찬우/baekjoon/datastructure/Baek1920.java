package com.example.codingtest.datastructure;

import java.util.*;
import java.io.*;


public class Baek1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for(int i=0; i<n; i++){

            arr[i]  = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<k; i++){
            int result = Integer.parseInt(st.nextToken());

            if(binarySearch(arr,result)){
                sb.append(1);
                sb.append("\n");
            }else{
                sb.append(0);
                sb.append("\n");
            }



        }

        System.out.println(sb);

    }

    public static boolean binarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length;

        while (low < high){
            int mid = (low+high)/2;

            if(arr[mid] < key){
                low = mid+1;
            }else if(arr[mid] > key){
                high = mid;
            }else if(arr[mid] == key){
                return true;
            }

        }

        return false;

    }
}
