class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var counters1 = countLetters(s);
        var counters2 = countLetters(t);

        for(Map.Entry<Character, Integer> e: counters1.entrySet()) {
            if(! e.getValue().equals(counters2.get(e.getKey())))
            return false;
        }

        return true; 
    }

    private Map<Character, Integer> countLetters(String str) {
        Map<Character, Integer> counters  = new HashMap<>();

        for(char c: str.toCharArray()) {
            Integer count = counters.get(c);
            if(count == null) {
                counters.put(c, 1);
            } else {
                counters.put(c, count + 1);
            }
        }

        return counters;
    }
}