package com.example.codingtest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1158 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<n; i++) {
            queue.offer(i+1);
        }

        while (queue.size() > 1){

            for (int i=0; i < k-1; i++) {
                queue.offer(queue.poll());
            }

            list.add(queue.poll());

        }

        list.add(queue.poll());


        System.out.print("<");
        for (int i=0; i<n; i++) {
            if (i == n-1) {
                System.out.print(list.get(i)+">");
            } else {
                System.out.print(list.get(i)+ ", ");
            }


        }



    }
}
