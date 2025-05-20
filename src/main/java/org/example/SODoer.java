package somepackage;

/**
 * Реализация SomeOtherInterface. Выводит "C".
 */
public class SODoer implements SomeOtherInterface {
    @Override
    public void doSomeOther() {
        System.out.print("C"); // Реализация другого интерфейса
    }
}