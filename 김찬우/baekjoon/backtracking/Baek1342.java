package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1342 {

    static int[] arr;

    static int len;

    static int count = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        arr = new int[26];
        len = str.length();

        for(int i=0; i<len; i++){
            arr[str.charAt(i) - 'a']++;
        }

        backTracking(0,' ');


        System.out.println(count);

    }

    public static void backTracking(int depth ,char before) {

        if(depth == len){

            count++;

            return;
        }

        for(int i =0; i < 26; i++){

            if(arr[i] == 0){
                continue;
            }

            if(before != (char) (i +'a')){
                arr[i]--;
                backTracking(depth+1,(char)(i+'a'));
                arr[i]++;

            }
        }
    }
}
