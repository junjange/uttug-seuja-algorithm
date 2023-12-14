package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek10709 {

    static char[][] arr;

    static int[][] result;
    static int h,w;

    static int sec = -1;


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);


        h = sc.nextInt();
        w = sc.nextInt();

        arr = new char[h][w];
        result = new int[h][w];
        boolean check = false;

        for(int i=0; i<h; i++ ){
            String next= sc.next();

            for(int j=0; j<w; j++){
                arr[i][j] = next.charAt(j);

            }

        }

        for(int i=0; i<h; i++ ){
            check = false;
            sec = -1;

            for(int j=0; j<w; j++){

                if(arr[i][j] == 'c'){
                    check = true;
                    sec = 0;
                    result[i][j] = sec;
                }else{

                    if(check){
                        sec++;
                        result[i][j] = sec;
                    }else {
                        sec =-1;
                        result[i][j] = sec;
                    }
                }

            }

        }

        for(int i=0; i<h; i++ ){


            for(int j=0; j<w; j++){

                System.out.print(result[i][j]+" ");

            }
            System.out.println();

        }









        // 아이디어
        // 배열을 만들고 한 줄씩 확인
        // c가 있으면 true로 변경 하고
        // true 일 때 초를 1씩 증가
    }
}
