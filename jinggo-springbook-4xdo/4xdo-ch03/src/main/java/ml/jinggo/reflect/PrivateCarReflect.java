package ml.jinggo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wangyj
 * @description
 * @create 2018-05-28 17:28
 **/
public class PrivateCarReflect {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("ml.jinggo.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar) clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        //取消java 语言访问检查以访问private 变量
        colorFld.setAccessible(true);
        colorFld.set(pcar,"红色");

        Method drivedMtd = clazz.getDeclaredMethod("drive",null);

        //取消java 语言检查访问protected方法
        drivedMtd.setAccessible(true);
        drivedMtd.invoke(pcar,null);
    }
}
