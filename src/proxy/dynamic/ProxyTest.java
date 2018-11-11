package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        //创建一个实例对象，这个对象是被代理的对象
        Person person = new Student("聂风");

        //创建一个与代理对象相关联的InvocationHandler
       InvocationHandler stuHandler  = new StuInvocationHandler<Person>(person);

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);
        // Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), zhangsan.getClass().getInterfaces(), stuHandler);

        System.out.println(stuProxy.getClass().getName());

        stuProxy.giveMoney();
        //stuProxy.receiveMoney();




    }
}
