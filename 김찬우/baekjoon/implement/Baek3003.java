package com.example.codingtest.implement;

import java.util.Scanner;

public class Baek3003 {
    public static void main(String[] args) {
        //아이디어
        //리스트에 저

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        int[] role = {1,1,2,2,2,8};


        for(int i=0; i<6; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<6; i++){

            if(role[i] > arr[i]){
                arr[i] = role[i]-arr[i];
            } else if (role[i] == arr[i]) {
                arr[i] = 0;
            }else if (role[i] < arr[i]) {
                arr[i] =  role[i] -arr[i];
            }
        }

        for(int num :arr){
            System.out.print(num+" ");
        }
    }
}
