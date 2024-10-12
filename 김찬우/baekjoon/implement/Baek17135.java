package com.example.codingtest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek17135 {

    static int n,m,d;
    static int answer =0;
    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static List<int[]> archer = new ArrayList<>();
    static List<int[]> enemy = new ArrayList<>();
    static int[] result = new int[3];
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[m];
        back(0,visited);
        System.out.println(max);



    }

    static void back(int depth,boolean[] visited) {

        if (depth == 3) {
            answer = 0;
            enemy.clear();

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (map[i][j] == 1) {
                        enemy.add(new int[]{i,j});
                    }
                }
            }

            archer.clear();
            for (int i : result) {
                archer.add(new int[]{n,i});
            }

            while (true) {

                if (enemy.size() == 0) {
                    break;
                }

                for (int[] arc : archer) {

                    int min = Integer.MAX_VALUE;
                    int index = Integer.MAX_VALUE;
                    int resultIndex = -1;

                    for (int i=0; i<enemy.size(); i++) {

                        int[] enemyOne = enemy.get(i);

                        int distance = Math.abs(arc[0] - enemyOne[0]) + Math.abs(arc[1] - enemyOne[1]);
                        if (d >= distance) {

                            if (min > distance) {
                                min = distance;
                                index = enemyOne[1];
                                resultIndex = i;


                            }else if (min == distance) {

                                if (index > enemyOne[1]) {
                                    index = enemyOne[1];
                                    resultIndex = i;
                                }

                            }

                        }

                    }

                    if (min != Integer.MAX_VALUE && index != Integer.MAX_VALUE ) {
                        set.add(resultIndex);
                    }

                }

                ArrayList<Integer> arr = new ArrayList<>(set);
                Collections.sort(arr);

                int index = 0;
                for (Integer num : arr) {
                    enemy.remove(num + index);
                    index--;
                    answer++;
                }

                set.clear();



                int size = enemy.size();


                index = 0;
                for (int i=0; i<size; i++) {

                    int[] en = enemy.get(i+index);
                    if (en[0] + 1 >= n) {
                        enemy.remove(i+index);
                        index--;

                    }else {
                        enemy.get(i+index)[0] +=1;
                    }
                }

            }

            max = Math.max(max,answer);
            return;
        }

        for (int i=0; i<m; i++) {

            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                back(depth+1,visited);
                visited[i] = false;
            }
        }

    }

}
