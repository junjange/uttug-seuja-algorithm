package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek14470 {
    public static void main(String[] args) throws IOException {

        // 아이디어
        // 고기 a를 b까지 만드는대 걸리는 시간

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int result = 0;

        int status = 0;

        if(a<0){

            while (a!=0){
                a++;
                result+=c;

            }

            result+=d;

            result+=(e*b);

            System.out.println(result);



        } else if (a>0) {

            result = (b-a)*e;
            System.out.println(result);
        }


    }
}
