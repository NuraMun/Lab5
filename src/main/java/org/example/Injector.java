package somepackage;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс для внедрения зависимостей на основе аннотации @AutoInjectable.
 */
public class Injector {
    private final Properties properties = new Properties(); // Хранит настройки из config.properties

    public Injector() {
        // Загрузка конфигурации из файла
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input); // Чтение свойств
            } else {
                throw new RuntimeException("Файл config.properties не найден");
            }
        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки конфигурации", e);
        }
    }

    /**
     * Внедряет зависимости в объект.
     */
    public <T> T inject(T object) {
        // Итерация по всем полям класса
        for (Field field : object.getClass().getDeclaredFields()) {
            // Проверка наличия аннотации @AutoInjectable
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                // Получение типа поля (интерфейса)
                String interfaceName = field.getType().getName();
                // Поиск реализации в конфигурации
                String implementationName = properties.getProperty(interfaceName);

                try {
                    // Создание экземпляра реализации
                    Class<?> clazz = Class.forName(implementationName.trim());
                    Object instance = clazz.getDeclaredConstructor().newInstance();

                    // Установка значения поля через рефлексию
                    field.setAccessible(true); // Разрешаем доступ к private полю
                    field.set(object, instance);
                } catch (Exception e) {
                    throw new RuntimeException("Ошибка внедрения зависимости", e);
                }
            }
        }
        return object;
    }

    public Properties getProperties() {
        return properties; // Для тестирования конфигурации
    }
}