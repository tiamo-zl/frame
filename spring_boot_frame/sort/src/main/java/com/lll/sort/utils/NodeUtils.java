package com.lll.sort.utils;

import com.lll.sort.algorithm.assist.ListNode;

/**
 * @ClassName NodeUtils
 * @Description
 * @Author zl
 * @Create 2019-04-01 10:38
 **/
public class NodeUtils {


  /**
   * 判断 node 是否是一个有序的链表
   * @param node
   * @return
   */
  public static boolean isSort(ListNode node){
    if (null == node){
      return true;
    }
    if (null != node.getNextNode()){
      if(node.getNextNode().getData() >= node.getData() ){
        return isSort(node.getNextNode());
      }else{
        return false;
      }
    }
    return true;
  }

}
