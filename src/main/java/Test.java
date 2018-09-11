import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-07 10:49
 **/
public class Test {

public static void main(String[] args){
    Date date = new Date();
    System.out.println(date);
    Deque deque;//双端队列，工作密取。

    Integer integer;

    HashMap map;
    ConcurrentHashMap concurrentHashMap;

    StringBuffer stringBuffer;

    Selector selector;
    SelectorProvider selectorProvider;
}
}
