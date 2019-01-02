package beanconvert;

import beanconvert.bean.ControllerBean;
import beanconvert.bean.UserInfo;
import beanconvert.bean.UserInfo2;

public class ConvertTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        UserInfo userInfo = new UserInfo();
        userInfo.setID("1");
        userInfo.setUSER_TYPE("员工");
        userInfo.setAccount("132***57");
        userInfo.setGender("男");
        userInfo.setName("张三");


        String jsonString = new Converter().toJsonString(userInfo);
        System.out.println(jsonString);

        UserInfo2 userInfo2 = new Converter<UserInfo, UserInfo2>().getSubObject(userInfo, UserInfo2.class);
        System.out.println(userInfo2.getId());
    }
}
