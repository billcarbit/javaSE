package beanconvert;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Converter {

    public Converter(Object obj) throws IllegalAccessException {
        Map<String, String> map = new HashMap<String, String>();

        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        Class superCls = cls.getSuperclass();
        Field[] superFields = superCls.getDeclaredFields();
        for (Field field : superFields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            map.put(field.getName(), value.toString());
        }
        for (Field field : fields) {
            if (field.isAnnotationPresent(ValueFrom.class)) {
                ValueFrom fieldAnnotation = (ValueFrom) field.getAnnotation(ValueFrom.class);
                if (map.containsKey(fieldAnnotation.superFiled())) {
                    field.setAccessible(true);
                    field.set(obj, map.get(fieldAnnotation.superFiled()));
                }

            }
        }
    }
}
