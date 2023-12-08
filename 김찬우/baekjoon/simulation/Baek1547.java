package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1547 {

    static int[] arr = new int[3];

    static int m,left,right;

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 순서대로 배열을 만들고  컵을 바꿔준다. 그리고 인덱스 0을 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m= Integer.parseInt(br.readLine());


        for(int i=0; i<3; i++){
            arr[i] = i+1;
        }


        for(int i=0; i<m; i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());

            int leftIndex = 0;
            int rightIndex = 0;
            int temp = 0;

            for(int j=0; j<3; j++){

                if(arr[j] == left){
                    leftIndex =j;
                    break;
                }

            }

            for(int j=0; j<3; j++){

                if(arr[j] == right){
                    rightIndex = j;
                    break;
                }

            }

            temp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = temp;

            

        }

        System.out.println(arr[0]);


    }
}
