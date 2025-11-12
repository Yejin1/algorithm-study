package boj;

// 백준
// 1495 기타리스트
// https://www.acmicpc.net/problem/1495
// 유형 : DP

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _1495_guitarist {
    public static void main(String[] args) {
        //첫째 줄에 N, S, M이 주어진다. (1 ≤ N ≤ 50, 1 ≤ M ≤ 1,000, 0 ≤ S ≤ M)
        //둘째 줄에는 각 곡이 시작하기 전에 줄 수 있는 볼륨의 차이가 주어진다. 이 값은 1보다 크거나 같고, M보다 작거나 같다.
        Scanner sc = new Scanner(System.in);
        int n,s,m;
        n = sc.nextInt();
        s = sc.nextInt();
        m = sc.nextInt();

        int[] v = new int[n];
        Set<Integer>[] volumes = new HashSet[n];
        
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        volumes[0] = new HashSet<>();
        if(s+v[0]>=0 && s+v[0]<=m) volumes[0].add(s+v[0]);
        if(s-v[0]>=0 && s-v[0]<=m) volumes[0].add(s-v[0]);

        for (int i = 1; i < n; i++) {
            if(volumes[i-1].isEmpty()) {
                System.out.println(-1);
                return;
            }
            volumes[i] = new HashSet<>();
            for (Integer volume : volumes[i-1]) {
                if(volume+v[i]>=0 && volume+v[i]<=m) volumes[i].add(volume + v[i]);
                if(volume-v[i]>=0 && volume-v[i]<=m) volumes[i].add(volume - v[i]);
            }
        }

        if(volumes[n-1].isEmpty()) {
            System.out.println(-1);
            return;
        }

        int answer = 0;

        for (Integer volume : volumes[n - 1]) {
            if(volume>answer) answer = volume;
        }

        System.out.println(answer);

    }
}
