package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek1063 {

    static int[][] arr;
    static int stoneX, stoneY;
    static int kingX, kingY;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int n;

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 2차원 배열을 만들고 킹과 돌이 둘달
        // 돌 또는 킹이 체스 판을 나가면 다음을 진행 (킹과 돌이 만났을 때)

        // 시간 복잡도

        Scanner sc = new Scanner(System.in);

        String king = sc.next();
        String stone = sc.next();
        n = sc.nextInt();

        kingX = 9 - (king.charAt(1) - '0');
        kingY = king.charAt(0);

        stoneX = 9 - (stone.charAt(1) - '0');
        stoneY = stone.charAt(0);


        for (int k = 0; k < n; k++) {

            int x;
            int y;
            int sx;
            int sy;

            String next = sc.next();
            int direction = getDirection(next);

            x = kingX + dx[direction];

            y = kingY + dy[direction];

            if (x < 1 || x > 8 || y < 'A' || y > 'H') {
                continue;
            }

            if (x == stoneX && y == stoneY) {

                sx = stoneX + dx[direction];
                sy = stoneY + dy[direction];

                if (sx >= 1 && sx <= 8 && sy >= 'A' && sy <= 'H') {
                    kingX = x;
                    kingY = y;
                    stoneX = sx;
                    stoneY = sy;
                }

            } else {
                kingX = x;
                kingY = y;
            }
        }

        System.out.println((char) kingY + "" + (9-kingX));
        System.out.println((char) stoneY + "" + (9-stoneX));


    }
        static int getDirection (String cmd){

            switch (cmd) {
                case "L":
                    return 0;
                case "LT":
                    return 1;
                case "T":
                    return 2;
                case "RT":
                    return 3;
                case "R":
                    return 4;
                case "RB":
                    return 5;
                case "B":
                    return 6;
                default:
                    return 7;
            }
        }

}
