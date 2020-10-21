class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // Base cases
        if (strs.length == 0) {
            return "";
        }
        
        if (strs.length == 1) {
            return strs[0];
        }
        
        // Add all words into a set to remove duplicates
        Set<String> words = new HashSet<>();
        
        String longestCommonPrefix = strs[0];
        int longestCommonPrefixLength = Integer.MAX_VALUE;
        
        for (String s : strs) {
            if (s.length() == 0) {
                return "";
            }
            
            if (s.length() < longestCommonPrefixLength) {
                longestCommonPrefix = s;
                longestCommonPrefixLength = s.length();
            }
            
            words.add(s);
        }
        
        // Base case round 2
        if (words.size() == 1) {
            return longestCommonPrefix;
        }
        
        // This is our starting word, don't need to process it
        words.remove(longestCommonPrefix);

        for (String word : words) {
            int i = -1;
            while (i + 1 < longestCommonPrefixLength && word.charAt(i + 1) == longestCommonPrefix.charAt(i + 1)) {
                i++;
            }
            
            // If no letters match, return empty string
            if (i == -1) {
                return "";
            }
            
            longestCommonPrefix = longestCommonPrefix.substring(0, i + 1);
            longestCommonPrefixLength = i + 1;
        }
        
        return longestCommonPrefix;
    }
}