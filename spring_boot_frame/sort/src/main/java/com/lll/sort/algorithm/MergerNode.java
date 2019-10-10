package com.lll.sort.algorithm;

import com.lll.sort.algorithm.assist.ListNode;

/**
 * @ClassName MergerNode
 * @Description
 * @Author zl
 * @Create 2019-03-26 23:29
 **/
public class MergerNode {


    /**
     * 合并两个有序的链表， 并 返回一个合并后的有序列表
     * @param node1
     * @param node2
     * @return
     */
    public ListNode mergeTwoNode(ListNode node1, ListNode node2) {

        if (null == node1) {
            return node2;
        }
        if (null == node2) {
            return node1;
        }
        ListNode head;
        if (node1.getData() > node2.getData()) {
            head = node2;
            node2 = node2.getNextNode();
            head.setNextNode(mergeTwoNode(node1, node2));
        } else {
            head = node1;
            node1 = node1.getNextNode();
            head.setNextNode(mergeTwoNode(node1, node2));
        }
        return head;
    }

    /**
     * 利用链表将两个数相加
     *      1   2   3
     *      2   3   7
     *      3   5   0   1
     * @param node1
     * @param node2
     * @return
     */
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {

        if (null == node1) {
            return node2;
        }
        if (null == node2) {
            return node1;
        }
        ListNode head;
        int ten = 10;
        int sum = node1.getData() + node2.getData();
        head = new ListNode(sum % 10);
        node1 = node1.getNextNode();
        node2 = node2.getNextNode();

        if (sum >= ten) {
            if (node1 == null) {
                node1 = new ListNode(1);
            } else {
                if (node2 == null) {
                    node2 = new ListNode(1);
                } else {
                    node2.setData(node2.getData() + 1);
                }
            }
        }

        head.setNextNode(addTwoNumbers(node1, node2));

        return head;

    }


}
