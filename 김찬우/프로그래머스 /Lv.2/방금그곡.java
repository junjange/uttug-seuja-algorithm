import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
       m = m.replace("C#", "c")
        .replace("D#", "d")
        .replace("F#", "f")
        .replace("G#", "g")
        .replace("A#", "a")
        .replaceAll("B#", "b")
        .replace("E#", "e");
        
        ArrayList<int[]> list =  new ArrayList<>();
        
        for(int i=0; i<musicinfos.length; i++){
            
            
            String[] split = musicinfos[i].split(",");
            
            String startTime = split[0];
            String endTime = split[1];
            String title = split[2];
            String sing = split[3];
            
            String[] starths = startTime.split(":");
            String[] endhs = endTime.split(":");
            
            int startHour = Integer.parseInt(starths[0]);
            int endHour = Integer.parseInt(endhs[0]);
            
            int startSec = Integer.parseInt(starths[1]);
            int endSec = Integer.parseInt(endhs[1]);
            
            int time = (endHour*60 + endSec) - (startHour*60 + startSec);
            
    
            
            
            String[] word = new String[split[3].length() - (split[3].length() - split[3].replace("#","").length())];
            
            String result = "";
            
            int p = 0;
            for(int j = 0; j < split[3].length(); j++){
                
                char w = split[3].charAt(j);
                
                if(w == '#'){
                    
                    word[p-1] = String.valueOf(split[3].charAt(j-1)).toLowerCase();
                    continue;
                }else{
                    word[p] = w + "";
                    p++;
                }
                
            }
            
            
            
            for(int j=0; j < time; j++){
                
                result+= word[j % word.length];
            }
            
            if(result.contains(m)){
                list.add(new int[]{time,i});
            }
            
            
            Collections.sort(list, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2) {
                
                if(o2[0] == o1[0]){
                    return o1[1] - o2[1];
                }else{
                       return o2[0] - o1[0];
                }
                
                }
            });
            
         
        }

            
        if(list.size() == 0){
            answer = "(None)";
        }else{
            answer =  musicinfos[list.get(0)[1]].split(",")[2];
        }
        
        return answer;
    }
}
