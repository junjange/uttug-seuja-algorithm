package com.example.codingtest.backTracking;

import java.util.*;

public class Baek15649 {

    static boolean[] visited;
    static int[] arr;
    static int m,n;

    public static void main(String[] args) {

        // 아이디어
        // 1~n 하나를 선택
        // 방문하지 않은 경 선택
        // m개를 선택할 때 탈


        // 시간 복잡도 (중복이 가능하면 n*n)  --> 8까지
        // 중복 이 불가능 하면 n!  -->  10 까지



       Scanner sc = new Scanner(System.in);

       n = sc.nextInt();
       m = sc.nextInt();

       visited = new boolean[n+1];
       arr = new int[m+1];

       rec(0);



    }

    public static void rec(int depth){
        
        if(depth==m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;

        }

        for(int i=1; i<=n; i++){

            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                rec(depth+1);
                visited[i] = false;

            }

        }

    }


}
