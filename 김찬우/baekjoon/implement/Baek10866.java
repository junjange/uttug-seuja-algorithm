package com.example.codingtest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Baek10866 {
    public static void main(String[] args) throws IOException {

        //아이디어
        // 자바의 deque를 구현한다.

        // 시간 복잡도

        Deque<Integer>  deque = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        for(int i=0; i<n; i++){

            String next = sc.next();

            if(next.equals("push_front")){
                int num = sc.nextInt();
                deque.offerFirst(num);
            } else if (next.equals("push_back")) {
                int num = sc.nextInt();
                deque.offerLast(num);
            }  else if (next.equals("pop_front")) {
                Integer pollFirst = deque.pollFirst();

                if(pollFirst == null){
                    sb.append("-1");
                    sb.append("\n");

                }else {
                    sb.append(pollFirst);
                    sb.append("\n");
                }
            } else if (next.equals("pop_back")) {
                Integer pollBack = deque.pollLast();

                if(pollBack == null){
                    sb.append("-1");
                    sb.append("\n");
                }else {
                    sb.append(pollBack);
                    sb.append("\n");
                }
            } else if (next.equals("size")) {
                sb.append(deque.size());
                sb.append("\n");
            } else if (next.equals("empty")) {
                if(deque.isEmpty()){
                    sb.append("1");
                    sb.append("\n");
                }else {
                    sb.append("0");
                    sb.append("\n");
                }

            } else if (next.equals("front")) {

                Integer peekFirst = deque.peekFirst();

                if(peekFirst == null){
                    sb.append("-1");
                    sb.append("\n");
                }else {
                    sb.append(peekFirst);
                    sb.append("\n");
                }

            } else if (next.equals("back")) {
                Integer peekLast = deque.peekLast();
                if (peekLast == null){
                    sb.append("-1");
                    sb.append("\n");
                }else {
                    sb.append(peekLast);
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
