package beanconvert;

import beanconvert.bean.ControllerBean;

public class ConvertTest {

    public static void main(String[] args) throws IllegalAccessException {
        ControllerBean bean = new ControllerBean();
        bean.setDaoId("1");
        bean.setDaoName("wang");
        String jsonString = new Converter().toJsonString(bean);
        System.out.println(jsonString);
    }
}
