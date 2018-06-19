package chapter10;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 21:00
 * 通过锁顺序避免死锁
 **/
public class LoakSortAvoidDeadLock {
    private static final Object tieLock=new Object();//锁对象

    public void transferMoney(final Account account, final Account toAcct, final DollarAmount amount) {
        class Helper{
            public void transfer() {
                if (account.getBalance().compareTo(amount) < 0) {
                    
                }
            }
        }
    }
}
class Account{

    public DollarAmount getBalance(){
        return new DollarAmount();
    }
}
class DollarAmount implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
