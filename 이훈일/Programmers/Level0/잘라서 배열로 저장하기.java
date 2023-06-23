import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < my_str.length() - n; i += n) {
            list.add(my_str.substring(i, i + n));
        }
        list.add(my_str.substring(n*((my_str.length()-1)/n), my_str.length()));
        return list.toArray(new String[list.size()]);
    }
}
