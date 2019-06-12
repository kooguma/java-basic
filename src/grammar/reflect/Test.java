package grammar.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {

    public static void main(String[] args) {
        Class<A> aClass = A.class;
        printClassInfo(aClass);
    }

    public static void printClassInfo(Class clz) {
        System.out.println("class name : " + clz.getName());
        Field[] fields = clz.getFields();
        Method[] methods = clz.getMethods();

        for (Field f : fields) {
            String name = f.getName();
            int modifiers = f.getModifiers();
            Class type = f.getType();
            System.out.println("filed info { " +  " name : " + name + ", modifiers : " + Modifier.toString(modifiers) +
            ", type : " + type + " }");
        }

        for (Method m : methods){

        }
    }
}
