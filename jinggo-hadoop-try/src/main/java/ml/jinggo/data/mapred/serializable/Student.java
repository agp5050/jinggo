package ml.jinggo.data.mapred.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wangyj
 * @description
 * @create 2018-05-22 18:31
 **/
public class Student implements Serializable {

    //属性
    private int stuID;
    private String stuName;

    public Student(){

    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public static void main(String[] args) throws Exception {
        // 创建一个学生对象
        Student s1 = new Student();
        s1.setStuID(1);
        s1.setStuName("Tom");

        //构造一个输出流
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:\\temp\\student.1"));
        out.writeObject(s1);

        out.close();

    }
}
