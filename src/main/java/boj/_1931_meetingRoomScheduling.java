package boj;
// 백준
// 1931 회의실 배정
// https://www.acmicpc.net/problem/1931
// 유형 : 그리디, 정렬
import java.util.Arrays;
import java.util.Scanner;

public class _1931_meetingRoomScheduling {

    static class Meeting{
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            meetings[i] = new Meeting(s, e);
        }

        Arrays.sort(meetings, (a,b) -> {
            if(a.end != b.end) return a.end - b.end;
            return a.start - b.start;
        } );

        int cnt = 0;
        int endTime=0;

        for (Meeting m : meetings) {
            if (m.start >= endTime) {
                cnt++;
                endTime = m.end;
            }
        }

        System.out.println(cnt);

    }
}
