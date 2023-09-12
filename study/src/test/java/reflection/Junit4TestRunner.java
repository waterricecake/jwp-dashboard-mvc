package reflection;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class Junit4TestRunner {

    @Test
    void run() throws Exception {
        Class<Junit4Test> clazz = Junit4Test.class;

        // TODO Junit4Test에서 @MyTest 애노테이션이 있는 메소드 실행
        Method[] methods = clazz.getDeclaredMethods();

        Junit4Test junit4Test = new Junit4Test();
        for(Method method : methods){
            invoke(junit4Test,method);
        }
    }

    private void invoke(Junit4Test junit4Test, Method method) throws Exception{
        if(method.getAnnotation(MyTest.class) != null){
            method.invoke(junit4Test);
        }
    }
}
