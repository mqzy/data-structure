package stack;

import java.util.Scanner;
import java.util.Stack;

public class Calulator {
    private Stack<Integer> numStack = new Stack<>();
    private Stack<Character> operaStack = new Stack<>();

    public Calulator() {
    }

    public boolean isNum(char n){
        return n >= '0' && n <= '9';
    }

    public int toNum(int num,char n){
        int nm = n - '0';
        return num*10+nm;
    }

    public void calculate(){
        int num1 = this.numStack.pop();
        int num2 = this.numStack.pop();
        char n = this.operaStack.pop();
        System.out.println("numStack出栈："+num1+","+num2);
        System.out.println("operaStack出栈："+n);
        switch (n){
            case '+':num2 +=num1;
                break;
            case '-':num2 -=num1;
                break;
            case '*':num2 *=num1;
                break;
            case '/':num2 /=num1;
                break;
        }
        this.numStack.push(num2);
        System.out.println("numStack入栈："+num2);
    }

    public static void main(String[] args) {
        Calulator calulator = new Calulator();
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        int index = 0;
        int num = 0;
        int len = expression.length();
        char n = expression.charAt(index);
        while (index != len){
            if (calulator.isNum(n)){
                num = calulator.toNum(num,n);
            }else {
                calulator.numStack.push(num);
                System.out.println("numStack入栈："+num);
                num = 0;
                boolean flag = true;
                while (flag) {
                    if (calulator.operaStack.empty()) {
                        flag = false;
                    } else {
                        char pre = calulator.operaStack.peek();
                        if ((n == '*' || n == '/') && (pre == '+' || pre == '-')) {
                            flag = false;
                        } else {
                            calulator.calculate();
                        }
                    }
                    }
                calulator.operaStack.push(n);
                System.out.println("operaStack入栈：" + n);
                    }
            index++;
            if (index < len)
                n = expression.charAt(index);
            else {
                calulator.numStack.push(num);
                System.out.println("numStack入栈："+num);
            }
        }
        int size = calulator.operaStack.size();
        for (int i = 0; i < size; i++) {
            calulator.calculate();
        }
        System.out.println(expression+"="+calulator.numStack.pop());
    }
}
