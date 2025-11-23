package boj;

// 백준
// 10828 스택
// 유형 : 자료구조
// https://www.acmicpc.net/problem/10828

// 스택  구현해서 풀기

import java.util.Scanner;

class Stack {
    private int[] arr;
    private int top;

    Stack(int size){
        arr = new int[size];
        top = -1;
    }

    public void push(int x) {
        top++;
        arr[top] = x;
    }

    public int pop() {
        if(isEmpty()==1) return -1;
        return arr[top--];
    }

    public int size() {
        return top+1;
    }

    public int isEmpty() {
        return top==-1 ? 1:0;
    }

    public int top() {
        if(isEmpty()==1) return -1;
        return arr[top];
    }

}

public class _10828_stack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Stack stack = new Stack(n);

        for (int i = 0; i < n; i++) {
            String[] cmd = sc.nextLine().split(" ");

            if (cmd[0].equals("push")) {
                int x = Integer.parseInt(cmd[1]);
                stack.push(x);
            } else if (cmd[0].equals("top")) {
                System.out.println(stack.top());
            } else if (cmd[0].equals("pop")) {
                System.out.println(stack.pop());
            } else if (cmd[0].equals("size")) {
                System.out.println(stack.size());
            } else if (cmd[0].equals("empty")) {
                System.out.println(stack.isEmpty());
            }
        }

    }
}
