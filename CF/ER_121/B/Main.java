import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);

        for (int tc = 0; tc < tests; tc++) {
            String s = br.readLine();
            boolean found = false;
            int index = 0;

            // look for first occurence of 10+
            for (int i = s.length() - 1; i > 0; i--) {
                if (s.charAt(i) + s.charAt(i - 1) - '0' - '0' >= 10) {
                    found = true;
                    index = i;
                    break;
                }
            }
            if (found) {
                s = s.substring(0, index - 1) + ((int) s.charAt(index) + s.charAt(index - 1) - '0' - '0')
                        + s.substring(index + 1, s.length());
                System.out.println(s);
                continue;
            }

            // 10012 => 1003, 1012, 1012,1012
            // 10123 => 1123, 1123, 1033, 1015
            // 100120 => 10012, 10030, 10120, 10120,10120
            // 10081 => 1009, 1081
            // 12345 => 3345, 1545, 1275, 1239
            // 5566 => 1066, 5116, 5512
            // 1200 => 300, 120, 120

            // combine leading zero
            s = s.substring(0, 0) + ((int) s.charAt(0) + s.charAt(1) - '0' - '0')
                    + s.substring(2, s.length());
            System.out.println(s);
        }
    }
}