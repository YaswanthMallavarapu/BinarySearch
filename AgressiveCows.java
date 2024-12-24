import java.util.Arrays;
import java.util.Scanner;

class AgressiveCows {
    public static boolean canPlace(int stalls[], int dist, int cows) {
        int placed = 1;
        int last_placed = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last_placed >= dist) {
                last_placed = stalls[i];
                placed++;
                if (placed == cows) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stalls[] = new int[n];
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }
        int cows = sc.nextInt();
        Arrays.sort(stalls);
        int left = 1, right = stalls[n - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlace(stalls, mid, cows)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
        sc.close();
    }
}