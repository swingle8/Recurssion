class Solution {
    List<String> ans = new ArrayList<String>();
        
    public List<String> letterCombinations(String digits) {
        ArrayList<Character> c = new ArrayList<Character>();
        HashMap<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>();
        c.add('0');
        map.put(0, c);
        
        ArrayList<Character> c1 = new ArrayList<Character>();
        c1.add('1');
        map.put(1, c1);
 
        ArrayList<Character> c2 = new ArrayList<Character>();
        c2.addAll(Arrays.asList('a', 'b', 'c'));
        map.put(2, c2);
        
        ArrayList<Character> c3 = new ArrayList<Character>();
        c3.addAll(Arrays.asList('d', 'e', 'f'));
        map.put(3, c3);
        
        ArrayList<Character> c4 = new ArrayList<Character>();
        c4.addAll(Arrays.asList('g', 'h', 'i'));
        map.put(4, c4);
        
        ArrayList<Character> c5 = new ArrayList<Character>();
        c5.addAll(Arrays.asList('j', 'k', 'l'));
        map.put(5, c5);
        
        ArrayList<Character> c6 = new ArrayList<Character>();
        c6.addAll(Arrays.asList('m', 'n', 'o'));
        map.put(6, c6);
        
        ArrayList<Character> c7 = new ArrayList<Character>();
        c7.addAll(Arrays.asList('p', 'q', 'r', 's'));
        map.put(7, c7);
        
        ArrayList<Character> c8 = new ArrayList<Character>();
        c8.addAll(Arrays.asList('t', 'u', 'v'));
        map.put(8, c8);
        
        ArrayList<Character> c9 = new ArrayList<Character>();
        c9.addAll(Arrays.asList('w', 'x', 'y', 'z'));
        map.put(9, c9);
        
        char [] chardigits = digits.toCharArray();
        calculate (map, chardigits, 0, "");
        return ans;
    }
    
    public void calculate (HashMap<Integer, ArrayList<Character>> map, char [] digits, int index, String s) {
            if (digits.length == 0)
                return;
            if (index == digits.length) {
                ans.add(s);
                return;
            }
                
                int key = Character.getNumericValue(digits[index]);
                
                ArrayList<Character> al = map.get(key);
                
                for (int j = 0 ; j < al.size(); j++) {
                    char current = al.get(j);
                    
                    s = s + current;
                    calculate (map, digits, index+1, s);
                    s = s.substring(0, s.length() - 1);
                    
                }
        
    }
}