
import java.util.*;

public class Main{

    // 아이디어
    // 이중 for을 돌면서 arr[][] == 1 && visited[][] ==1 알때 bfs 돌면서 sum 변수에 +1

    // 시간복잡도
    // bfs(v+e) --> 25 + 25*4 < 1억

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};

    static int n;

    public static void main(String[] args) {

        int cnt =0;

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> result = new ArrayList<>();

        n= sc.nextInt();

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String next = sc.next();
            for(int j=0; j<n; j++){
                arr[i][j] = next.charAt(j)-'0';
            }

        }

        for (int i=0; i<n; i++){

            for (int j=0; j<n; j++){

                if(arr[i][j] == 1 && visited[i][j] == false){
                    cnt++;
                    visited[i][j] = true;
                    result.add(bfs(i,j));
                }

            }

        }

        Collections.sort(result);

        System.out.println(cnt);

        for(Integer num :result){
            System.out.println(num);
        }
    }

    public static int bfs(int x, int y){
        int sum = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()){

            int[] node = queue.poll();
            x = node[0];
            y = node[1];

            for(int i=0; i<4; i++){

                int nx = x+ dx[i];
                int ny = y+ dy[i];

                if(nx>=n || nx<0 || ny>=n || ny<0){
                    continue;
                }

                if(arr[nx][ny]==1 && visited[nx][ny] == false){
                    sum++;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});

                }
            }

        }

        return sum;
    }
}
