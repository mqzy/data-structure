import java.util.Stack;

public class LinkedList {
    //初始化头结点，头结点不要动,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    private HeroNode getHead() {
        return head;
    }

    private void add(HeroNode heroNode){
        HeroNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
    }

    private void addByNo(HeroNode heroNode){//按no大小顺序插入
        HeroNode temp = head;
        int no = heroNode.getNo();
        boolean flag = false;//判断插入在最后
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getNo() == no){
                System.out.println("已有英雄:"+no+"，添加失败");
                return;
            }
            if (temp.getNext() != null && temp.getNext().getNo() > no){
                flag = true;//不插在最后
                break;
            }
        }
        if (flag) {
            HeroNode next = temp.getNext();
            temp.setNext(heroNode);
            temp.getNext().setNext(next);
        }else
            temp.setNext(heroNode);
    }

    private void update(HeroNode heroNode){//更新链表
        if (head.getNext() == null){
            System.out.println("链表为空~update");
            return;
        }
        HeroNode temp = head.getNext();
        boolean flag = false;
        while (temp != null){
            if (temp.getNo() == heroNode.getNo()){
                flag = true;
                temp.setName(heroNode.getName());
                temp.setNickname(heroNode.getNickname());
                break;
            }
            temp = temp.getNext();
        }
        if (flag)
            System.out.println("节点更新成功");
        else
            System.out.println("没有找到这个节点");
    }

    private void delete(int no){//删除链表
        if (head.getNext() == null){
            System.out.println("链表为空~delete");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (temp.getNext() != null){
            if (temp.getNext().getNo() == no){
                temp.setNext(temp.getNext().getNext());
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag)
            System.out.println("删除节点成功");
        else
            System.out.println("没有找到这个节点");
    }

    private int length(){//获取单链表节点的个数，不计算头结点
        int len = 0;
        HeroNode next = head;
        while (next.getNext() != null){
            len++;
            next = next.getNext();
        }
        return len;
    }

    private HeroNode findLastIndexNode(int index){//找到倒数第index个节点
        int size = this.length();
        if (index <= 0 || index > size){
            return null;
        }
        HeroNode temp = head.getNext();
        for (int i = 0; i < size-index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    private void reverseNode(){
        if (head.getNext() == null || head.getNext().getNext() == null)//链表为空或者只有一个数据
            return;
        int size = this.length();
        HeroNode[] heroNodes = new HeroNode[size];
        HeroNode temp1 = head.getNext();
        for (int i = 0; i < size; i++) {
            heroNodes[i] = temp1;
            temp1 = temp1.getNext();
            heroNodes[i].setNext(null);
        }
        HeroNode temp2 = head;
        for (int i = size-1; i >= 0; i--) {
            temp2.setNext(heroNodes[i]);
            temp2 = temp2.getNext();
        }
    }

    private void mergeNode(LinkedList linkedList){
        //linkedlist2被破坏
//        int size = linkedList.length();
//        HeroNode[] heroNodes = new HeroNode[size];
//        HeroNode temp = linkedList.getHead().getNext();
//        for (int i = 0; i < size; i++) {
//            heroNodes[i] = temp;
//            temp = temp.getNext();
//            heroNodes[i].setNext(null);
//        }
//        for (int i = 0; i < size; i++) {
//            this.addByNo(heroNodes[i]);
//        }
        //linkedlist2被破坏
//        HeroNode temp = linkedList.getHead().getNext();
//        while (temp != null){
//            HeroNode node = temp;
//            temp = temp.getNext();
//            this.addByNo(node);
////            temp = temp.getNext();
//        }
        //linkedlist2保持原样
        HeroNode temp = linkedList.getHead().getNext();
        while (temp != null){
            HeroNode node = clone(temp);
            this.addByNo(node);
            temp = temp.getNext();
        }
    }

    private HeroNode clone(HeroNode heroNode){
        return new HeroNode(heroNode.getNo(),heroNode.getName(),heroNode.getNickname());
    }

    private void list(){
        if (head.getNext() == null){
            System.out.println("链表为空~list");
            return;
        }
        HeroNode temp = head.getNext();
        while (temp != null){
            System.out.println(temp);
            System.out.println();
            temp = temp.getNext();
        }
    }

    private void revlist(){//反转输出链表
        if (head.getNext() == null){
            System.out.println("链表为空~revlist");
            return;
        }
        Stack<HeroNode> stack= new Stack<>();
        HeroNode temp = head.getNext();
        while (temp != null){
            stack.push(temp);
            temp = temp.getNext();
        }
        while (stack.size() > 0)
            System.out.println(stack.pop());
    }

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero7 = new HeroNode(7, "秦明", "霹雳火");
        HeroNode hero8 = new HeroNode(8, "呼延灼", "双鞭");
        LinkedList linkedList1 = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList1.add(hero1);
        linkedList1.add(hero3);
        linkedList1.add(hero5);
        linkedList1.add(hero7);
        linkedList2.add(hero2);
        linkedList2.add(hero4);
        linkedList2.add(hero6);
        linkedList2.add(hero8);
        linkedList1.mergeNode(linkedList2);
        linkedList1.list();
        System.out.println();
        linkedList2.list();
//        System.out.println(linkedList1.length());
//        HeroNode heroNode = new HeroNode(2,"xxx", "玉麒麟");
//        linkedList1.update(heroNode);
//        linkedList1.list();
//        linkedList1.delete(1);
//        linkedList1.list();
//        linkedList1.delete(8);
//        linkedList1.list();
//        System.out.println(linkedList1.findLastIndexNode(4));
//        linkedList1.reverseNode();
//        linkedList1.list();
//        linkedList1.revlist();
    }
}

class HeroNode{
    private int no;
    private String name;
    private String nickname;
    private HeroNode next;

    HeroNode(int no, String name, String nickname) {

        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    HeroNode getNext() {
        return next;
    }

    void setNext(HeroNode next) {
        this.next = next;
    }

    int getNo() {
        return no;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getNickname() {
        return nickname;
    }

    void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                "}";
    }

//    @Override
//    public String toString() {
//        return "HeroNode{" +
//                "no=" + no +
//                ", name='" + name + '\'' +
//                ", nickname='" + nickname + '\'' +
//                ", next=" + next +
//                '}';
//    }
}