package pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserManagerImplProxy implements InvocationHandler {

    private Object target;


    //生成代理类
    public Object newProxyInstance(Object targetObject){
        this.target = targetObject;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //给 每个方法都添加 计时器
        System.out.println(System.currentTimeMillis());
        Object result = method.invoke(args);
        System.out.println(System.currentTimeMillis());
        return result;
    }

}
