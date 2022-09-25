import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            int x = Integer.parseInt(in[2]);
            int y = Integer.parseInt(in[3]);
            int d = Integer.parseInt(in[4]);

            if((x-d >1 && y+d < m) || (x+d < n && y-d >1) ) System.out.println(n+m-2);
            else System.out.println(-1);

        }
    }
}
