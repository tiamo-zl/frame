package com.lll.sort.algorithm.assist;

/**
 * @ClassName ListNode
 * @Description 链表节点
 * @Author zl
 * @Create 2019-03-26 22:14
 **/
public class ListNode {
    private int data;
    private ListNode nextNode;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }


    @Override
    public String toString() {
        return data + ", " + nextNode;
    }

}
