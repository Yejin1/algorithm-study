package boj;

// 백준
// 12869 뮤탈리스크
// 유형 : bfs
// https://www.acmicpc.net/problem/12869

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Math.max;

public class _12869_mutalisk {

    public static class state {
        int x, y, z;

        public state(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[][] damage =
            {
                    {1,3,9},
                    {1,9,3},
                    {3,1,9},
                    {3,9,1},
                    {9,1,3},
                    {9,3,1}
            };

    public static void main(String[] args) {
        //첫째 줄에 SCV의 수 N (1 ≤ N ≤ 3)이 주어진다. 둘째 줄에는 SCV N개의 체력이 주어진다. 체력은 60보다 작거나 같은 자연수이다.;
        //첫째 줄에 모든 SCV를 파괴하기 위한 공격 횟수의 최솟값을 출력한다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scv = new int[3];

        for (int i = 0; i < n; i++) {
            scv[i] = sc.nextInt();
        }

        int[][][] d = new int[61][61][61];
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                for (int k = 0; k < 61; k++) {
                    d[i][j][k] = -1;
                }
            }
        }
        Queue<state> q = new LinkedList<>();
        q.add(new state(scv[0], scv[1], scv[2]));
        d[scv[0]][scv[1]][scv[2]] = 0;

        while (!q.isEmpty()) {
            state cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int x = max(cur.x - damage[i][0],0);
                int y = max(cur.y - damage[i][1],0);
                int z = max(cur.z - damage[i][2],0);

                if (d[x][y][z] == -1 || d[x][y][z] > d[cur.x][cur.y][cur.z]+1) {
                    d[x][y][z] = d[cur.x][cur.y][cur.z] + 1;
                    q.add(new state(x,y,z));
                }
            }
        }

        System.out.println(d[0][0][0]);


    }
}
