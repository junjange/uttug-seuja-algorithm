package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14888 {

    public static int n;
    public static int[] arr;
    public static int[] oper = new int[4];
    public static int Max = Integer.MIN_VALUE;
    public static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 리스트로 배열을 하나 만든다 n하나를 뽑는다
        // 연산자 리스트를 만든다.


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }


        rec(arr[0],1);

        System.out.println(Max);
        System.out.println(Min);






    }

    public static void rec(int num,int index){


        if(index == n){
            Max = Math.max(Max,num);
            Min = Math.min(Min,num);
            return;
        }


        for(int i=0; i<4; i++){

            if(oper[i]>0){

                oper[i]--;

                if(i==0){
                    rec(num + arr[index],index+1);
                    //break;
                } else if (i==1) {
                    rec(num - arr[index],index+1);
                    //break;
                }else if (i==2) {
                    rec(num * arr[index],index+1);
                    //break;
                }else if (i==3) {
                    rec(num / arr[index],index+1);
                    //break;
                }

                oper[i]++;

            }


        }


    }
}
