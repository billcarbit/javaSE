package annotation;


import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

@Target(FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface InputTextValidate {

    String toast();

    boolean required() default false;
}
