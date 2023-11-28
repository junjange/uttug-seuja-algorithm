import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] arr;

    static int N,M;
    static boolean[] visited;

    public static void main(String[] args) {

        // 아이디어
        // 2차원 리스트를 만든다. 리스트를 돌면서 방문하지 않은 노드를 bfs 하면서 전체 cnt +1을 한다.

        //시간 복잡도
        // bfs(50*50 + 50*50*4) <1억

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int cnt = 0;

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }



        for(int j=0; j<M; j++){

            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a].add(b);
            arr[b].add(a);

        }


        for(int i=1; i<=N; i++){

            if(!visited[i]){
                visited[i] = true;
                bfs(i);
                cnt++;
            }

        }

        System.out.println(cnt);



    }

    public static void bfs(int node){

       Queue<Integer> queue =  new LinkedList<>();
       queue.offer(node);

       while(!queue.isEmpty()){

           int nodeNum = queue.poll();


           for(int i=0; i<arr[nodeNum].size(); i++){

               int result = arr[nodeNum].get(i);

               if (!visited[result]){
                   visited[result] = true;
                   queue.offer(result);
               }

           }

       }

    }



}
