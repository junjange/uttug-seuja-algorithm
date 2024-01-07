package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10103 {
    public static void main(String[] args) throws IOException {
        // 아이디어


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int first = 100;
        int second = 100;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int chang = Integer.parseInt(st.nextToken());
            int sung = Integer.parseInt(st.nextToken());

            if(chang>sung){
                second-=chang;
            }else if(sung>chang){
                first-=sung;
            }


        }

        System.out.println(first);
        System.out.println(second);


    }
}
