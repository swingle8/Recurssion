//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/submissions/

class Solution {
    public String removeDuplicates(String s, int k) {
        int len = s.length();
        char prev = ' ';
        int freq = 1;
        
        for (int i = 0 ; i < len ; i++) {
            char curr = s.charAt(i);
            if (prev == curr)
                freq++;
            else
                freq = 1;
            
            if (freq == k) {
                return removeDuplicates (s.substring(0, i-k+1) + s.substring(i+1) , k);
            }
            
            prev = curr;
        }
        
        return s;
    }
}