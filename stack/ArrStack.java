package stack;

import java.util.Scanner;

public class ArrStack {
    private int maxsize;
    private int[] stack;
    private int top = -1;
    private ArrStack(int maxsize){
        this.maxsize = maxsize;
        stack = new int[maxsize];
    }
    private boolean isFull(){
        return top == maxsize-1;
    }

    private boolean isEmpty(){
        return top == -1;
    }

    private void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        stack[++top] = value;
    }

    private int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    private void show(){
        if (isFull()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrStack arrStack = new ArrStack(4);
        String key;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("s:显示栈");
            System.out.println("e:退出栈");
            System.out.println("push:数据入栈");
            System.out.println("pop:数据出栈");
            System.out.println("请输入选择");
            key = scanner.next();
            switch (key){
                case "s":
                    arrStack.show();
                    break;
                case "push":
                    System.out.println("请输入值：");
                    int value = scanner.nextInt();
                    arrStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrStack.pop();
                        System.out.println(res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }
}
