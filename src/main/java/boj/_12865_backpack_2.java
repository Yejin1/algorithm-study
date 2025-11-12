package boj;

// 백준 12865 평범한 배낭
// https://www.acmicpc.net/problem/12865
// 1차원 배열로 풀기

import java.util.Scanner;

public class _12865_backpack_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] w = new int[N+1]; //무게
        int[] v = new int[N+1]; //가치

        for (int i = 1; i <= N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[] d = new int[K+1]; // d[i] 는  i 무게일 때의 최대 가치

        for (int i = 1; i <= N; i++) {
            int W = w[i];
            int V = v[i];
            for (int j = K; j >= 1; j--) {
                if (j - W >= 0) {
                    d[j] = Math.max(d[j], d[j-W]+V);
                }
            }
        }

        System.out.println(d[K]);


    }
}
