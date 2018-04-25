package chapter07;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator implements Runnable{

    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;
    @Override
    public void run() {
        BigInteger p=BigInteger.ONE;
        while (!cancelled){
            p=p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled=true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    public List<BigInteger> aSecondOfPrimes() throws InterruptedException{
        PrimeGenerator primeGenerator=new PrimeGenerator();
        Thread thread = new Thread(primeGenerator);
        thread.start();

        try{
            Thread thread1 = Thread.currentThread();

            Thread.sleep(1);
        }catch (Exception e){

        }finally {
            primeGenerator.cancel();
        }

        return primes;
    }
}
