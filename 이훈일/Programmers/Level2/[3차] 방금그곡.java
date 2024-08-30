import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        HashMap<String, String> sheets = new HashMap<>();
        HashMap<String, Integer> starts = new HashMap<>();
        
        for(String line : musicinfos) {
            String[] info = line.split(",");
            String title = info[2];
            String sheet = changeSheet(info[3]);
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            
            int startTime = 0;
            startTime += Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            starts.put(title, startTime);
            
            int endTime = 0;
            endTime += Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            
            int time = endTime - startTime;
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < time; i++) {
                sb.append(sheet.charAt(i % sheet.length()));
            }
            
            sheets.put(title, sb.toString());
        }
        
        List<String> titles = new ArrayList<>(sheets.keySet());
        Collections.sort(titles, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int len1 = sheets.get(s1).length();
                int len2 = sheets.get(s2).length();
                
                if(len1 == len2) {
                    return starts.get(s1) - starts.get(s2);
                } else {
                    return len2 - len1;
                }
            }
        });
        
        String answer = "";
        String mSheet = changeSheet(m);
        for(String title : titles) {
            String sheet = sheets.get(title);
            
            if(sheet.contains(mSheet)) {
                answer = title;
                break;
            }
        }
        
        if(answer.length() == 0) {
            answer = "(None)";
        }
        
        return answer;
    }
    
    public String changeSheet(String sheet) {
        sheet = sheet.replaceAll("A#", "H");
        sheet = sheet.replaceAll("B#", "I");
        sheet = sheet.replaceAll("C#", "J");
        sheet = sheet.replaceAll("D#", "K");
        sheet = sheet.replaceAll("E#", "L");
        sheet = sheet.replaceAll("F#", "M");
        sheet = sheet.replaceAll("G#", "N");
        return sheet;
    }
}
