package chapter08;

import javafx.scene.Node;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//将串行递归转化为并行递归
public class program8Point11<T> {
    public<T> void sequentialRecursive(List<LinkedList<T>> nodes, Collection<T> results){
        for (LinkedList<T> ll : nodes) {
            results.add(ll.getFirst());
            sequentialRecursive(nodes,results);
        }
    }
}
