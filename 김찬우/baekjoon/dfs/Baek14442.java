
import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map = new int[1000][1000];
	static int[][][] visited;
	static int n,m,k;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			for (int j=0; j<m; j++) {
				
				map[i][j] = str.charAt(j) - '0';
					
			}
		}
		
		bfs(0, 0, 0);
		
		
		
		
	}
	
	static void bfs(int x, int y, int count) {
		
		visited = new int[n][m][k+1];
		
		visited[x][y][count] = 1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x,y,count});
		
		
		while(!queue.isEmpty()) {
			
			int[] node = queue.poll();
			
			x = node[0];
			y = node[1];
			count = node[2];
			
			
			if (x == n-1 && y == m-1) {
				System.out.println(visited[n-1][m-1][count]);
				return;
			}
			
			for (int i=0; i<4; i++ ) {
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx <0 || nx >=n || ny <0 || ny>=m ) {
					continue;
				}
				
				if (map[nx][ny] == 0) {
					
					if (visited[nx][ny][count] == 0) {
						visited[nx][ny][count] = visited[x][y][count] + 1;
						queue.offer(new int[] {nx,ny,count});
					}
					
				}else {
					
					
					if (count < k) {
						
						if (visited[nx][ny][count + 1] == 0) {
							visited[nx][ny][count + 1] = visited[x][y][count] + 1;
							queue.offer(new int[] {nx,ny,count+1});
						
						
						}
					
					}
					
				}
			}
		}
		
		System.out.println(-1);
		
		
		
	}

}
