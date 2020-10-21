class Solution {
    public boolean isValid(String s) {
        // Load our known values
        Set<Character> leftParenthesis = Set.of('(', '[', '{');
        Set<Character> rightParenthesis = Set.of(')', ']', '}');
        Map<Character, Character> matchingParenthesis = Map.of('(', ')', '[', ']', '{', '}');
        
        // Push left parenthesis onto the stack, pop when there's a right parenthesis
        Stack<Character> parenthesisStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (leftParenthesis.contains(c)) {
                parenthesisStack.push(c);
            } else if (rightParenthesis.contains(c)) {
                // check if there are any open left parenthesis
                if (parenthesisStack.empty()) {
                    return false;
                }
                
                // check if right parenthesis matches the most recent open left parenthesis
                char expectedParenthesis = matchingParenthesis.get(parenthesisStack.peek()).charValue();
                if (c != expectedParenthesis) {
                    return false;
                }
                
                parenthesisStack.pop();
            } else {
                // ideally I would throw here, but this problem would never even get here since it doesn't have invalid characters
                return false;
            }
        }
        
        // non-empty stack means there are unmatched left parenthesis
        return parenthesisStack.empty();
    }
}