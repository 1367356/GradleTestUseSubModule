package chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-19 20:42
 * 减少锁的持有时间,  线程安全的类
 **/
public class BetterAttributeStore {
    private final Map<String, String> attributes = new HashMap<String, String>();

    public boolean userLocationMatches(String name, String regexp) {
        String key = "users." + name + ".location";
        String location;
        synchronized (this) {  //缩小同步代码块
            location = attributes.get(key);
        }
        if (location == null) {
            return false;
        }else {
            return Pattern.matches(regexp, location);
        }
    }
}
