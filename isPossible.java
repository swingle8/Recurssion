import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'isPossible' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     *  3. INTEGER c
     *  4. INTEGER d
     */

    public static String isPossible(int a, int b, int c, int d) {
        if (a > c || b > d)
            return "No";
        
        if (isFeasible(a, b, c, d))
            return "Yes";
        else
            return "No";

    }
    
    public static boolean isFeasible (int a, int b, int c, int d) {
        if (a == c && b == d) {
            return true;
        }
        else if (a > c || b > d)
            return false;
        
        a = a + b;
        boolean first = isFeasible(a, b, c, d);
        a = a - b;
        
        b = b + a;
        boolean second = isFeasible(a, b, c, d);
        b = b - a;
        
        if (first || second)
            return true;
        return false;
    }

}
public class Solution {