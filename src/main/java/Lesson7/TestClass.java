package Lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void start(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        Object object = null;

        // проверить, что @BeforeSuite и @AfterSuite в единственном экземпляре
        int countAS = 0;
        int countBS = 0;
        for(Method m : methods) {
            if(m.getAnnotation(AfterSuite.class) != null) countAS++;
            if(m.getAnnotation(BeforeSuite.class) != null) countBS++;
        }
        if(countAS > 1 | countBS > 1) throw new RuntimeException();

        // отсортировать методы по приоритетам
        List<Method> sortMethods = new ArrayList<>();
        Method methodAS = null;
        Method methodBS = null;
        for(Method m : methods) {
            if(m.getAnnotation(Test.class) != null) sortMethods.add(m);
            if(m.getAnnotation(AfterSuite.class) != null) methodAS = m;
            if(m.getAnnotation(BeforeSuite.class) != null) methodBS = m;
        }
        sortMethods.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());
        if(methodBS != null) sortMethods.add(0,methodBS);
        if(methodAS != null) sortMethods.add(methodAS);

        // вызвать методы
        try {
            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            object = constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        for(Method m : sortMethods) {
            try {
                m.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
       start(SimpleClass.class);
    }

}
