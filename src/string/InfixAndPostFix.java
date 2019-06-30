package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class InfixAndPostFix {


    public static void main(String[] args) {
        // (1 + 2) / 3 --> 12+3/
        String postfix = parseInfixToPostfix("1 - (-7)");
        System.out.println(evaluate(postfix));
    }

    public static final char[][] PRIORITY = new char[][] {{'(', '[', '{'}, {'+', '-'}, {'*', '/', '%'}, {')', ']', '}'}};
    public static final char SPACE = ' ';

    public static int evaluate(String postfix) {
        Deque<Long> stack = new ArrayDeque<>();
        for(int i = 0; i < postfix.length(); i++) {
            char cur = postfix.charAt(i);
            if(cur == '#') {
                i++;
                int j = i;
                while(i < postfix.length() && Character.isDigit(postfix.charAt(i))) i++;
                stack.push(Long.valueOf(postfix.substring(j, i)));
                i--;
            } else {
                long num1 = stack.pop();
                long num2 = stack.pop();
                long res;
                if(cur == '+') {
                    res = num1 + num2;
                } else if(cur == '-') {
                    res = num2 - num1;
                } else if (cur == '*') {
                    res = num1 * num2;
                } else {
                    res = num2 / num1;
                }
                stack.push(res);
            }
        }
        long longres = stack.pop();
        return (int) longres;
    }

    public static String parseInfixToPostfix(String infix) {
        if(!valid(infix)) return "";
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        buildPriority(map);
        for(int i = 0; i < infix.length(); i++) {
            char cur = infix.charAt(i);
            if(Character.isDigit(cur)) {
                int j = i;
                while(i < infix.length() && Character.isDigit(infix.charAt(i))) i++;
                sb.append('#');
                sb.append(infix.substring(j, i));
                i--;
            } else if (cur == SPACE) {
                continue;
            } else if(map.get(cur) == 0) {
                stack.push(cur);
            } else if (map.get(cur) == 3) {
                while(stack.peek() != '(') {
                    char operator = stack.pop();
                    sb.append(operator);
                }
                stack.pop();
            } else {
                int j = i - 1;
                while(j >= 0 && infix.charAt(j) == SPACE) j--;
                char pre = j >= 0 ? infix.charAt(j) : '(';
                if(pre == '(') {
                    sb.append("#0");
                }
                // Operator
                while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(cur)) {
                    char operator = stack.pop();
                    sb.append(operator);
                }
                stack.push(cur);
            }
        }

        while(!stack.isEmpty()) {
            char operator = stack.pop();
            sb.append(operator);
        }

        return sb.toString();
    }

    private static void buildPriority(Map<Character, Integer> map) {
        for(int level = 0; level < PRIORITY.length; level++) {
            for(char operator : PRIORITY[level]) {
                map.put(operator, level);
            }
        }
    }

    private static boolean valid(String expression) {
        return true;
    }
}
