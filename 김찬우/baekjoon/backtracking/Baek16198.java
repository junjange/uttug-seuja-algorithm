package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek16198 {

    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        backTracking(0,0);

        System.out.println(max);


    }
    static void backTracking(int depth, int sum){
        if(arr.size() == 2){
            max = Math.max(max,sum);
            return;
        }

        for(int i=1; i < arr.size()-1; i++){

            Integer num = arr.get(i);
            int oper = arr.get(i - 1) * arr.get(i + 1);
            arr.remove(i);
            backTracking(depth+1,sum+oper);
            arr.add(i,num);
        }
    }
}
