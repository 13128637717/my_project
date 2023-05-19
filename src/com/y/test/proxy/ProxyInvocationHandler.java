package com.y.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2023/1/31 9:27
 */
public class ProxyInvocationHandler<T> implements InvocationHandler {

    private T target;

    public ProxyInvocationHandler(T target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("中介带看房");
        Object object = method.invoke(target, args);
        System.out.println("收中介费");
        return object;
    }

    /**
     * 动态代理测试方法
     * @param args
     */
    public static void main(String[] args) {
        Person person = new Renter();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler<Person>(person);

        Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, proxyInvocationHandler);
        proxy.rentHouse();
    }
}
