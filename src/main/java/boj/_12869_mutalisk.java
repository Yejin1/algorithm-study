package boj;

import java.util.Scanner;

public class _12869_mutalisk {
    public static void main(String[] args) {
        //첫째 줄에 SCV의 수 N (1 ≤ N ≤ 3)이 주어진다. 둘째 줄에는 SCV N개의 체력이 주어진다. 체력은 60보다 작거나 같은 자연수이다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scv = new int[n];

        for (int i = 0; i < n; i++) {
            scv[i] = sc.nextInt();
        }

        int[][] d = new int[60][n];
        int count = 0;

    }
}
