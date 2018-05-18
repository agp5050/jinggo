package ml.jinggo.data.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
/**
 * KryoUtil类，对对象进行序列化和反序列化
 */
public class KryoUtil {
    static Kryo kryo = new Kryo();

    public static byte[] in(Object object) {
        Output output = new Output(1, 4096);
        kryo.writeObject(output, object);
        byte[] b = output.toBytes();
        output.flush();
        output.close();
        return b;
    }

    public static Object out(byte[] b,Object object) {
        Input input = new Input(b);
        Object res = kryo.readObject(input,object.getClass());
        return res;
    }
}
