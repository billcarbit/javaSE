package annotation;

import java.lang.reflect.Field;

@Person(name = "xingoo", age = 25)
public class AnnotationTest {

    @InputTextValidate(toast = "请填写手机号")
    private String aaa;

    public static void print(Class c) {
        System.out.println(c.getName());
        //java.lang.Class的getAnnotation方法，如果有注解，则返回注解。否则返回null
        Person person = (Person) c.getAnnotation(Person.class);
        if (person != null) {
            System.out.println("name:" + person.name() + " age:" + person.age());
        } else {
            System.out.println("person unknown!");
        }
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InputTextValidate.class)) {
                InputTextValidate fruitName = (InputTextValidate) field.getAnnotation(InputTextValidate.class);
                if (fruitName.required()) {
                    System.out.println( fruitName.toast());
                }

            }
        }


    }


    public static void main(String[] args) {
        AnnotationTest.print(AnnotationTest.class);
    }


}
