package chapter09.sercondTime;

import java.util.concurrent.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 17:55
 *  支持取消，完成通知及进度通知的后台任务类
 **/
public class BackgroundTask<V> implements Runnable,Future<V> {

    private final FutureTask<V> computation = new Computation();

    private class Computation extends FutureTask<V>{

        public Computation() {
            super(new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return BackgroundTask.this.compute();
                }
            });
        }
    }

    protected final void done() {
        GuiExecutor.instance().execute(new Runnable() {
            @Override
            public void run() {
                V value=null;
                Throwable thrown=null;
                boolean cancelled=false;
                try {
                    value = get();
                } catch (ExecutionException e) {
                    thrown = e.getCause();
                } catch (CancellationException e) {
                    cancelled=true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    onCompletion(value, thrown, cancelled);
                }
            }
        });
    }

    protected void setProgress(final int current, final int max) {
        GuiExecutor.instance().execute(new Runnable() {
            @Override
            public void run() {
                onProgress(current, max);
            }
        });
    }

    /**
     * 进度条
     * @param current
     * @param max
     */
    private void onProgress(int current, int max) {

    }

    /**
     * 在事件线程中被取消
     * @param value
     * @param thrown
     * @param cancelled
     */
    private void onCompletion(V value, Throwable thrown, boolean cancelled) {

    }
    //在后台线程中被取消
    private V compute() {

        return null;
    }

    @Override
    public void run() {

    }

    @Override
    public boolean cancel(boolean b) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public V get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
