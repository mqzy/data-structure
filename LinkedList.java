public class LinkedList {
    //初始化头结点，头结点不要动,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");
    private void add(HeroNode heroNode){
        HeroNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
    }

    private void addByNo(HeroNode heroNode){//按no大小顺序插入
        HeroNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getNo() == heroNode.getNo()){
                System.out.println("已有英雄，添加失败");
                return;
            }
            if (temp.getNext().getNo() > heroNode.getNo()){
                break;
            }
        }
        if (temp.getNext() != null) {
            HeroNode next = temp.getNext();
            temp.setNext(heroNode);
            temp.getNext().setNext(next);
        }else
            temp.setNext(heroNode);
    }

    private void list(){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.getNext();
        while (temp != null){
            System.out.println(temp);
            System.out.println();
            temp = temp.getNext();
        }
    }
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero5 = new HeroNode(7, "吴用", "智多星");
        HeroNode hero6 = new HeroNode(8, "吴用", "智多星");
        LinkedList linkedList = new LinkedList();
        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero5);
        linkedList.add(hero6);
        linkedList.addByNo(hero4);
        linkedList.addByNo(hero4);
        linkedList.list();
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

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                "}";
    }
}