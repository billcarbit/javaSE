package annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

@Target(TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Person {

    String name();

    int age();
}
