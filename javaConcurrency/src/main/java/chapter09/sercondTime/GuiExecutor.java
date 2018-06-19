package chapter09.sercondTime;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 16:14
 * 基于SwingUnitilies构建的Executor
 *
 **/
public class GuiExecutor extends AbstractExecutorService {

    /**
     * 采用单例模式构建实例
     */
    private static final GuiExecutor instance=new GuiExecutor();

    public GuiExecutor() {
    }

    public static GuiExecutor instance() {
        return instance;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        return false;
    }

    /**
     * 将任务委托给 SwingUnities
     * @param runnable
     */
    public void execute(Runnable runnable) {

        if (SwingUtilities.isEventDispatchThread()) {
            runnable.run();
        }else {
            SwingUtilities.invokeLater(runnable);
        }
    }
}
