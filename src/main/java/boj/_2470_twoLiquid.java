package boj;

// 백준
// 2470 두 용액
// 유형 : 투포인터
// https://www.acmicpc.net/problem/2470


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2470_twoLiquid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] liquidStr = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(liquidStr[i]);
        }

        Arrays.sort(nums);

        int min_sum = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        int left = 0;
        int right = n-1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            int abs = Math.abs(sum);

            //더한 값이 작으면 정답처리
            if (abs < min_sum) {
                min_sum = abs;
                answer[0] = nums[left];
                answer[1] = nums[right];
            }

            //1.합계가 0일때 -> 아예 종료
            if (sum == 0) break;

            //2. 합계가 음수면 왼쪽이동
            if(sum < 0) left++;
            else if(sum > 0) right--;
        }


        System.out.print(answer[0]);
        System.out.print(" ");
        System.out.print(answer[1]);

    }
}
