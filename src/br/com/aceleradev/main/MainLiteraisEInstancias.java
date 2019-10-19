package br.com.aceleradev.main;

public class MainLiteraisEInstancias {

    public static void main(String[] args) {

        //LITERAL
        Integer a = 1;
        Integer c = 1;
        //INSTANCIA
        Integer b = new Integer(1);

        //FALSE
        System.out.println(a == b);
        System.out.println(a == c);

    }

}
