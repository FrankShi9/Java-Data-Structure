import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class countWords {

    /** Construct histogram of counts of all words in a file */
    public Map<String, Integer> countwords(Scanner scan){
        Map<String, Integer> counts = new HashMap<String, Integer>();
        while(scan.hasNext()){
            String word = scan.next();
            if(counts.containsKey(word))
                counts.put(word, counts.get(word)+1);
            else
                counts.put(word, 1);
        }
        return counts;
    }


    /** Find word in histogram with highest count */
    public String findMaxCount(Map<String, Integer> counts){
        String maxWord = null;
        int maxCount = -1;
        for(String word: counts.keySet()){
            int count = counts.get(word);
            if(count>maxCount){
                maxCount = count;
                maxWord = word;
            }
        }
        return maxWord;
    }
}
