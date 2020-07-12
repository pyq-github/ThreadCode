import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public enum TestClass {
    SUN(1),MON(1),TUS(2),WED(3),THU(4),FRI(5),SAT(6);
    private int i;
    private TestClass(int i ){
        this.i = i;
    }

}
class t{
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("java.lang.String");
        String str = (String) clazz.newInstance();
        Constructor cons = clazz.getConstructor(String.class);
        Object obj =cons.newInstance("StringTest");
        Method m = clazz.getDeclaredMethod("toString", String.class);
        m.invoke(obj,"a");
        System.out.println(obj);
    }
}

