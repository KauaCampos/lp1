package br.cefetmg.inf.llp.lista16.p1068_Stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        String exp;
        boolean cond;

        while (sc.hasNextLine()) {
            exp = sc.nextLine();
            if (exp.isEmpty()) break;

            cond = true;

            Stack<Integer> stack = new Stack<>();

            try {
                for (char ch : exp.toCharArray()) {
                    if (ch == '(') {
                        stack.push((int) ch);
                    } else if (ch == ')') {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        } else {
                            cond = false;
                        }
                    }
                }

                if (!stack.isEmpty()) cond = false;

            } catch (Exception e) {
                cond = false;
            }

            if (cond) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }

        sc.close();
    }
}
