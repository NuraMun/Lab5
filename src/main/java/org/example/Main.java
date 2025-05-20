package org.example;
import somepackage.Injector;
import somepackage.SomeBean;

public class Main {
    public static void main(String[] args) {
        SomeBean bean = new Injector().inject(new SomeBean());
        bean.foo(); // Вывод: AC
    }
}