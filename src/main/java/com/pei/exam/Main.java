package com.pei.exam;


import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        char[] ops = {'+', '-', '*', '/'};
        StringBuilder builder = new StringBuilder();
        builder.append(N);
        for (int i = 0; i < 4; i++) {
            builder.append(ops[i]);
            builder.append(N);
            for (int j = 0; j < 4; j++) {
                builder.append(ops[j]);
                builder.append(N);
                for (int k = 0; k < 4; k++) {
                    builder.append(ops[k]);
                    builder.append(N);
                    if (M == calculate(builder.toString())) {
                        System.out.println(1);
                        return;
                    }
                }
            }

        }
        System.out.println(0);
    }

    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') continue;

            if (Character.isDigit(arr[i])) {
                int tempNum = arr[i] - '0';
                while (++i < arr.length && Character.isDigit(arr[i])) {
                    tempNum = tempNum * 10 + (arr[i] - '0');
                }
                i--;

                if (lastOp == '+') numStack.push(tempNum);
                else if (lastOp == '-') numStack.push(-tempNum);
                else numStack.push(res(lastOp, numStack.pop(), tempNum));
            } else lastOp = arr[i];
        }

        int ans = 0;
        for (int num : numStack) ans += num;
        return ans;
    }

    private static int res(char op, int a, int b) {
        if (op == '*') return a * b;
        else if (op == '/') return a / b;
        else if (op == '+') return a + b; //其实加减运算可以忽略
        else return a - b;
    }
}

/*

1 1 2 3 2 3 2 3 3 1 1 1 3 1


 */
