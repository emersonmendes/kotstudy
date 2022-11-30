package br.com.emersonmendes.kotstudy.other;

import java.util.HashMap;
import java.util.Map;

public class JavaTest {

    private static String text = "Hello World";

    private static final Map<Integer,String> texts = new HashMap<>();
    private static final Map<Integer,String> texts2 = Map.of(0, "Hello Friend");

    public static void main(String[] args) {
        showHelloWorld();
    }

    private static void showHelloWorld() {

        texts.put(1,"Hello Emerson");
        texts.put(2, "Hello Bob");
        texts.put(3, "Hello Kimany");

        System.out.println(text);
        System.out.println(texts2.get(0));
        System.out.println(texts.get(1));
        System.out.println(texts.get(2));
        System.out.println(texts.get(3));

    }

}
