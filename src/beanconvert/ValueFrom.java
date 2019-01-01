package beanconvert;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueFrom {
    String superFiled();

    boolean replaced() default false;
}
