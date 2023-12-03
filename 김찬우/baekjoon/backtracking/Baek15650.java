package com.example.codingtest.backTracking;

import java.util.Scanner;

public class Baek15650 {


    static int n,m;

    static boolean[] visited;

    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n= sc.nextInt();
        m= sc.nextInt();
        arr =new int[m+1];
        visited = new boolean[n+1];

        rec(0,1);



        //아이디어
        // 재귀 함수를 통해 중복을 허용하지 않는 rec -> for문을 돌면서 방문한 적이



    }

    public static void rec(int depth, int start){

        if(depth==m){

            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();

            return;
        }

        for(int i = start; i<=n; i++){

            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                rec(depth+1,i+1);
                visited[i] = false;


            }

            //visited[i] = false;

        }

    }
}
