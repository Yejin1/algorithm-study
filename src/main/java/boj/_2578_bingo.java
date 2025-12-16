package boj;
// 백준
// 2578 빙고
// 유형 : 구현
// https://www.acmicpc.net/problem/2578
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _2578_bingo {
    static class Pair {
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean chk(HashSet[] garos, HashSet[] seros, HashSet[] cross) {

        int cnt = 0;

        for (int i = 0; i < garos.length; i++) {
            if(garos[i].size()==5) cnt++;
        }

        for (int i = 0; i < seros.length; i++) {
            if(seros[i].size()==5) cnt++;
        }

        for (int i = 0; i < cross.length; i++) {
            if(cross[i].size()==5) cnt++;
        }

        if(cnt>=3) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Pair> numLocate = new HashMap<>();
        HashSet<Integer>[] garos = new HashSet[5];
        HashSet<Integer>[] seros = new HashSet[5];
        HashSet<Integer>[] cross = new HashSet[2];
        int[] called = new int[25];
        int answer = 0;

        for (int i = 0; i < 5; i++) {
            garos[i] = new HashSet<>();
            seros[i] = new HashSet<>();

            if(i<2) cross[i] = new HashSet<>();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int num = sc.nextInt();
                numLocate.put(num, new Pair(i, j));
            }
        }

        for (int i = 0; i < 25; i++) {
                called[i] = sc.nextInt();
        }

        for (int i = 0; i < 25; i++) {
            int num = called[i];
            Pair pair = numLocate.getOrDefault(num, new Pair(0, 0));
            int x = pair.x;
            int y = pair.y;

            garos[x].add(num);
            seros[y].add(num);
            if (x == y) {
                cross[0].add(num);
            }
            if (4 - x == y) {
                cross[1].add(num);
            }

            if (chk(garos, seros, cross)) {
                answer = i+1;
                break;
            }
        }

        System.out.println(answer);



    }
}
