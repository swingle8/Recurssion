// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int row = image.length;
        int col = image[0].length;
        int pixel = image[sr][sc];
        if (newColor == pixel)
            return image;
        changeColor (image, sr, sc, newColor, row, col, pixel); 
        return image;
    }
    
    public void  changeColor (int[][] image, int sr, int sc, int newColor, int row, int col, int pixel) {
        
        image[sr][sc] = newColor;
        
        if (sr < row-1 && image[sr+1][sc] == pixel) {
            sr = sr + 1;
            changeColor (image, sr, sc, newColor, row, col, pixel);
            sr = sr - 1;
        }
        
        if (sr > 0 && image[sr-1][sc] == pixel) {
            sr = sr - 1;
            changeColor (image, sr, sc, newColor, row, col, pixel);
            sr = sr + 1;
        }
        
        if (sc < col-1 && image[sr][sc+1] == pixel) {
            sc = sc + 1;
            changeColor (image, sr, sc, newColor, row, col, pixel);
            sc = sc - 1;
        }
        
        if (sc > 0 && image[sr][sc-1] == pixel) {
            sc = sc - 1;
            changeColor (image, sr, sc, newColor, row, col, pixel);
            sc = sc + 1;
        }
        
    }
}