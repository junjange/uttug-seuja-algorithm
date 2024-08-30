package com.example.codingtest.implement;

import java.util.Scanner;

public class Baek11721 {
    public static void main(String[] args) {
        // 아이디어
        //Stringbuilde subString 사용

        //시간 복잡도

        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(int i=0; i<word.length(); i++){

            sb.append(word.charAt(i));
            count++;

            if(count==10){
                System.out.println(sb);
                count=0;
                sb.setLength(0);
            }


        }

        System.out.println(sb);

    }
}
