import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            for( int i = n-3; i != 1; i--){
                sb.append(i);
                sb.append(" ");
            }
            sb.append((n-2) + " " + 1 + " " + (n-1) + " " + n + "\n");
        }
        System.out.print(sb);
    }
}