import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String[][] graph;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] carWash;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        graph = new String[N][M];
        for(int i = 0; i < N; i++) {
            String[] words = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                graph[i][j] = words[j];
                if(graph[i][j].equals("*")) {
                    queue.add(new int[]{i, j});
                } else if(graph[i][j].equals("W")) {
                    carWash = new int[]{i, j, 0};
                }
            }
        }

        int count = bfs();
        if(count == 0) {
            System.out.println("FAIL");
        } else {
            System.out.println(count);
        }
    }

    public static int bfs() {
        queue.add(carWash);

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            visited[x][y] = true;
            for(int i  = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if(graph[x][y].equals("*")) {
                        if(graph[nx][ny].equals(".")) {
                            visited[nx][ny] = true;
                            graph[nx][ny] = "*";
                            queue.add(new int[]{nx, ny});
                        }
                    } else {
                        if(graph[nx][ny].equals("H")) {
                            return node[2] + 1;
                        } else if(graph[nx][ny].equals(".")) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny, node[2]+1});
                        }
                    }
                }
            }
        }
        return 0;
    }
}
