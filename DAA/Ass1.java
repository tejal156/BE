import java.util.*;

class Ass1 {
    public static void main(String[] args) {
        System.out.println(fibo_interative(0));
        System.out.println(fibo_interative(2));
        System.out.println(fibo_interative(8));
    }

    public static int fibo_recursive(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibo_recursive(n - 1) + fibo_recursive(n - 2);
    }

    public static int fibo_interative(int num) {
        if (num <= 1) {
            return num;
        }
        int prev2 = 0;
        int prev1 = 1;
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }

    public static int fibo_recursive_dp(int n, int arr[]) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (arr[n] != -1)
            return arr[n];
        return arr[n] = fibo_recursive_dp(n - 1, arr) + fibo_recursive_dp(n - 2, arr);
    }

}
