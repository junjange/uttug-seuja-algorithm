package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek13335 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int sec = 0;

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {

            truck.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i<w; i++) {

            bridge.offer(0);
        }

        int currentBridgeWight = 0;

        while (!bridge.isEmpty()) {

            sec++;
            currentBridgeWight -= bridge.poll();

            if (!truck.isEmpty()) {

                if (currentBridgeWight + truck.peek() <= l) {
                    bridge.offer(truck.peek());
                    currentBridgeWight += truck.poll();

                }else {
                    bridge.offer(0);
                }

            }

        }

        System.out.println(sec);

    }
}
