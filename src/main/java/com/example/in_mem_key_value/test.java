//package com.example.in_mem_key_value;
//
//import java.util.ArrayDeque;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class test {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        ArrayDeque<String>  a = new ArrayDeque<>();
//        a.add("a");
//        a.add("b");
//        /**
//         * Most ArrayDeque operations run in amortized constant time. Exceptions include remove, removeFirstOccurrence, removeLastOccurrence, contains, iterator.remove(), and the bulk operations, all of which run in linear time.
//         */
//        System.out.println(a.getFirst());
//        LinkedList<String>  b = new LinkedList<>();
//        /**
//         * Double linked list
//         */
//        b.add(0, "a");
//        b.add("b");
//        System.out.println(b.getFirst());
//        ListIterator<String> it = (ListIterator<String>) b.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//            it.remove();
//            it.add("test");
//        }
//
//
//
//    }
//}
