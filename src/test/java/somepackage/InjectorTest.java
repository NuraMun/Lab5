package somepackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {
    private Injector injector;

    @BeforeEach
    void setUp() {
        injector = new Injector(); // Инициализация перед каждым тестом
    }

    @Test
    void inject_ShouldInjectDependencies() {
        SomeBean bean = new SomeBean();
        injector.inject(bean);

        // Проверка, что зависимости не null
        assertNotNull(bean.getField1());
        assertNotNull(bean.getField2());

        // Проверка типов внедренных объектов
        assertTrue(bean.getField1() instanceof SomeImpl);
        assertTrue(bean.getField2() instanceof SODoer);
    }

}