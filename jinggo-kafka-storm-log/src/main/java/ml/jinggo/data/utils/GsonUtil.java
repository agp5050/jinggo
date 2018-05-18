package ml.jinggo.data.utils;

import com.google.gson.Gson;
/**
 * GsonUtil类
 */
public class GsonUtil {
    // 实例化Gson类
    private static Gson gson = new Gson();
    // 将对象转换成 String类型
    public static String in(Object pojo){
        return gson.toJson(pojo);
    }
    // 将String 类型转换成Obejcet
    public static Object out(String json,Class clazz){
        return gson.fromJson(json,clazz);
    }
}
