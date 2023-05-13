package dailyChallenge.may12;

import java.util.Comparator;
import java.util.HashMap;

public class Solution {

//    [[21,5],[92,3],[74,2],[39,4],[58,2],[5,5],[49,4],[65,3]]
    public long mostPoints(int[][] questions) {
        var map = new HashMap<Integer, Long>();
        for (int i = 0; i < questions.length; i++) {
            var currentIndex = i;
            while (currentIndex < questions.length) {
                long currentValue = map.containsKey(i) ? map.get(i) : 0;
                map.put(i, currentValue + questions[currentIndex][0]);
                currentIndex += questions[currentIndex][1] + 1;
            }
        }
        System.out.println(map);
        return map.values().stream().max(Comparator.naturalOrder()).get();
    }


}
