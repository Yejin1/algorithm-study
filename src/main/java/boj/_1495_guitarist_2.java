package boj;

// 백준
// 1495 기타리스트
// https://www.acmicpc.net/problem/1495
// 유형 : DP

// Set 안쓰고 배열로 풀기

import java.util.Scanner;

public class _1495_guitarist_2 {
    public static void main(String[] args) {
        //첫째 줄에 N, S, M이 주어진다. (1 ≤ N ≤ 50, 1 ≤ M ≤ 1,000, 0 ≤ S ≤ M)
        //둘째 줄에는 각 곡이 시작하기 전에 줄 수 있는 볼륨의 차이가 주어진다. 이 값은 1보다 크거나 같고, M보다 작거나 같다.
        Scanner sc = new Scanner(System.in);
        int n,s,m;
        n = sc.nextInt();
        s = sc.nextInt();
        m = sc.nextInt();

        int[] v = new int[n+1];
        boolean[][] d = new boolean[n+1][m+1]; // d[i][j]는 i-1번째에 j의 볼륨으로 연주할 수 있는지 여부
        
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
        }

        //0번 값(시작볼륨) 초기화
        d[0][s] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(d[i-1][j]) { //j는 이전 단계 연주 가능 볼륨
                    if (j+v[i]<=m) {
                        d[i][j+v[i]] = true;
                    }
                    if(j-v[i]>=0) {
                        d[i][j-v[i]] = true;
                    }
                }
            }
        }

        int answer = -1;

        for (int i = 0; i <= m; i++) {
            if(d[n][i]) answer = i;
        }

        System.out.println(answer);

    }
}
