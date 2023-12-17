package com.example.codingtest.simulation;

import java.util.Scanner;

public class Baek1592 {

    static int[] arr;
    static int currentMan = 0;

    static int count = 0;

    static int n,m,l;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n =sc.nextInt();
        m =sc.nextInt();
        l =sc.nextInt();

        arr = new int[n];


        while (true){

            count++;
            arr[currentMan]+=1;

            if(arr[currentMan]==m){
                break;
            }

            if(arr[currentMan] % 2 == 0){
                currentMan = (currentMan-l+n) % n;

            }else{
                currentMan = (currentMan+l) % n;
            }



        }

        System.out.println(count-1);

        // 아이디어
        // 배열을 만들고 나머지로 판단한다.



    }
}
