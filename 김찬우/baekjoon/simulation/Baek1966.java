package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1966 {
    
    static int[] arr;
    
    static int tc,n,m;
    
    static Queue<int[]> queue = new LinkedList<>();
    
    static int result;

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 우선순위 큐 사용
        //  index와 우선 순위를 큐에 저장 하면서 구현한다.
        // arr[]에서 가장큰값을 확인?
        
        // 시간복잡도 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        tc = Integer.parseInt(br.readLine());
        
        for(int test = 1; test <= tc; test++){

            result = 1;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            n= Integer.parseInt(st.nextToken());
            m= Integer.parseInt(st.nextToken());
            
            arr= new int[n];
            queue.clear();
            
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{arr[i],i});
            }


            Arrays.sort(arr);

            int i = arr.length - 1;
            int max = arr[i];

            while(!queue.isEmpty()) {

                int[] poll = queue.poll();

                if(poll[0] == max && poll[1] == m){
                    break;
                }

                if(poll[0] < max){
                    queue.offer(poll);
                } else if (poll[0] == max) {
                    result++;
                    i--;
                    max = arr[i];
                }


            }

            System.out.println(result);


        }


    }
}
