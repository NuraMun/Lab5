package somepackage;

/**
 * Класс с зависимостями, которые будут внедрены автоматически.
 */
public class SomeBean {
    @AutoInjectable // Поле для внедрения SomeInterface
    private SomeInterface field1;

    @AutoInjectable // Поле для внедрения SomeOtherInterface
    private SomeOtherInterface field2;

    public void foo() {
        field1.doSomething(); // Вызов метода зависимости
        field2.doSomeOther(); // Исправлено согласно условию
    }

    // Геттеры для тестирования
    public SomeInterface getField1() {
        return field1;
    }

    public SomeOtherInterface getField2() {
        return field2;
    }
}