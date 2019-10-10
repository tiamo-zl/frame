package com.lll.frame.dao.mapper;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author zl
 * @date 2019-09-19 10:47
 **/
public class TestMap {


  public static void main(String[] args) {

    List<Integer> listWithDuplicates = Lists.newArrayList(1, 1, 2, 2, 3, 3);
    listWithDuplicates = listWithDuplicates.stream()
            .distinct()
            .collect(Collectors.toList())
            .stream()
            .filter(
                    userId -> 1 == userId
            ).collect(Collectors.toList());

    System.err.println(listWithDuplicates);

  }


}
