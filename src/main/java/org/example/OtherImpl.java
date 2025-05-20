package somepackage;

/**
 * Альтернативная реализация SomeInterface. Выводит "B".
 */
public class OtherImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.print("B"); // Другая реализация
    }
}