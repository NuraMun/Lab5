package somepackage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки корректности конфигурации в файле `config.properties`.
 */
class ConfigTest {

    /**
     * Тест проверяет, что в конфигурационном файле указаны корректные реализации интерфейсов.
     */
    @Test
    void configShouldContainValidImplementations() {
        // Создаем экземпляр Injector, который загружает конфигурацию из файла
        Injector injector = new Injector();

        // Получаем реализацию для интерфейса SomeInterface из конфигурации
        String someImpl = injector.getProperties().getProperty("somepackage.SomeInterface");
        // Проверяем, что значение равно "somepackage.SomeImpl"
        assertEquals("somepackage.SomeImpl", someImpl,
                "Реализация для SomeInterface должна быть somepackage.SomeImpl");

        // Получаем реализацию для интерфейса SomeOtherInterface из конфигурации
        String soDoer = injector.getProperties().getProperty("somepackage.SomeOtherInterface");
        // Проверяем, что значение равно "somepackage.SODoer"
        assertEquals("somepackage.SODoer", soDoer,
                "Реализация для SomeOtherInterface должна быть somepackage.SODoer");
    }
}