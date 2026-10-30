class Solution {
    public boolean isValid(String s) {
        System.out.println(MAPPING);
        Deque<Character> stack;

        stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isOpening(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != MAPPING.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpening(Character c) {
        return c == '{' || c == '(' || c == '[';
    }
    
    private static final Map<Character, Character> MAPPING = Map.of('}', '{', ']', '[', ')', '(');
     
}
