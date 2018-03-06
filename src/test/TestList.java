package test;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        System.out.println("1");
    }
}
