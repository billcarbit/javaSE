package beanconvert;

import beanconvert.bean.ControllerBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class ConvertTest {

    public static void main(String[] args) throws IllegalAccessException {
        ControllerBean bean = new ControllerBean();
        bean.setDaoId("1");
        bean.setDaoName("wang");

        new Converter(bean);

        String id = bean.getControllerId();
        String name = bean.getControllerName();
        System.out.println("id=" + id + ",name=" + name);

        String jsonString = JSONObject.toJSONString(bean);
        System.out.println(jsonString);


        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(ControllerBean.class,
                "controllerId","controllerName");
        SerializeFilter[] filters=new SerializeFilter[]{filter1};
        System.out.println(JSONObject.toJSONString(bean, filters));


    }
}
