package ml.jinggo.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author wangyj
 * @description
 * @create 2018-05-28 18:07
 **/
public class FileSourceExample {

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\Hua\\Sources\\jinggo\\jinggo-springbook-4xdo\\4xdo-ch03\\src\\main\\resources\\conf\\file1.txt";

        // 1.使用系统文件路径方式加载文件
        WritableResource res1 = new PathResource(filePath);
        // 2.使用类路径方式加载文件
        Resource res2 = new ClassPathResource("conf/file1.txt");

        OutputStream stream1 = res1.getOutputStream();
        stream1.write("欢迎光临\n小春论坛".getBytes());
        stream1.close();

        InputStream ins1 = res1.getInputStream();
        InputStream ins2 = res2.getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int i;
        while((i=ins1.read())!=-1){
            baos.write(i);
        }
        System.out.println(baos.toString());


        System.out.println("res1:"+res1.getFilename());
        System.out.println("res2:"+res2.getFilename());
    }
}
