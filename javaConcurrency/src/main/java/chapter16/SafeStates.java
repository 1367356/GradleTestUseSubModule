package chapter16;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-21 08:26
 * 不可变对象的初始化安全性
 **/
public class SafeStates {
    private final Map<String,String> states;

    public SafeStates() {
        states=new HashMap<String, String>();  //构造函数中初始化
        states.put("key1", "value1");
        states.put("key2", "value2");
    }

    public String getAbbreviation(String s) {
        return states.get(s);
    }
}
