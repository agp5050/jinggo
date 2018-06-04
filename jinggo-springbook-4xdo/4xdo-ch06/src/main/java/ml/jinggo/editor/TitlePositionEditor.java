package ml.jinggo.editor;

import java.beans.PropertyEditorSupport;

/**
 * @author wangyj
 * @description
 * @create 2018-06-01 14:22
 **/
public class TitlePositionEditor extends PropertyEditorSupport {

    private String[] options = {"Left","Center","Right"};

    //代表属性初始化值的字符串
    @Override
    public String getJavaInitializationString() {
        return "" + getValue();
    }

    //将内部属性值转化为对应的字符串表示形式，供属性编辑器显示之用
    @Override
    public String getAsText() {
       int value = (int) getValue();
       return options[value];
    }

    //将外部设置的字符串转为内部属性的值
    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        for (int i = 0; i < options.length; i++) {
            if(options[i].equals(s)){
                setValue(i);
                return;
            }
        }
    }

    //代表可选属性值的字符串标识数组
    @Override
    public String[] getTags() {
        return options;
    }
}
