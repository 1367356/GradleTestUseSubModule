package chapter14;

//状态依赖方法的标准形式
public class Program14Point7 {
    void stateDependentMethod() throws InterruptedException {
        //必须通过一个锁来保护条件谓词
        synchronized (this) {
//            while(!conditionPredicate()){
//                lock.wait();
//            }
            //现在对象处于合适的状态。
        }
    }
}
