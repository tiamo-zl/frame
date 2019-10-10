package com.lll.frame.dao.mapper;

import java.util.TreeMap;

/**
 * Description
 *
 * @Author zl
 * @Create 2019-09-06 10:33
 **/
public class CloneTest {

	
	public static void main(String[] args) {

		TreeMap<String, String> treeMap1 = new TreeMap<>();
		TreeMap<String, String> treeMap2 = new TreeMap<>();

		TreeMap<String, String> treeMap3 = new TreeMap<>();

		for (int i = 0; i < 100000; i++) {
			treeMap1.put("key: " + i, i + "hjhjhh&^267%%@$%$%$$%@");
		}

		long time1 = System.currentTimeMillis();
		for (String key : treeMap1.keySet()) {
			treeMap2.put(key, treeMap1.get(key));
		}
		long time2 = System.currentTimeMillis();

		System.err.println("for-time : " + (time2 - time1));


		treeMap3 = (TreeMap<String, String>) treeMap2.clone();

		long time3 = System.currentTimeMillis();

		System.err.println("clone-time : " + (time3 - time2));


		System.out.println("treeMap2 : " + treeMap2.size());
		System.out.println("treeMap3 : " + treeMap3.size());
		System.err.println(treeMap3.get("key: " + 100));

	}

}
