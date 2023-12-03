package com.example.codingtest.backTracking;

import java.util.Scanner;

public class Baek15652 {

    static int[] arr;
    static int m,n;

    public static void main(String[] args) {

        // 아이디어
        // 1~n 하나를 선택
        // 방문하지 않은 경우 선택
        // m개를 선택할 때 탈출

        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        m =sc.nextInt();

        arr =new int[m+1];

        rec(0,1);


    }


    public static void rec(int depth, int start){

        if(depth == m){

            for(int i=0; i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<=n; i++){

            arr[depth] = i;
            rec(depth+1,i);
        }

    }




}
