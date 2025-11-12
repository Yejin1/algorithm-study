package boj;

// 백준
// 12865 평범한 배낭
// 유형 : DP
// https://www.acmicpc.net/problem/12865

import java.util.Scanner;

public class _12865_backpack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] w = new int[N]; //무게
        int[] v = new int[N]; //가치

        for (int i = 0; i < N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[][] d = new int[N][K+1]; // d[i][j] 는  i번째 항목에서 j 무게일 때의 최대 가치
        if(w[0] <= K) d[0][w[0]] = v[0];

        for (int i = 1; i < N; i++) {
            int W = w[i];
            int V = v[i];
            for (int j = 1; j <= K; j++) {
                d[i][j] = d[i-1][j];
                if (j - W >= 0) {
                    d[i][j] = Math.max(d[i-1][j], d[i-1][j-W]+V);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= K; i++) {
            if(answer < d[N-1][i]) answer = d[N-1][i];
        }

        System.out.println(answer);


    }
}
