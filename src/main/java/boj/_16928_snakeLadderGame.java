package boj;

// 백준
// 16928 뱀과 사다리 게임
// https://www.acmicpc.net/problem/16928
// 유형 : BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _16928_snakeLadderGame {

    static void bfs(int[] cnt, Queue<Integer> q, int[] snake, int[] ladder) {
        if(q.isEmpty()) return;
        int cur = q.poll();
        int now_cnt = cnt[cur];

        for (int i = 1; i <= 6; i++) {
            int next = cur+i;

            if(next>100) continue;

            if(snake[next]!=0) next = snake[next];
            if(ladder[next]!=0) next = ladder[next];

            if (cnt[next] == 0 || cnt[next] > now_cnt + 1) {
                cnt[next] = now_cnt+1;
                q.add(next);
            }
        }
        bfs(cnt, q, snake, ladder);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();

        int[] snake = new int[101];
        int[] ladder = new int[101];

        for (int i = 0; i < n; i++) {
            snake[sc.nextInt()] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            ladder[sc.nextInt()] = sc.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int[] cnt = new int[101];

        bfs(cnt, q, snake, ladder);

        System.out.println(cnt[100]);


    }
}
