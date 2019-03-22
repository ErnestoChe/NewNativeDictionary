package com.company;

public class Main {

    public static void main(String[] args) {
	    NativeDictionary<Integer> dict = new NativeDictionary<>(31, Integer.class);
	    dict.put("opa", 1);
        System.out.println(dict.get("opa"));
        dict.put("opa", 3);
        System.out.println(dict.get("opa"));
        dict.put("key", 123);
        dict.put("ret", 456);
        System.out.println(dict.get("key"));
        System.out.println(dict.get("ret"));
        System.out.println(dict.get("aaa"));
        System.out.println(dict.isKey("key"));
        System.out.println(dict.isKey("yeet")+ " yeet");

        dict.put("abcde", 456);
        dict.put("bacde", 456);
        dict.put("badce", 456);
        dict.put("bcdae", 456);
        dict.put("cbdae", 456);
        dict.put("dbcae", 456);
        dict.put("dacbe", 456);
        dict.put("dabce", 456);
        dict.put("eabcd", 123);
        System.out.println("dabce "+dict.isKey("dabce"));
        System.out.println("eabcd "+dict.isKey("eabcd"));
        System.out.println("eabcd "+dict.get("eabcd"));
        System.out.println("ea " + dict.isKey("ea"));
        System.out.println("ea "+dict.get("ea"));
        dict.put("eabcd", 111);
        System.out.println("added 111 w/ eabcd key");
        System.out.println("eabcd "+dict.isKey("eabcd"));
        System.out.println("eabcd "+dict.get("eabcd"));


    }
}
