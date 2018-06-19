package chapter08.SecondTime.PuzzleFrameWork;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 11:04
 **/
public class ConcurrentPuzzleSolver<P,M> {
    private final Pullze<P,M> pullze;
    private final ExecutorService exec;
    private final ConcurrentHashMap<P,Boolean> seen;

    public ConcurrentPuzzleSolver(Pullze<P, M> pullze, ExecutorService exec, ConcurrentHashMap<P, Boolean> seen) {
        this.pullze = pullze;
        this.exec = exec;
        this.seen = seen;
    }

    final ValueLatch<Node<P, M>> solution = new ValueLatch<>();

    public List<M> solve() {
        try {
            P p=pullze.initialPosition();
            exec.execute(newTask(p, null, null));

            //阻塞直到找到解答
            Node<P,M> solnNode=solution.getValue();
            return (solnNode == null)?null:solnNode.asMoveList();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            exec.shutdown();
        }
        return null;
    }

    private Runnable newTask(P p, M o, Node<P,M> o1) {
        return new SolverTask(p, o, o1);
    }

    class SolverTask extends Node<P,M> implements Runnable{


        public SolverTask(P pos, M move, Node<P, M> prev) {
            super(pos, move, prev);
        }

        @Override
        public void run() {
            if (solution.isSet() || seen.putIfAbsent(pos,true)!=null) {
                return;//已经找到了解答或者已经遍历了这个位置
            }
            if(pullze.isGoal(pos))
                solution.setValue(this);
            else
                for (M m:pullze.legalMoves(pos)) {
                    exec.execute(newTask(pullze.move(pos, m), m, this));
                }
        }
    }

}
