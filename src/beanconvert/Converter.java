package beanconvert;

import beanconvert.bean.ControllerBean;
import beanconvert.bean.UserInfo;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter<Father, Son> {

    List<String> fieldList = new ArrayList<String>();
    Map<String, String> fieldValMap = new HashMap<String, String>();

    public Converter() {
    }

    public Son getSubObject(Father fatherObj, Class<Son> sonCls) throws IllegalAccessException, InstantiationException {
        Son sonObj = sonCls.newInstance();
        Field[] sonFields = sonCls.getDeclaredFields();
        for (Field field : sonFields) {
            field.setAccessible(true);
            field.set(sonObj, "sas");
            // TODO: 2019/1/2  
        }
        return sonObj;
    }

    public String toJsonString(Object obj) throws IllegalAccessException {
        Class cls = obj.getClass();
        dealSuperFields(cls, obj);
        dealSubFields(cls, obj);
        return convertToFastJsonString(obj);
    }

    private void dealSuperFields(Class cls, Object obj) throws IllegalAccessException {
        Class superCls = cls.getSuperclass();
        Field[] superFields = superCls.getDeclaredFields();
        for (Field field : superFields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            if (value == null) {
                continue;
            }
            fieldValMap.put(field.getName(), value.toString());
            fieldList.add(field.getName());
        }
    }

    private void dealSubFields(Class cls, Object obj) throws IllegalAccessException {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ValueFrom.class)) {
                ValueFrom fieldAnnotation = (ValueFrom) field.getAnnotation(ValueFrom.class);
                if (fieldValMap.containsKey(fieldAnnotation.superFiled())) {
                    field.setAccessible(true);
                    field.set(obj, fieldValMap.get(fieldAnnotation.superFiled()));
                    if (fieldAnnotation.replaced()) {
                        fieldList.remove(fieldAnnotation.superFiled());
                    }
                    fieldList.add(field.getName());
                }
            }
        }
    }

    private String convertToFastJsonString(Object obj) {
        String[] strings = new String[fieldList.size()];
        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(ControllerBean.class,
                fieldList.toArray(strings));
        SerializeFilter[] filters = new SerializeFilter[]{filter1};
        String json = JSONObject.toJSONString(obj, filters);
        return json;
    }
}
