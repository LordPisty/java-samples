package annotation;

import java.lang.reflect.Method;

/**
 * Created by screspi on 3/29/15.
 */
public class TestAnnotationParser {
    public void parse(final Class clazz)
            throws Exception
    {
        final Method[] methods = clazz.getMethods();
        for (final Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                final Test test = method.getAnnotation(Test.class);
                final String info = test.info();

                if ("AWESOME".equals(info)) {
                    System.out.println(method.getName() + " is awesome!");
                    // try to invoke the method with param
                    method.invoke(Annotated.class.newInstance(), info);
                } else {
                    System.out.println(method.getName() + " is " + info);
                    // try to invoke the method with param
                    method.invoke(Annotated.class.newInstance(), info);
                }
            }
        }
    }
}

