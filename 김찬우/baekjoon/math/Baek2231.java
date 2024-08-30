package com.example.codingtest.math;

import java.util.Scanner;

public class Baek2231 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result =0;

        boolean check = true;

        for(int i=1; i<n; i++){

            int number =i;
            int sum = 0;

            while (number !=0){

                sum += number % 10;   
                number /= 10;

            }

            if(sum+i == n){
                result  = i;
                break;
            }

        }

        System.out.println(result);




    }
}
