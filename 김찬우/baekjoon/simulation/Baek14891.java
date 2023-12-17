package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baek14891 {

    static int[][] wheel = new int[5][8];

    public static void main(String[] args) {
        // 아이디어
        // 모든 톱니 바뀌를 배열로 일단 만든다.
        // 톱니바퀴의 회전을 함수로 만든다. 시계 방향, 반시계방향
        // 입력 받은 톱니 바퀴 기준으로 양쪽을 전부 확인한다.(좌측 우측)
        // 인덱스를 확인 하면서 같은 극이 나오면 중지

        //시간 복잡도
        // 상관 없을 거 같음


        Scanner sc = new Scanner(System.in);
        int result =0;

        for(int i=1; i<=4;i++){

            String next = sc.next();
            int[] arr = new int[8];

            for(int j=0; j<8; j++){
                arr[j] = next.charAt(j) -'0';
            }
            wheel[i] = arr;

        }

        int k = sc.nextInt();

        for(int p=0; p<k; p++){

            int n = sc.nextInt();
            int direction = sc.nextInt();

            int[] spin = new int[5];
            spin[n] = direction;


            for(int i=n; i<4;i++){

                if(wheel[i][2] != wheel[i+1][6]){
                    spin[i+1] = spin[i]*-1;

                }else{
                    break;
                }

            }

            for(int i=n; i>1; i--){

                if(wheel[i][6] != wheel[i-1][2]){
                    spin[i-1] = spin[i]*-1;
                }else{
                    break;
                }

            }

            for(int i=1; i<=4; i++){

                if(spin[i]==1){
                    rightSpin(i);
                } else if (spin[i]==-1) {
                    leftSpin(i);
                }else {
                    continue;
                }

            }



        }

        if(wheel[1][0]==1){
            result+=1;
        }
        if(wheel[2][0]==1){
            result+=2;
        }
        if(wheel[3][0]==1){
            result+=4;
        }
        if(wheel[4][0]==1){
            result+=8;
        }

        System.out.println(result);


    }

    public static void rightSpin(int num){

        int temp = wheel[num][7];

        for(int i=7; i>=1; i--){
            wheel[num][i] =  wheel[num][i-1];
        }

        wheel[num][0] = temp;

    }

    public static void leftSpin(int num){

        int temp = wheel[num][0];

        for(int i=0; i<7; i++){
            wheel[num][i] =  wheel[num][i+1];
        }

        wheel[num][7] = temp;

    }
}
