package com.li.MyProxyPattern;

import java.lang.reflect.Method;

public interface InvocationHandler {
    Object invoke(Object var1, Method var2, Object[] var3) throws Throwable;
}
