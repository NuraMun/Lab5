package somepackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для автоматического внедрения зависимостей.
 */
@Target(ElementType.FIELD) // Применяется только к полям
@Retention(RetentionPolicy.RUNTIME) // Доступна в runtime через рефлексию
public @interface AutoInjectable {
}