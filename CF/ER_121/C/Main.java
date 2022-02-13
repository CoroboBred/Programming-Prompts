import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {
            int n = Integer.parseInt(br.readLine());

            long[] k = new long[n];
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                k[i] = Integer.parseInt(input[i]);
            }
            long[] h = new long[n];
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                h[i] = Integer.parseInt(input[i]);
            }

            // dp[i][j] , i = ith monster, j = cast streak by # of monsters, 100 * 100 *
            // 10000 = 10^8

            long[][] dp = new long[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[i][j] = Long.MAX_VALUE;
                }
            }
            dp[0][0] = 0;
            dp[1][1] = sum(h[0]);
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= i; j++) {
                    //System.out.print("" + dp[i][j] + " ");
                    if (dp[i][j] == Long.MAX_VALUE)
                        continue;
                    //System.out.println("D: " + i + " " + j + " " + k[i] + " " + k[i - 1] + " " + h[i]);
                    if (k[i] - k[i - 1] >= h[i]) {
                        //System.out.println("sum");
                        dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][j] + sum(h[i]));
                    }

                    if (k[i] - k[i - j] + h[i - j] >= h[i])
                        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1],
                                dp[i][j] + sum(k[i] - k[i - j] + h[i - j]) - sum(k[i - 1] - k[i - j] + h[i - j]));

                }
                //System.out.println();
            }
            long ans = Long.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                ans = Math.min(ans, dp[n][i]);
                //System.out.print("" + dp[n][i] + " ");
            }
            //System.out.println();
            System.out.println(ans);
        }
    }

    // 1 = 1
    // 2 = 3
    // 3 = 6
    // 4 = 10
    // 5 = 15
    private static long sum(long i) {
        return (i * (i + 1)) / 2;
    }
}