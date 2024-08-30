import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nickname = new HashMap<>();
        String[][] arr = new String[record.length][2];
        int count = 0;
        for(int i = 0; i < record.length; i++) {
            String[] records = record[i].split(" "); 
            
            if(records[0].equals("Change")) {
                nickname.put(records[1], records[2]);
            } else if(records[0].equals("Enter")) {
                nickname.put(records[1], records[2]);
                arr[count][0] = records[1];
                arr[count][1] = records[0];
                count++;
            } else {
                arr[count][0] = records[1];
                arr[count][1] = records[0];
                count++;
            }
        }
        
        String[] result = new String[count];
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        for(int i = 0; i < count; i++) {
            if(arr[i][1].equals("Enter")) {
                result[i] = nickname.get(arr[i][0]) + enter;
            } else if(arr[i][1].equals("Leave")) {
                result[i] = nickname.get(arr[i][0]) + leave;
            }
        }
        
        return result;
    }
}
