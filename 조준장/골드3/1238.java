package javaalog;

import java.io.*;
import java.util.*;

public class _1238 {

    static class Node implements Comparable<Node> {
        int position;
        int duration;

        Node(int position, int duration) {
            this.position = position;
            this.duration = duration;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.duration, other.duration);
        }
    }

    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int x = Integer.parseInt(firstLine[2]);
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        ArrayList<ArrayList<Node>> reversedGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] otherLine = br.readLine().split(" ");
            int s = Integer.parseInt(otherLine[0]);
            int e = Integer.parseInt(otherLine[1]);
            int t = Integer.parseInt(otherLine[2]);

            graph.get(s).add(new Node(e, t));
            reversedGraph.get(e).add(new Node(s, t));

        }

        int[] answerBfs = bfs(graph, x);
        int[] reversedAnswerBfs = bfs(reversedGraph, x);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, answerBfs[i] + reversedAnswerBfs[i]);

        }

        sb.append(answer);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static int[] bfs(ArrayList<ArrayList<Node>> newGraph, int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        boolean[] visited = new boolean[n + 1];
        int[] midDuration = new int[n + 1];
        Arrays.fill(midDuration, Integer.MAX_VALUE);
        midDuration[start] = 0;

        while (!queue.isEmpty()) {
            Node target = queue.poll();
            visited[target.position] = true;

            for (Node node : newGraph.get(target.position)) {
                if (!visited[node.position]) {
                    if (midDuration[node.position] > midDuration[target.position] + node.duration) {
                        midDuration[node.position] = midDuration[target.position] + node.duration;
                        queue.add(new Node(node.position, midDuration[node.position]));
                    }
                }
            }
        }
        return midDuration;
    }
}
