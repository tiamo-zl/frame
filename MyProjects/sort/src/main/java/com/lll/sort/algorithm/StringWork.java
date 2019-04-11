package com.lll.sort.algorithm;

import java.util.*;

/**
 * @ClassName StringWork
 * @Description
 * @Author zl
 * @Create 2019-03-27 16:51
 **/
public class StringWork {


    /**
     * 找出字符串中的最大不重复元素的字串的长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        long time = System.currentTimeMillis();
        if (s.length()==0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        System.err.println("other3: " + (System.currentTimeMillis() - time));
        return max;
    }

    /**
     * 找出字符串中的最大不重复元素的字串的长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring4(String s) {
        long time = System.currentTimeMillis();
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        System.err.println("other4: " + (System.currentTimeMillis() - time));
        return max;
    }

    /**
     * 找出字符串中的最大不重复元素的字串的长度
     * @return
     */
    public static double findMedianSortedArrays(int[] left, int[] right) {

        //  1  7   10  13
        //  5  8
        //判断是否需要调换位置

        int size = left.length + right.length;
        int leftIndex = (size + 1)/2;
        int rightIndex = (size + 2)/2;
        if (left.length < right.length){
            return work(right, left, leftIndex, rightIndex);
        } else {
            return work(left, right, leftIndex, rightIndex);
        }

    }

    private static double work(int[] big, int[] little, int leftIndex, int rightIndex) {
        int leftData = 0;
        int rightData = 0;
        int lenght = 0;
        int bigNewStart = 0;
        for (int littleIndex = 0; littleIndex < little.length; ){
            lenght++;
            if (  littleIndex + bigNewStart + 1 == leftIndex){
                //代表找到这个左值
                if (little[littleIndex] > big[bigNewStart]){
                    leftData = big[bigNewStart];
                    bigNewStart++;
                    continue;
                }else{
                    leftData = little[littleIndex];
                    littleIndex++;
                    continue;
                }
            }
            if (  littleIndex + bigNewStart + 1 == rightIndex){
                //代表找到这个右值
                if (little[littleIndex] > big[bigNewStart]){
                    rightData = big[bigNewStart];
                    bigNewStart++;
                    break;
                }else{
                    rightData = little[littleIndex];
                    littleIndex++;
                    break;
                }
            }

            if (little[littleIndex] > big[bigNewStart]){
                bigNewStart++;
            }else{
                littleIndex++;
            }

        }
        if (lenght < leftIndex){
            //两个值
            leftData = big[leftIndex - bigNewStart - 1];
            rightData = big[rightIndex - bigNewStart - 1];
        }else if (lenght == leftIndex){
            if (rightIndex == leftIndex){
                rightData = leftData;
            } else {
                rightData = big[rightIndex - bigNewStart - 2];
            }

        }
        return (double)(leftData + rightData)/2;

    }

    /**
     * 查询字符串的最大回文串
     * @param s
     */
    public void  longestPalindrome(String s){
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
    }


    public static void main(String[] args) {

        int[] arr3 = new int[]{1,4,5,6};
        int[] arr4 = new int[]{2,3};
        double median2 =  findMedianSortedArrays(arr3, arr4);
        System.out.println(median2);
    }


}
