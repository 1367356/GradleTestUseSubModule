package chapter08.SecondTime.class5;

import chapter06.Executor;
import org.w3c.dom.NodeList;

import javax.xml.bind.Element;
import java.util.Collection;
import java.util.List;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 10:16
 * 递归算法的并行化
 **/
public class RecuriveAlgorithmToParaller {
    /**
     * 串行运算
     * @param elements 待处理的元素
     */
    public void processSequentially(List<Element> elements) {
        for (Element e : elements) {
            //process(e);
        }
    }

    /**
     * 将待处理的任务交给executor，将串行运算转为并行运算
     * @param exec
     * @param elements
     */
    public void processInParallel(Executor exec, List<Element> elements) {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                //process(e);
            }
        });
    }

    //将串行递归转换为并行递归
    public <T> void sequentialRecursive(NodeList nodes, Collection<T> result) {
//        for (Node n : nodes.item(1)) {
////            result.add();
//            sequentialRecursive(n.getChildNodes(),result);
//        }
    }


}
