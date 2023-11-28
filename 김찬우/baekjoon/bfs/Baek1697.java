package com.example.codingtest.bfs;

import java.util.*;

public class Baek1697 {

    static int[] arr;
    static int N;
    static int K;

    static int[] move = {-1,1,2};

    public static void main(String[] args) {

        // 아이디어
        // 각 위치에서 갈수 있는 곳들을 큐에 넣는 하나씩 빼면서 갈수 있는 위치를 다시 큐에 삽입한다. bfs 를 돌면서 (+1 , -1 , *2 +- ) num +1
        // 그러다가 k 값을 만나면 종료

        // 시간 복잡도
        // bfs(100000+100000*4)

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[100001];

        if(N==K) {
            System.out.println(0);
        }else {

            arr[N] =1;
             bfs(N);

            System.out.println(arr[K]-1);
        }


    }

    public static void bfs(int n){

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);


        while (!queue.isEmpty()){

            Integer poll = queue.poll();


            if(poll == K){
                break;
            }

            for(int i=0; i<3; i++){

                int result = 0;

                if(i==2){
                    result =  poll*move[i];
                }
                else{
                    result = poll+move[i];
                }

                if(result<0 || result > 100000){
                    continue;
                }

                if(arr[result] == 0){
                    arr[result] = arr[poll]+1;
                    queue.offer(result);
                }


            }
        }


    }
}
