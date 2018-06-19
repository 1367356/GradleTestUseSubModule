package chapter08.SecondTime.PuzzleFrameWork;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 10:47
 * 串行的谜题解答器
 **/
public class SequentialPussleSolver<P,M> {
    private final Pullze<P,M> pullze;
    private final Set<P> seen = new HashSet<P>();

    public SequentialPussleSolver(Pullze<P, M> pullze) {
        this.pullze = pullze;
    }

    public List<M> solve() {
        P pos=pullze.initialPosition();
        return search(new Node<P, M>(pos, null, null));
    }

    private List<M> search(Node<P, M> node) {
        if(!seen.contains(node.pos)){
            seen.add(node.pos);
            if (pullze.isGoal(node.pos)) {
                return node.asMoveList();
            }
            for (M move : pullze.legalMoves(node.pos)) {
                P pos = pullze.move(node.pos, move);
                Node<P, M> child = new Node<P,M>(pos, move, node);
                List<M> result = search(child);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

}
