package annotation;

import java.lang.reflect.Field;

public class RequestParamValidator {

    public RequestParamValidator(Object obj) throws IllegalAccessException {
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InputTextValidate.class)) {
                InputTextValidate fieldAnnotation = (InputTextValidate) field.getAnnotation(InputTextValidate.class);
                if (fieldAnnotation.required()) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if (value == null) {
                        System.out.println(fieldAnnotation.toast());
                    }
                }

            }
        }
    }
}
