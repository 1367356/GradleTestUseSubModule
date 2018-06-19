package com.li.chapter08;


import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class InvokeDynamicTest {
    public static void main(String[] args) throws Throwable {
        INDY_BootstrapMethod().invokeExact("icyfenix");
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(lookup(), "testmethod", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));

        return cs.dynamicInvoker();
    }

    private static MethodHandle MH_BootstrapMethod() {
        return null;
    }
}
