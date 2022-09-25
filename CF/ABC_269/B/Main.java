import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = -1;
        int b = 0; 
        int c = -1;
        int d = 0;

        for( int i = 0; i < 10; i++){
            String s = br.readLine();
            for( int j=0; j < s.length(); j++){
                if(s.charAt(j) == '#'){
                    if(a == -1)
                        a = i;
                    if(c == -1)
                        c = j;
                    
                    b = i;
                    d = j;
                }

            }

        }

        a++;
        b++;
        c++;
        d++;
        System.out.printf("%d %d\n%d %d\n", a, b, c, d);
    }
}
