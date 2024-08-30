package com.example.codingtest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek10828 {
    public static void main(String[] args) throws IOException {
        // 아이디어
        // 스택 구현

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String next = st.nextToken();

            if(next.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (next.equals("top")) {

                try{
                    Integer peek = stack.peek();
                    sb.append(peek);
                    sb.append("\n");


                }catch (Exception e){
                    sb.append("-1");
                    sb.append("\n");
                }

            }else if (next.equals("size")) {
                sb.append(stack.size());
                sb.append("\n");

            }else if (next.equals("empty")) {
                if (stack.isEmpty()){
                    sb.append("1");
                    sb.append("\n");
                }else {
                    sb.append("0");
                    sb.append("\n");
                }

            }else if (next.equals("pop")) {

               try {
                   Integer pop = stack.pop();
                   sb.append(pop);
                   sb.append("\n");

               }catch (Exception e){
                   sb.append("-1");
                   sb.append("\n");
               }

            }


        }

        System.out.println(sb);
    }
}
