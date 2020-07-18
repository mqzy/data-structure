import java.util.Scanner;

public class CircleArrayQueue {
    private int[] arr;
    private int maxSize;
    private int front;//队列头
    private int rear;//队列尾

    private CircleArrayQueue(int maxSixe) {
        this.maxSize = maxSixe;
        arr = new int[maxSixe];
        front = 0;//指向队列第一个元素
        rear = 0;//指向队列最后一个元素的后一个位置
    }

    private boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    private boolean isEmpty(){
        return rear == front;
    }

    private void addQueue(int data){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear] = data;
        rear = (rear+1)%maxSize;
    }
    private int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    private void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front;i < front+size();i++) {
            System.out.println("arr["+i%maxSize+"]: "+arr[i%maxSize]);
        }
    }

    private int size(){
        return (rear-front+maxSize)%maxSize;
    }

    public static void main(String[] args) {
        CircleArrayQueue CAQ = new CircleArrayQueue(3);
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
                    CAQ.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    CAQ.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = CAQ.getQueue();
                        System.out.println("取出的数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
