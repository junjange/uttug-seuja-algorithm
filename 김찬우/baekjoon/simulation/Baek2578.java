package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek2578 {

    static int[][] arr = new int[5][5];
    static int count = 0;
    static int BingoCount = 0;


    public static void main(String[] args) throws IOException {

        // 아이디어
        // 빙고 판을 만든다.
        // 입력을 받는다. 받으면서 빙고가 3개 만들었는지 확인

        // 시간 복잡도
        // 5*5*5*5*5;  // 크게 상관없을 듯

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<5; i++){

            for(int j=0; j<5; j++){
                arr[i][j] = sc.nextInt();
            }

        }




        while (true){

            int num = sc.nextInt();
            count++;


            loop1:
            for(int i=0; i<5; i++){

                for(int j=0; j<5; j++){

                    if(arr[i][j] == num){
                        arr[i][j] = 0;
                        break loop1;
                    }

                }

            }

            int status;

            for(int i=0; i<5; i++){

                status = 0;

                for(int j=0; j<5; j++){

                    if(arr[i][j] == 0){
                        status++;
                    }

                }

                if(status == 5){
                    BingoCount++;

                }

            }

            int status2;

            for(int i=0; i<5; i++){

                status2 = 0;

                for(int j=0; j<5; j++){

                    if(arr[j][i] == 0){
                        status2++;
                    }

                }

                if(status2 == 5){
                    BingoCount++;

                }

            }



            boolean check = true;

            for(int i=0; i<5; i++){

                if(arr[i][i] != 0){
                    check = false;
                    break;
                }

            }

            if (check){
                BingoCount++;

            }



            check = true;

            for(int i=0; i<5; i++){

                if(arr[i][4-i] != 0){
                    check = false;
                    break;
                }

            }

            if (check){
                BingoCount++;
            }

            if (BingoCount>=3){
                break;
            }else {
                BingoCount =0;
            }


        }

        System.out.println(count);


    }
}
