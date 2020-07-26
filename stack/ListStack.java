package stack;

import java.util.Scanner;

public class ListStack {
    private Node head = new Node(0);

    private void push(int value){
        Node node = new Node(value);
        Node temp = head;
        while (temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(node);
    }

    private int pop(){
        Node temp = head;
        if (temp.getNext() == null){
            throw new RuntimeException("栈空");
        }
        for (int i = 0; i < this.length()-1; i++) {
            temp = temp.getNext();
        }
        int value = temp.getNext().getNo();
        temp.setNext(null);
        return value;
    }

    private int length(){
        int len = 0;
        Node temp = head;
        while (temp.getNext() != null){
            len++;
            temp = temp.getNext();
        }
        return len;
    }

    private void show(){
        Node temp = head;
        if (temp.getNext() == null){
            System.out.println("栈空");
            return;
        }
        for (int i = 0; i < this.length(); i++) {
            temp = temp.getNext();
            System.out.println(temp.getNo());
        }
    }

    public static void main(String[] args) {
        ListStack listStack = new ListStack();
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
                    listStack.show();
                    break;
                case "push":
                    System.out.println("请输入值：");
                    int value = scanner.nextInt();
                    listStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = listStack.pop();
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

class Node{
    private int no;
    private Node next;

    Node(int no) {
        this.no = no;
    }

    int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
