package br.com.aceleradev.main;

public class MainGarbageCollector {

    public static void main(String[] args) {

        String a = new String("a");
        String b = new String("b");
        String c = new String("c");

        a = b;

        b = "b2";

        System.out.println(a);

        System.gc();

    }

}
