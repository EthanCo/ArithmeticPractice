package com.ethanco.myarithmetictest.structure;

/**
 * Created by EthanCo on 2016/7/2.
 */
public class Test {
    public static class Queue {
        int[] q;
        int head;
        int tail;
    }

    public static class Stack {
        char[] data;
        int top;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.q = new int[1024];
        int[] numbers = new int[]{6, 3, 1, 7, 5, 8, 9, 2, 4};
        for (int i = 0; i < numbers.length; i++) {
            queue.q[i] = numbers[i];
        }

        queue.head = 0;
        queue.tail = numbers.length;

        while (queue.head < queue.tail) {
            System.out.print(queue.q[queue.head] + " ");
            queue.head++;

            queue.q[queue.tail] = queue.q[queue.head];
            queue.tail++;
            queue.head++;
        }

        equalPalindromicString(new char[]{'a', 'b', 'c', 'd', 'c', 'b', 'a'});
    }

    /**
     * 匹配回文字符串  ABCDEDCBA
     */
    public static void equalPalindromicString(char[] s) {

        int len = s.length;
        int midd = len / 2;
        int next;
        if (len % 2 == 0) {
            next = midd;
        } else {
            next = midd + 1;
        }

        Stack stack = new Stack();
        stack.data = new char[1024];

        stack.top = 0;
        for (int i = 0; i < midd; i++) {
            stack.data[++stack.top] = s[i];
        }

        for (int i = next; i <= len - 1; i++) {
            if (s[i] != stack.data[stack.top]) {
                System.out.println("s[i]:" + s[i]);
                System.out.println("stack.data[stack.top]:" + stack.data[stack.top]);
                break;
            }
            stack.top--;
        }

        if (stack.top == 0) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }
    }
}
