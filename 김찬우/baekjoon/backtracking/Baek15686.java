package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek15686 {

    static int n,m;
    static int[][] map;

    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> check = new ArrayList<>();

    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[] chickenVisited;

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 집과 치킨집의 좌표를 각각 리스트로 만들어 저장한다.
        // 치킨집을 m개 까지 백트레킹
        // 거리의 최소값을 구해서 나중에 더한 값의 최솟값 찾기

        // 시간 복잡도
        // 최대 13 제곱?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine()," ");

            for(int j=0; j<n; j++){

                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    house.add(new int[]{i,j});
                }else if(map[i][j] == 2){
                    chicken.add(new int[]{i,j});
                }


            }
        }

        chickenVisited = new boolean[chicken.size()];

        rec(0,0);

        Collections.sort(result);
        System.out.println(result.get(0));




    }

    public static void rec(int start, int depth){

        if(depth == m){
            result.add(cityChickenStreet());
            return;
        }

        for(int i=start; i<chicken.size(); i++){

            if(!chickenVisited[i]){
                chickenVisited[i] = true;
                check.add(chicken.get(i));
                rec(i+1,depth+1);
                check.remove(check.size()-1);
                chickenVisited[i] = false;

            }

        }

    }

    public static int cityChickenStreet(){

        int sum = 0;

        int min;

        for(int i=0; i<house.size(); i++){

           min = Integer.MAX_VALUE;

           for(int j=0; j<check.size(); j++){

               int[] housP = house.get(i);
               int[] chickP = check.get(j);

               int dist = Math.abs(housP[0]-chickP[0])+Math.abs(housP[1]-chickP[1]);
               min = Math.min(dist,min);

            }

           sum+=min;
        }

        return sum;

    }
}
