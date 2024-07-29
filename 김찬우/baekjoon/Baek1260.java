    package com.example.codingtest.bfs;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.StringTokenizer;

    public class Baek1260 {

        static int n,m,k;
        static int[][] arr;
        static boolean[] visited;

        static int[] dx = {1,0,-1,0};
        static int[] dy = {0,1,0,-1};


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n+1][n+1];
            visited = new boolean[n+1];

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            dfs(k);


            System.out.println();
            visited = new boolean[n+1];

            bfs(k);





        }

        static void dfs(int node) {

            visited[node] = true;
            System.out.print(node+" ");

            for (int i=1; i < arr[node].length; i++) {

                if (!visited[i] && arr[node][i] != 0) {
                    dfs(i);
                }
            }

        }

        static void bfs(int node) {

            visited[node] = true;

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(node);

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();

                System.out.print(poll+" ");

                for (int i=1; i < arr[poll].length; i++) {

                    if (!visited[i] && arr[poll][i] != 0) {
                        visited[i] = true;
                        queue.offer(i);

                    }

                }
            }


        }
    }
