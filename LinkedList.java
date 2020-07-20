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

    private void update(HeroNode heroNode){
        if (head.getNext() == null){
            System.out.println("链表为空");
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

    private void delete(int no){
        if (head.getNext() == null){
            System.out.println("链表为空");
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
        HeroNode hero4 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero5 = new HeroNode(7, "秦明", "霹雳火");
        HeroNode hero6 = new HeroNode(8, "呼延灼", "双鞭");
        LinkedList linkedList = new LinkedList();
        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero5);
        linkedList.add(hero6);
        linkedList.addByNo(hero4);
        linkedList.list();
//        HeroNode heroNode = new HeroNode(2,"xxx", "玉麒麟");
//        linkedList.update(heroNode);
//        linkedList.list();
//        linkedList.delete(1);
////        linkedList.list();
        linkedList.delete(8);
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
}