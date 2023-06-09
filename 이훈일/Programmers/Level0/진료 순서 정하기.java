import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] emergency) {
        Integer[] integerEmer = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        Arrays.sort(integerEmer, Collections.reverseOrder());
        return Arrays.stream(emergency).map(e -> Arrays.asList(integerEmer).indexOf(e) + 1).toArray();
    }
}
