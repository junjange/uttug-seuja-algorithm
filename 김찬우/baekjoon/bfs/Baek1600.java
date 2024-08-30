import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map = new int[200][200];
	static int k,n,m;
	static int[][][] visited;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	
	static int [] nightDx = {-2,-1,1,2,2,1,-1,-2};
	static int [] nightDy = {1,2,2,1,-1,-2,-2,-1};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		
		for (int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0, 0, 0);


		
	}
	
	static void bfs (int x, int y , int count) {
		
		
		visited = new int[n][m][k+1];
		
		visited[x][y][count] = 0;
		
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {x,y,count});
		
		while(!queue.isEmpty() ) {
			
			int[] node = queue.poll();
			
			x = node[0];
			y = node[1];
			count = node[2];
			
			if (x == n - 1 && y == m - 1) {
				System.out.println(visited[x][y][count]);
				return;
			}
		
			
			for(int i=0; i<4; i++) {
				
				int nx = x + dx[i];
				int ny = y + dy[i];
			
				
				if (nx <0 || nx >=n || ny <0 || ny >=m || map[nx][ny] == 1||visited[nx][ny][count] != 0) {
					continue;
				}
				
	
					
				visited[nx][ny][count] = visited[x][y][count] + 1;
				queue.offer(new int[] {nx,ny,count});
				
				
			}
			
			
			if (count < k) {
				
				for (int i=0; i<8; i++) {
					
					int nx = x + nightDx[i];
					int ny = y + nightDy[i];
					
					
					if (nx < 0 || nx >=n || ny < 0 || ny >=m ||  map[nx][ny] == 1 || visited[nx][ny][count+1] != 0) {
						continue;
					}
					
					
		
					visited[nx][ny][count+1] = visited[x][y][count] + 1;
					queue.offer(new int[] {nx,ny,count+1});
					
			
					
					
				}
				
			}
			
			
		}
		
		System.out.println(-1);
		
		
	}

}
