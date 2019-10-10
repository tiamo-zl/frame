package com.lll.sort.algorithm;

import com.lll.sort.algorithm.assist.ListNode;
import com.lll.sort.utils.NodeUtils;
import org.junit.Assert;
import org.junit.Test;

public class MergerNodeTest {

    @Test
    public void mergeTwoNode() {

        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode frist = new ListNode(1);
        ListNode last = new ListNode(2);

        getListNode(frist, node3, node6, node7);
        getListNode(last, node4, node5, node8, node9);

        ListNode listNode = new MergerNode().mergeTwoNode(frist, last);
        System.out.println(listNode);
        Assert.assertEquals(NodeUtils.isSort(listNode), true);
    }

    @Test
    public void addTwoNumbers() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(7);
        getListNode(node1, node2, node3);
        getListNode(node4, node5, node6);
        System.out.println(node1);
        System.out.println(node4);
        System.out.println("-----------------");
        ListNode listNode = new MergerNode().addTwoNumbers(node1, node4);
        System.err.println(listNode);

    }

    public  static ListNode init1(){
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        ListNode node9 = new ListNode(9);
        ListNode node11 = new ListNode(11);

        return getListNode(node1, node3, node5, node7, node9, node11);
    }

    public  static ListNode init2(){
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        ListNode node10 = new ListNode(10);
        ListNode node12 = new ListNode(12);

        return getListNode(node2, node4, node6, node8, node10, node12);
    }

    private static ListNode getListNode(ListNode... nodes) {
        if (0 == nodes.length){
            return null;
        }
        ListNode node = nodes[0];
        ListNode head = node;
        for (int index = 1; index < nodes.length; index++) {
            node.setNextNode(nodes[index]);
            node = node.getNextNode();
        }
        return head;
    }

}