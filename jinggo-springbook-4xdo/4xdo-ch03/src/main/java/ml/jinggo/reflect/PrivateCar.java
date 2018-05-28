package ml.jinggo.reflect;

/**
 * @author wangyj
 * @description
 * @create 2018-05-28 15:58
 **/
public class PrivateCar {

    private String color;

    protected void drive(){
        System.out.println("drive private car! the color is " + color);
    }
}
