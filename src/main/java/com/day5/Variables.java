package com.day5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Variables {
    public static void main(String args[]) {
        
        Set<Integer> set = new TreeSet<Integer>();
        set.add(1);     
        set.add(2);
        set.add(3);
        set.add(4);   
        set.add(4);

        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        List list = getList();

        for(Integer i: set) {
            System.out.println(i);
        }

        for(int counter = 0; counter < list.size(); counter++) {
            System.out.println(list.get(counter));
            System.out.println(list.get(counter).getClass());
        }

        for(int counter = 0; counter < set.size(); counter++) {
            //System.out.println(set.get(counter));
            //System.out.println(set.get(counter).getClass());
        }
    }

    public static List<Integer> getList() {
        ArrayList resultlist = new ArrayList<>();

        resultlist.add("1");     
        resultlist.add(2);
        resultlist.add(3);
        resultlist.add(4);   
        resultlist.add(4);

        return resultlist;
    }
}
