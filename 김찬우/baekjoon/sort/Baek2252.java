
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;

    static int[] degree;
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> result = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<n+1; i++) {
            list.add(new ArrayList<>());
        }

        degree = new int[n+1];

        for (int i= 0; i<m; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            degree[b]++;

        }
        
        bfs();
        while (!result.isEmpty()){
            System.out.print(result.poll()+" ");
        }


    }

    static void bfs() {

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i=1; i<=n; i++) {

            if (degree[i] == 0) {
                queue.offer(i);
            }
        }


        while (!queue.isEmpty()){
            int node = queue.poll();
            result.offer(node);

            List<Integer> meetNode = list.get(node);

            for (int i=0; i<meetNode.size(); i++) {

                Integer moveNode = meetNode.get(i);
                degree[moveNode]--;

                if ( degree[moveNode] == 0) {
                    queue.offer(moveNode);
                }

            }
        }

    }
}
