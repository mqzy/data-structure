package linkedlist;

import java.util.Scanner;

/*
N个人围成一圈，从约定编号为K的人开始报数，第M个将出圈，求出圈顺序。
 */
public class Joseph {
    private Boy first = null;
    private void addBoy(int num){
        if (num < 1){
            System.out.println("num的值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    private void show(){
        emptyReport("show");
        Boy temp = first;
        while (true){
            System.out.println(temp);
            if (temp.getNext() == first)
                break;
            temp = temp.getNext();
        }
    }

    private int length(){
        int count = 0;
        Boy temp = first;
        while (true){
            count++;
            if (temp.getNext() == first)
                break;
            temp = temp.getNext();
        }
        return count;
    }

    private void delete(int no){
        emptyReport("delete");
        Boy temp = first;
        while (true){
            if (temp.getNext().getNo() == no){
                if (this.length() == 1) {//如果只有一个节点，把这个节点置空
                    System.out.println("删除节点?"+no+"成功");
                    first = null;
                    break;
                }
                if (temp.getNext() == first)//如果要删除的节点是first节点且剩余节点不止一个，则先把first指向first的下一个节点
                    first = temp.getNext().getNext();
                temp.setNext(temp.getNext().getNext());//删除掉所要删除的节点
                System.out.println("删除节点"+no+"成功");
                break;
            }
            temp = temp.getNext();
            if (temp == first){
                System.out.println("未找到要删除的节点");
                break;
            }
        }
    }

    private void emptyReport(String str){
        if (first == null){
            System.out.println("链表为空~"+str);
        }
    }

    private void out1(int n,int k,int m){//比较复杂
        this.addBoy(n);
        emptyReport("out1");
        if (k > n){
            System.out.println("没有编号为"+k+"的节点");
            return;
        }
        int len1  = this.length();
        int len2 = len1;
        int[] arr = new int[len1];
        Boy temp = first;
        for (int i = 0; i < k-1; i++) {//找到开始计数的那个节点
            temp = temp.getNext();
        }
        System.out.println("开始节点:"+temp.getNo());
        while (true){
            if (this.length() == 1){//如果只剩下一个节点，那么它必是最后一个出圈的
                int no = temp.getNo();
                arr[len2-len1] = no;
                this.delete(no);
                break;
            }
            for (int i = 0; i < m-1; i++) {//找到要出圈的节点
                temp = temp.getNext();
            }
            arr[len2-len1] = temp.getNo();//将出圈的节点的值赋给数组
            this.delete(temp.getNo());
            temp = temp.getNext();//temp赋值下一个开始计数节点
            len1--;
        }
        for (int i = 0; i < len2; i++) {
            System.out.println(arr[i]);
        }
    }

    private void out2(int n,int k,int m){//比较简单
        this.addBoy(n);
        emptyReport("out1");
        if (k > n){
            System.out.println("没有编号为"+k+"的节点");
            return;
        }
        Boy temp = first;
        for (int i = 0; i < this.length()-1; i++) {
            temp = temp.getNext();//使辅助节点temp指向first的后一个节点，方便删除
        }
        for (int i = 0; i < k-1; i++) {
            first = first.getNext();
            temp = temp.getNext();
        }
        while (true){
            if (temp == first){//只剩一个节点，直接出圈
                System.out.println(temp.getNo());
                break;
            }
            for (int i = 0; i < m-1; i++) {//找到要出圈的节点
                first = first.getNext();
                temp = temp.getNext();
            }
            System.out.println(first.getNo());
            first = first.getNext();//出圈操作
            temp.setNext(first);
        }
    }

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        System.out.println("输入人的数量N：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("输入k:");
        int k = scanner.nextInt();
        System.out.println("输入m");
        int m = scanner.nextInt();
        joseph.out2(n,k,m);
//        joseph.show();
    }
}
class Boy{
    private int no;
    private Boy next;
    Boy(int no){
        this.no = no;
    }

    int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    Boy getNext() {
        return next;
    }

    void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}