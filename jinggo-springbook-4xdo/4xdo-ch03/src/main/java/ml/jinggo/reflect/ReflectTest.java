package ml.jinggo.reflect;

import ml.jinggo.domain.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author wangyj
 * @description
 * @create 2018-05-28 11:30
 **/
public class ReflectTest {

    public static Car initByDefaultConst() throws Exception {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("ml.jinggo.domain.Car");

        Constructor cons = clazz.getDeclaredConstructor((Class<?>[]) null);
        Car car = (Car) cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"红旗CA72");
        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,200);
        return car;
    }

    public static void main(String[] args) throws Exception {
        Car car = initByDefaultConst();
        car.introduce();

        System.out.println("=============================================");

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:" + loader);
        System.out.println("parent loader:" + loader.getParent());
        System.out.println("3 loader:" + loader.getParent().getParent());
    }
}
