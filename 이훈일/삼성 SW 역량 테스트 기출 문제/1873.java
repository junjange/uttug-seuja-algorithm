import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    public static String[][] gameMap;
    public static int H;
    public static int W;
    public static int[] cur;
    public static HashMap<String, String> dir = new HashMap<String, String>(){{
    	put("U", "^");
        put("D", "v");
        put("L", "<");
        put("R", ">");
    }};
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
            W = sc.nextInt();
            
            cur = new int[2];
            gameMap = new String[H][W];
            for(int i = 0; i < H; i++) {
            	String line = sc.next();
                gameMap[i] = line.split("");
                for(int j = 0; j < W; j++) {
                	if(gameMap[i][j].equals("<") || gameMap[i][j].equals(">") || gameMap[i][j].equals("^") || gameMap[i][j].equals("v")) {
                    	cur[0] = i;
                        cur[1] = j;
                    }
                }
            }
            
            int N = sc.nextInt();
            String line = sc.next();
            String[] commands = line.split("");
            
            for(String command : commands) {
            	if(command.equals("U")) {
                    execute(cur[0] - 1, cur[1], command);
                } else if(command.equals("D")) {
                	execute(cur[0] + 1, cur[1], command);
                } else if(command.equals("L")) {
                	execute(cur[0], cur[1] - 1, command);
                } else if(command.equals("R")) {
                	execute(cur[0], cur[1] + 1, command);
                } else if(command.equals("S")) {
                	shoot();
                }
            }
            
            for(int i = 0; i < H; i++) {
                String result = "";
                if(i == 0) {
                	result = "#" + test_case + " ";
                }
            	for(int j = 0; j < W; j++) {
                	result += gameMap[i][j];
                }
                System.out.println(result);
            }
		}
	}
    
    public static void execute(int x, int y, String command) {
    	if(x >= 0 && x < H && y >= 0 && y < W && gameMap[x][y].equals(".")) {
        	gameMap[cur[0]][cur[1]] = ".";
            cur[0] = x;
            cur[1] = y;
            gameMap[cur[0]][cur[1]] = dir.get(command);
        } else {
        	gameMap[cur[0]][cur[1]] = dir.get(command);
        }
    }
    
    public static void shoot() {
   		if(gameMap[cur[0]][cur[1]].equals("^")){
        	for(int i = cur[0]; i >= 0; i--) {
            	if(gameMap[i][cur[1]].equals("*")) {
                	gameMap[i][cur[1]] = ".";
                    break;
                } else if(gameMap[i][cur[1]].equals("#")) {
                	break;
                }
            }
        } else if(gameMap[cur[0]][cur[1]].equals("v")) {
        	for(int i = cur[0]; i < H; i++) {
            	if(gameMap[i][cur[1]].equals("*")) {
                	gameMap[i][cur[1]] = ".";
                    break;
                } else if(gameMap[i][cur[1]].equals("#")) {
                	break;
                }
            }
        } else if(gameMap[cur[0]][cur[1]].equals("<")) {
        	for(int j = cur[1]; j >= 0; j--) {
            	if(gameMap[cur[0]][j].equals("*")) {
                	gameMap[cur[0]][j] = ".";
                    break;
                } else if(gameMap[cur[0]][j].equals("#")) {
                	break;
                }
            }
        } else if(gameMap[cur[0]][cur[1]].equals(">")) {
        	for(int j = cur[1]; j < W; j++) {
            	if(gameMap[cur[0]][j].equals("*")) {
                	gameMap[cur[0]][j] = ".";
                    break;
                } else if(gameMap[cur[0]][j].equals("#")) {
                	break;
                }
            }
        }
    }
}
