//https://leetcode.com/problems/remove-invalid-parentheses/

class Solution {
    Set<String> set = new HashSet<String>();
    int removal = Integer.MAX_VALUE;
    public List<String> removeInvalidParentheses(String s) {
        set.clear();
        removal = Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder();
        calculate (s, 0, 0, 0, str, 0);
        List<String> ans = new ArrayList<String>(set);
        return ans;
    }
    
    public void calculate (String s, int index, int open, int close, StringBuilder str, int removeCount) {
        if (removeCount > removal || close > open)
            return;
        if (index == s.length() && close == open) {
            set.add(str.toString());
            removal = removeCount;
            return;
        }
        if (index == s.length())
            return;
        
        char curr = s.charAt(index);
        str.append(curr);
        if (curr == '(')
            open++;
        else if (curr == ')')
            close++;
        
        calculate(s, index+1, open, close, str, removeCount);
        
        str = str.deleteCharAt(str.length()-1);
        if (curr == '(')
            open--;
        else if (curr == ')')
            close--;
        
        removeCount++;
        calculate(s, index+1, open, close, str, removeCount);
        removeCount--;
            
    }
}