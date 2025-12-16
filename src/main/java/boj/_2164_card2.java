package boj;

// 백준
// 2164 카드2
// 유형 : 자료구조
// https://www.acmicpc.net/problem/2164

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _2164_card2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            dq.addFirst(i + 1);
        }

        while (dq.size() > 1) {
            dq.pollLast();
            if (dq.size() > 1) {
                int num = dq.pollLast();
                dq.addFirst(num);
            }
        }

        System.out.println(dq.poll());
    }
}
