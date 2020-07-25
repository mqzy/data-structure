package linkedlist;

public class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0,"","");

    private void show(){
        if (head.getNext() == null){
            System.out.println("链表为空~show");
        }
        HeroNode2 temp = head.getNext();
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
        System.out.println();
    }

    private void add(HeroNode2 heronode){
        HeroNode2 temp = head;
        while (temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(heronode);
        heronode.setPre(temp);
    }

    private void addByNo(HeroNode2 heroNode){
        HeroNode2 temp = head;
        int no = heroNode.getNo();
        boolean flag = false;
        while (temp.getNext() != null){
            temp = temp.getNext();
            if (temp.getNo() == no){
                System.out.println("已有英雄:"+no+"，添加失败");
                return;
            }
            if (temp.getNext() != null && temp.getNext().getNo() > no){
                flag = true;
                break;
            }
        }
        if (flag){
            heroNode.setNext(temp.getNext());
            heroNode.setPre(temp);
            temp.getNext().setPre(heroNode);
            temp.setNext(heroNode);
        }else{
            temp.setNext(heroNode);
            heroNode.setPre(temp);
        }
    }

    private void update(HeroNode2 heronode){
        if (head.getNext() == null){
            System.out.println("链表为空~update");
            return;
        }
        HeroNode2 temp = head.getNext();
        boolean flag = false;
        while (temp != null){
            if (temp.getNo() == heronode.getNo()){
                flag = true;
                temp.setName(heronode.getName());
                temp.setNickname(heronode.getNickname());
                break;
            }
            temp = temp.getNext();
        }
        if (flag)
            System.out.println("节点更新成功");
        else
            System.out.println("没有找到这个节点");
    }

    private void delete(int no){
        if (head.getNext() == null){
            System.out.println("链表为空~delete");
            return;
        }
        HeroNode2 temp = head.getNext();
        boolean flag = false;
        while (temp != null){
            if (temp.getNo() == no){
                temp.getPre().setNext(temp.getNext());
                if (temp.getNext() != null)
                    temp.getNext().setPre(temp.getPre());
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
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "公孙胜", "入云龙");
        HeroNode2 hero5 = new HeroNode2(5, "关胜", "大刀");
        HeroNode2 hero6 = new HeroNode2(6, "林冲", "豹子头");
        HeroNode2 hero7 = new HeroNode2(7, "秦明", "霹雳火");
        HeroNode2 hero8 = new HeroNode2(8, "呼延灼", "双鞭");
        DoubleLinkedList linkedList1 = new DoubleLinkedList();
        DoubleLinkedList linkedList2 = new DoubleLinkedList();
        linkedList1.add(hero1);
        linkedList1.add(hero3);
        linkedList1.add(hero5);
        linkedList1.add(hero7);
//        linkedList1.addByNo(hero4);
//        linkedList1.addByNo(hero8);
        linkedList2.add(hero2);
        linkedList2.add(hero4);
        linkedList2.add(hero6);
        linkedList2.add(hero8);
//        linkedList1.delete(1);
//        linkedList1.delete(7);
//        linkedlist.HeroNode2 heroNode2 = new linkedlist.HeroNode2(7,"xx","xx");
//        linkedList1.update(heroNode2);
//        linkedList1.delete(7);
        linkedList1.show();
//        linkedList2.show();
    }
}

class HeroNode2{
    private int no;
    private String name;
    private String nickname;
    private HeroNode2 pre;
    private HeroNode2 next;

    HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    int getNo() {
        return no;
    }

    void setNo(int no) {
        this.no = no;
    }

    HeroNode2 getPre() {
        return pre;
    }

    void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    HeroNode2 getNext() {
        return next;
    }

    void setNext(HeroNode2 next) {
        this.next = next;
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
        return "Heronode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}