package cz.mrq.experiments.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Util
 *
 * @author Lumir Mrkva (lumir.mrkva@topmonks.com)
 */
public final class Util {

    public static void time(Method method) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Executing " + method.getName());
        long start = System.currentTimeMillis();
        method.invoke(null);
        long end = System.currentTimeMillis();
        System.out.println("Method "+ method.getName() + " finished in " + (end - start) + " ms");
    }

    public static void time(Method[] methods) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            time(method);
        }
    }

    public  static void time(Class clazz) throws InvocationTargetException, IllegalAccessException {
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        for (Method method : methods) {
            if (method.isAnnotationPresent(Time.class)) {
                time(method);
            }
        }
    }

    private Util() {};

}
