package boj;

// 백준
// 2178 미로탈출
// 유형 : bfs
// https://www.acmicpc.net/problem/2178

// 복습

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _2178_maze {

    static class Pair {
        private int x;
        private int y;

        public Pair( int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();

        int n = Integer.parseInt(tmp.split(" ")[0]);
        int m = Integer.parseInt(tmp.split(" ")[1]);

        int[][] maze = new int[n][m];
        int[][] cnt = new int[n][m];
        cnt[0][0] = 1;

        for (int i = 0; i < n; i++) {
            tmp = bf.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));


        while (!q.isEmpty()) {
            Pair cur = q.pollFirst();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (maze[xx][yy] == 1) {
                        if (cnt[xx][yy] == 0 || cnt[xx][yy] > cnt[x][y] + 1) {
                            q.addLast(new Pair(xx, yy));
                            cnt[xx][yy] = cnt[x][y] + 1;
                        }
                    }
                }
            }
        }

        System.out.println(cnt[n-1][m-1]);

    }
}
