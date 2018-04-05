package chapter05.class6;

/**
 * 定义一个参数转换接口
 * @param <K>  被转换参数
 * @param <V>  转换参数
 */
public interface Computable<V,K> {
    V compute(K arg) throws InterruptedException;
}
