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
            int n = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            int even = 0;
            int odd = 0;
            for (int i = 0; i < n; i++)  Integer.parseInt(input[i]) % 2 == 0 ? even++: odd++;

            Boolean[][][] dp = new Boolean[even+1][odd+1][2];

            dp[0][0][0] = true;
            

            for (int c = 0; c < even+odd; c++){
                for( int i = 0; i <= c && c <= even; i++){
                    int j = c-i;
                    for (int k = 0; k < 2; k++){
                        if(dp[i][j][k] == null) continue;
                        if(i != even) dp[i+1][j][(k+1)%2] = dp[i+1][j][(k+1)%2] | dp[i][j][k];
                        if(j != odd) dp[i][j+1][(k+1) %2] = dp[i][j+1][(k+1)%2] | dp[i][j][k];
                    }

                }

            }


        }
    }
}
