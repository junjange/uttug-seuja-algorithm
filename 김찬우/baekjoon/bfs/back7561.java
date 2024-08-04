
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] arr;
    static int n;
    static Queue<int[]> queue;

    static int[] dx = {1,-1,1,-1,2,2,-2,-2};
    static int[] dy = {-2,-2,2,2,1,-1,1,-1};

    static int startX;
    static int startY;
    static int EndX;
    static int EndY;

    static int result;

    static boolean[][] visited;

    public static void main(String[] args) {

        // 이중 for문을 생성 말이 갈수 있는 위치를 옮겨 가면서 visited[][] ==false dfs() 가는 곳에 arr[nx][ny] = arr[x][y]+1 x,y 값이 같을 때 종료

        // 시간 복잡도
        // 300*300 + 300*300*4

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for(int test = 0; test<tc; test++){

            n= sc.nextInt();
            arr= new int[n][n];
            visited = new boolean[n][n];
            queue = new LinkedList<>();

            result =0;

            startX = sc.nextInt();
            startY = sc.nextInt();
            EndX = sc.nextInt();
            EndY = sc.nextInt();

            if(startX == EndX && startY == EndY){
                result = 0;
            }else{
                queue.offer(new int[]{startX,startY});
                visited[startX][startY] = true;
                arr[startX][startY] = 1;
                bfs(startX,startY);
            }

            System.out.println(result);


        }

    }

    public static void bfs(int x, int y){

        while (!queue.isEmpty()){

            int[] node = queue.poll();
            x= node[0];
            y= node[1];

            for(int i=0; i<8; i++){

                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx == EndX && ny == EndY){
                    result = arr[x][y];
                    return;
                }

                if(nx >=n || nx<0 || ny >=n || ny<0){
                    continue;
                }

                if(!visited[nx][ny]){
                    arr[nx][ny] = arr[x][y]+1;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                }
            }



        }


    }


}
