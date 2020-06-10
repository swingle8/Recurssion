https://www.interviewbit.com/problems/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/#_=_
public class Solution {
    int ans = Integer.MAX_VALUE;
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C) {
        
        HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < C.size() ; i++) {
            pairs.put(C.get(i).get(0), C.get(i).get(1));
            pairs.put(C.get(i).get(1), C.get(i).get(0));
        }
        
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < B.size() ; i++)
            indexMap.put(B.get(i), i);
         
         calculate (B, pairs, indexMap, 0, 0);
         return ans;
        
    }
    
     public void calculate (ArrayList<Integer> A, HashMap<Integer, Integer> pairs, HashMap<Integer, Integer> indexMap, int index, int count) {
        if (count > ans)
            return;
        
        if (index == A.size()) {
            ans = count;
            return;
        }
     
            int number = A.get(index);
            int pair = pairs.get(number);
            int pair_index = A.indexOf(pair);
            
            if (pair_index-1 == index) {
                calculate(A, pairs, indexMap, index+2, count);
            }
            else {
                A = swap (A, pair_index, index+1);
                indexMap.put(index+1, A.get(index+1));
                indexMap.put(pair_index, A.get(pair_index));
                count++;
           
                calculate(A, pairs, indexMap, index+2, count);
                A = swap (A, pair_index, index+1);
                indexMap.put(index+1, A.get(index+1));
                indexMap.put(pair_index, A.get(pair_index));
                count--;
            
            
                if ((A.size() - 1 - pair_index)%2 != 0 && pair_index%2 == 0)
                    pair_index = pair_index+1;
                else if ((A.size() - 1 - pair_index)%2 == 0 && pair_index%2 != 0)
                    pair_index = pair_index-1;
                A = swap (A, pair_index, index);
                indexMap.put(index, A.get(index));
                indexMap.put(pair_index, A.get(pair_index));
                count++;
           
                calculate(A, pairs, indexMap, index, count);
                A = swap (A, pair_index, index);
                indexMap.put(index, A.get(index));
                indexMap.put(pair_index, A.get(pair_index));
                count--;
            
            }
        
    }
    
    public ArrayList<Integer> swap (ArrayList<Integer> A, int pair, int i) {
        int temp = A.get(pair);
        A.set(pair, A.get(i));
        A.set(i, temp);
        
        return A;
    }
}