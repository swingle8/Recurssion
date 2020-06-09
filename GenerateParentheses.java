//https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        int totalOpen = n;
        int totalClose = n;
        int openUsed = 0;
        int closeUsed = 0;
        int places = 2*n;
        calculate (places, totalOpen, totalClose, openUsed, closeUsed, 0, "", ans);
        return ans;
    }
    
    public void calculate (int places, int totalOpen, int totalClose, int openUsed, int closeUsed, int index, String s, ArrayList<String> ans) {
        if (index == places) {
            ans.add(s);
            return;
        }
        
        if (totalOpen > 0) {
            s = s + "(";
            totalOpen--;
            openUsed++;
            calculate (places, totalOpen, totalClose, openUsed, closeUsed, index+1, s, ans);
            s = s.substring(0, s.length() - 1);
            totalOpen++;
            openUsed--;
        }
        if (totalClose > 0 && openUsed > closeUsed) {
            s = s + ")";
            totalClose--;
            closeUsed++;
            calculate (places, totalOpen, totalClose, openUsed, closeUsed, index+1, s, ans);
            s = s.substring(0, s.length() - 1);
            totalClose++;
            closeUsed--;
        }
    }
}