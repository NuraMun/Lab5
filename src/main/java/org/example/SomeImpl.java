package somepackage;

/**
 * Реализация SomeInterface. Выводит "A".
 */
public class SomeImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.print("A"); // Конкретная реализация
    }
}