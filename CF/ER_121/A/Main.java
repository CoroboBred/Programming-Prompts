import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {
            int[] occ = new int[256];
            String in = br.readLine();
            for (int i = 0; i < in.length(); i++) {
                occ[in.charAt(i)]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 256; i++) {
                if (occ[i] == 2)
                    sb.append((char) i);
            }
            for (int i = 0; i < 256; i++) {
                if (occ[i] == 2)
                    sb.append((char) i);
            }
            for (int i = 0; i < 256; i++) {
                if (occ[i] == 1)
                    sb.append((char) i);
            }
            System.out.println(sb.toString());

        }

    }
}