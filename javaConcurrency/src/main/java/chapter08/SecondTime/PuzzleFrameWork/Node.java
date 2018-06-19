package chapter08.SecondTime.PuzzleFrameWork;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 10:42
 **/
public class Node<P,M> {
    final P pos;
    final M move;
    final Node<P,M> prev;

    public Node(P pos, M move, Node<P, M> prev) {
        this.pos = pos;
        this.move = move;
        this.prev = prev;
    }

    List<M> asMoveList() {
        List<M> solution = new LinkedList<M>();
        for (Node<P,M> n=this;n.move!=null;n=n.prev) {
            solution.add(0,n.move);
        }
        return solution;
    }
}
