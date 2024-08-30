package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1759 {

    static int L;
    static int C;
    static char[] arr;
    static char[] code;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];

        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i< C; i++){

            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr); // 사전순으로 정렬

        backTracking(0,0);


    }

    public static void backTracking(int start ,int depth){

        if(depth == L){
            if(isValid(code)){

                for (char a : code){
                    System.out.print(a);
                }
                System.out.println();

            }
            return;
        }

        for(int i=start; i<C; i++){

            code[depth] = arr[i];
            backTracking(i+1,depth+1);

        }

    }

    public static boolean isValid(char[] code) {
        int c = 0;
        int v = 0;
        for (int i = 0; i < code.length; i++) {
            if (code[i] == 'a' || code[i] == 'e' || code[i] == 'i' || code[i] == 'o' || code[i] == 'u') {
                v++;
            } else {
                c++;
            }
        }
        if (c >= 2 && v >= 1) {
            return true;
        } else {
            return  false;
        }
    }
}
