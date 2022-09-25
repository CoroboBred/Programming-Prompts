import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {

        }
    }
}


public static String recurse(currentStr String[], usedStr boolean[], strs String[]){
    if(satisfiesCondition(currentStr)) return currentStr;
    for(int i = 0; i < usedStr.length; i++){
        if(usedStr[i])continue;
        String nextStr = currentStr + strs[i];
        usedStr[i] = true;
        String ans = recurse(nextStr, usedStr, strs);
        usedStr[i] = false;
        if(ans != null) return ans;
    }
    return null;
}