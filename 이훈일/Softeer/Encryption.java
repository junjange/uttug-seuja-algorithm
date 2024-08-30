package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Encryption {
    static char[][] graph = new char[5][5];
    static HashMap<Character, int[]> map = new HashMap<>();
    static String message, key;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        message = br.readLine();
        key = br.readLine();

        String newMessage = parsingMessage();

        makeGraph(newMessage);

        String encryption = encryption(newMessage);
        System.out.println(encryption);
    }

    public static void makeGraph(String newMessage) {
        List<Character> visited = new ArrayList<>(){{
            add(key.charAt(0));
        }};
        graph[0][0] = key.charAt(0);
        if(newMessage.contains(String.valueOf(key.charAt(0)))) {
            map.put(key.charAt(0), new int[]{0, 0});
        }

        int index = 1;
        for(int i = 1; i < key.length(); i++) {
            char oneChar = key.charAt(i);
            if(!visited.contains(oneChar)) {
                if(newMessage.contains(String.valueOf(oneChar))) {
                    map.put(oneChar, new int[]{index/5, index%5});
                }
                graph[index/5][index%5] = oneChar;
                visited.add(oneChar);
                index++;
            }
        }

        for(char i = 65; i <= 90; i++) {
            if(!visited.contains(i) && i != 'J') {
                if(newMessage.contains(String.valueOf(i))) {
                    map.put(i, new int[]{index/5, index%5});
                }
                graph[index/5][index%5] = i;
                visited.add(i);
                index++;
            }
        }
    }

    public static String parsingMessage() {
        int index = 0;
        String newMessage = "";
        while(index < message.length()) {
            char currentChar = message.charAt(index);
            char nextChar;
            if(index == message.length()-1) {
                nextChar = 'X';
                newMessage += currentChar;
                newMessage += nextChar;
                index++;
            } else {
                nextChar = message.charAt(index+1);

                if(currentChar == nextChar) {
                    if(currentChar == 'X') {
                        newMessage += currentChar + "Q";
                    } else {
                        newMessage += currentChar + "X";
                    }
                    index++;
                } else {
                    newMessage += currentChar;
                    newMessage += nextChar;
                    index += 2;
                }
            }
        }

        return newMessage;
    }

    public static String encryption(String newMessage) {
        String result = "";
        for(int i = 0; i < newMessage.length(); i += 2) {
            int[] first = map.get(newMessage.charAt(i));
            int[] second = map.get(newMessage.charAt(i+1));
            if(first[0] == second[0]) {
                result += graph[first[0]][(first[1] + 1) % 5];
                result += graph[second[0]][(second[1] + 1) % 5];
            } else if(first[1] == second[1]) {
                result += graph[(first[0] + 1) % 5][first[1]];
                result += graph[(second[0] + 1) % 5][second[1]];
            } else {
                result += graph[first[0]][second[1]];
                result += graph[second[0]][first[1]];
            }
        }

        return result;
    }
}
