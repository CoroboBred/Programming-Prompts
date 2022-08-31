import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(input[i]);
        }

        long[] prefix = new long[n + 2];
        for (int i = 0; i < n - 1; i++) {
            prefix[i + 1] = prefix[i];
            if (a[i] > a[i + 1]) {
                prefix[i + 1] += a[i] - a[i + 1];
            }
        }
        long[] suffix = new long[n + 2];
        for (int i = n - 1; i > 0; i--) {
            suffix[i - 1] = suffix[i];
            if (a[i] > a[i - 1]) {
                suffix[i - 1] += a[i] - a[i - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int t = Integer.parseInt(input[1]) - 1;
            if (s < t)
                System.out.println(prefix[t] - prefix[s]);
            else
                System.out.println(suffix[t] - suffix[s]);
        }
    }
}

/*
 * // Usage: Find Range Sum Queries and Update ranges in Log(n) time.
 * class SegmentTree { // the segment tree is stored like a heap array
 * private long[] st, A;
 * private int n;
 * 
 * private int left(int p) {
 * return p << 1;
 * } // same as binary heap operations
 * 
 * private int right(int p) {
 * return (p << 1) + 1;
 * }
 * 
 * private void build(int p, int L, int R) {
 * if (L == R) // as L == R, either one is fine
 * st[p] = A[L]; // store the index
 * else { // recursively compute the values
 * build(left(p), L, (L + R) / 2);
 * build(right(p), (L + R) / 2 + 1, R);
 * long p1 = st[left(p)], p2 = st[right(p)];
 * st[p] = Math.max(p1, p2);
 * }
 * }
 * 
 * private long rsq(int p, int L, int R, int i, int j) { // O(log n)
 * if (i > R || j < L)
 * return -1; // current segment outside query range
 * if (L >= i && R <= j)
 * return st[p]; // inside query range
 * 
 * // update children
 * // compute the min position in the left and right part of the interval
 * long p1 = rsq(left(p), L, (L + R) / 2, i, j);
 * long p2 = rsq(right(p), (L + R) / 2 + 1, R, i, j);
 * 
 * if (p1 == -1)
 * return p2; // if we try to access segment outside query
 * if (p2 == -1)
 * return p1; // same as above
 * return Math.max(p1, p2);
 * }
 * 
 * private long update(int p, int L, int R, int idx, int idz, int new_value) {
 * int i = idx, j = idz;
 * 
 * // if the current interval does not intersect
 * // the update interval, return this st node value!
 * if (i > R || j < L)
 * return st[p];
 * 
 * // if the current interval is included in the update range,
 * // update that st[node]
 * 
 * if (i == R && j == L)
 * return st[p] = new_value;
 * 
 * // update children
 * 
 * // compute the range in the
 * // left and right part of the interval
 * long p1, p2;
 * p1 = update(left(p), L, (L + R) / 2, idx, idz, new_value);
 * p2 = update(right(p), (L + R) / 2 + 1, R, idx, idz, new_value);
 * 
 * // return the max
 * return st[p] = Math.max(p1, p2);
 * }
 * 
 * // Update Children to correct values
 * private void prop(int p, int L, int R) {
 * int r = (R - L) + 1;
 * int lr = (L + R) / 2; // left range
 * lr -= L;
 * lr++;
 * int rr = R; // right range
 * rr -= ((L + R) / 2 + 1);
 * rr++;
 * 
 * int left = left(p);
 * int right = right(p);
 * if (st[p] == 0) {
 * st[left] = 0;
 * st[right] = 0;
 * } else if (st[p] == r) {
 * st[left] = lr;
 * st[right] = rr;
 * 
 * }
 * }
 * 
 * public SegmentTree(long[] _A) {
 * A = _A;
 * n = A.length; // copy content for local usage
 * st = new long[4 * n];
 * build(1, 0, n - 1); // recursive build
 * }
 * 
 * public long rsq(int i, int j) {
 * return rsq(1, 0, n - 1, i, j);
 * } // overloading
 * 
 * public long update_range(int idx, int idz, int new_value) {
 * return update(1, 0, n - 1, idx, idz, new_value);
 * }
 * 
 * public long update_point(int idx, int new_value) {
 * return update(1, 0, n - 1, idx, idx, new_value);
 * }
 * 
 * }
 */