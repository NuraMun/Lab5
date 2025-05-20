package somepackage;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для аннотации {@link AutoInjectable}.
 */
class AutoInjectableTest {

    /**
     * Проверяет, что поля field1 и field2 помечены аннотацией {@link AutoInjectable}.
     */
    @Test
    void fieldShouldBeAnnotated() throws NoSuchFieldException {
        // Получение поля field1 через рефлексию
        Field field1 = SomeBean.class.getDeclaredField("field1");
        assertTrue(field1.isAnnotationPresent(AutoInjectable.class), "Поле field1 не аннотировано");

        // Получение поля field2 через рефлексию
        Field field2 = SomeBean.class.getDeclaredField("field2");
        assertTrue(field2.isAnnotationPresent(AutoInjectable.class), "Поле field2 не аннотировано");
    }
}