package boj;

// 백준
// 16234 인구이동
// 유형 : bfs
// https://www.acmicpc.net/problem/16234

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class _16234_populationMovement {

    static class Pair {
        int x,y;

        public void Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean move(int[][] A, int l, int r) {
        int n = A.length;
        int id = 1;
        Map<Integer, Set<Pair>> cluster = new HashMap<>();
        int[][] clusterNo = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int dif = Math.abs(A[i][j] - A[i][j + 1]);
                int curId = id;
                if (dif >= l && dif <= r) {
                   // if(clusterNo[i][j])
                }
            }
        }

        if(id == n) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nlr = bf.readLine().split(" ");

        int n = Integer.parseInt(nlr[0]);
        int l = Integer.parseInt(nlr[1]);
        int r = Integer.parseInt(nlr[2]);

        int[][] A = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] tmp = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int cnt = 0;
        while (true) {

        }
    }

}
