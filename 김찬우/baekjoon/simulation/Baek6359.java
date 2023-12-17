package com.example.codingtest.simulation;

import java.util.Scanner;

public class Baek6359 {

    public static void main(String[] args) {



        //아이디어
        // boolean형식으로 방을 만든다 2번까지 감옥을 만들고 돌린다.

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int tc =0; tc<testCase; tc++){

            int n = sc.nextInt();
            int result = 0;

            boolean[] arr = new boolean[n+1];

            for(int i =0; i<=n; i++){

                if(i % 2 == 0){
                    arr[i] = false;
                }else{
                    arr[i] = true;
                }

            }

            for(int i = 3; i<=n; i++){

                for(int j=1; j<=n; j++){

                    if(j % i == 0){

                        if(arr[j]){
                            arr[j] =false;
                        }
                        else{
                            arr[j] =true;
                        }

                    }

                }

            }

            for(int i=1; i<=n; i++){
                if(arr[i]){
                    result++;
                }
            }

            System.out.println(result);






        }

    }
}
