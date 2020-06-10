//https://leetcode.com/problems/palindrome-partitioning/
class Solution {
    List<List<String>> ans = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        ans.clear();
        ArrayList<String> al = new ArrayList<String>();
        calculate (s, -1, 0, al);
        return ans;
        
    }
    
   public void calculate (String s, int partition, int index, ArrayList<String> al) {
        if (partition == s.length()-1 && index == s.length()) {
            ans.add(new ArrayList(al));
            return;
        }
     
        
        for (int i = index ;i < s.length() ; i++) {
            int previousPart = partition;
            if (checkPallindrom(s, partition+1, i)) {
                String piece = "";
                if (i == s.length()-1)
                    piece = s.substring(partition+1);
                else
                    piece = s.substring(partition+1, i+1);
                
                al.add(piece);
                partition = i;
                calculate(s, partition, i+1, al);
                partition = previousPart;
                al.remove(al.size()-1);
            }
        }
                
    }
    
    public boolean checkPallindrom (String s, int start, int end) {
        boolean anscheck = true;
        while (start < end) {
            if (! (s.charAt(start) == s.charAt(end))) {
                anscheck = false;
                break;
            }
            start++;
            end--;
        }
        return anscheck;
    }
}