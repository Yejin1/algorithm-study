package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _10866_deque {

    static class Deque {
        private int[] dq;
        private int size;
        private int head;
        private int capacity;

        public Deque(int capacity) {
            this.capacity = capacity;
            this.dq = new int[capacity];
            this.head = 0; //헤드 인덱스
            this.size = 0;
        }

        public void pushFront(int x) {
            head = (head - 1 + capacity) % capacity; //용량을 넘지 않도록 -1하며 순환
            dq[head] = x;
            size++;
        }

        public void pushBack(int x) {
            int idx = (head + size) % capacity;
            dq[idx] = x;
            size++;
        }

        public int popFront() {
            if(size==0) return -1;
            int front = dq[head];
            head = (head + 1) % capacity;
            size--;

            return front;

        }

        public int popBack() {
            if(size==0) return -1;
            int back = dq[(head+size-1+capacity)%capacity];
            size--;

            return back;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int front() {
            if(empty()==1) return -1;
            return dq[head];
        }

        public int back() {
            if(empty()==1) return -1;
            return dq[(head+size-1+capacity)%capacity];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque dq = new Deque(n);

        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");

            if (cmd[0].equals("push_front")) {
                int x = Integer.parseInt(cmd[1]);
                dq.pushFront(x);
            } else if (cmd[0].equals("push_back")) {
                int x = Integer.parseInt(cmd[1]);
                dq.pushBack(x);
            }else if (cmd[0].equals("pop_front")) {
                System.out.println(dq.popFront());
            } else if (cmd[0].equals("pop_back")) {
                System.out.println(dq.popBack());
            } else if (cmd[0].equals("size")) {
                System.out.println(dq.size());
            } else if (cmd[0].equals("empty")) {
                System.out.println(dq.empty());
            } else if (cmd[0].equals("front")) {
            System.out.println(dq.front());
            } else if (cmd[0].equals("back")) {
                System.out.println(dq.back());
            }
        }
    }
}
