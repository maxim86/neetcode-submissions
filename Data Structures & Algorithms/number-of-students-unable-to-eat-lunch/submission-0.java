class Solution {
    
    public int countStudents(int[] students, int[] sandwiches) {
        Map<Integer, Integer> pref = new HashMap<>(); // sandwichType, count

        for (int i = 0; i < students.length; i++) {
            var k = students[i];
            var count = pref.get(k);
            count = count == null ? 1 : count + 1;
            pref.put(k, count);
        }

        for(int i = 0; i < sandwiches.length; i++) {
            var sfs = pref.getOrDefault(sandwiches[i], 0);
            if (sfs > 0) {
                pref.put(sandwiches[i], sfs - 1);
            } else {
                break;
            }
        }

        return pref.getOrDefault(0, 0) + pref.getOrDefault(1, 0);
    }
}