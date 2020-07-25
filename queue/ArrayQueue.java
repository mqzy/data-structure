package queue;

import java.util.Scanner;

public class ArrayQueue {
    private int maxSize;
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;

    private ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列尾
    }
    private boolean isFull(){
        return rear == maxSize-1;
    }

    private boolean isEmpty(){
        return front == rear;
    }

    private void  addQueue(int data){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = data;
    }

    private int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        front++;
        return arr[front];
    }

    private void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            System.out.println("arr["+i+"]: "+arr[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueue AQ = new ArrayQueue(3);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s:显示队列");
            System.out.println("e:退出队列");
            System.out.println("a:添加数据");
            System.out.println("g:取出数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    AQ.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    AQ.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = AQ.getQueue();
                        System.out.println("取出的数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}

