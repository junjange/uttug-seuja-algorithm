import java.util.HashMap;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        HashMap<String, Integer> xMap = new HashMap<String, Integer>(){{
            for(int i = 0; i < 10; i++) {
                put(String.valueOf(i), 0);
            }
        }};

        HashMap<String, Integer> yMap = new HashMap<String, Integer>(){{
            for(int i = 0; i < 10; i++) {
                put(String.valueOf(i), 0);
            }
        }};

        for(String s : X.split("")) {
            xMap.put(s, xMap.get(s)+1);
        }

        for(String s : Y.split("")) {
            yMap.put(s, yMap.get(s)+1);
        }

        String result = "";

        for(String key : xMap.keySet()) {
            int xValue = xMap.get(key);
            int yValue = yMap.get(key);
            if(xValue != 0 && yValue != 0){
                if(xValue == yValue){
                    result += key.repeat(xValue);
                }else {
                    result += key.repeat(xValue > yValue ? yValue : xValue);
                }
            }
        }

        String[] resultArr = result.split("");
        Arrays.sort(resultArr, Collections.reverseOrder());
        result = String.join("",resultArr);

        if(result.length() == 0) {
            return "-1";
        }

        if(result.split("")[0].equals("0")) {
            return "0";
        }else {
            return result;
        }
    }
}
