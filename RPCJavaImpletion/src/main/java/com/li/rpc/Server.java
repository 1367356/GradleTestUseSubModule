package com.li.rpc;

import java.io.IOException;

/**
 * 服务中心代码的实现
 */
public interface Server {
    public void stop();

    public void start() throws IOException;

    public void register(Class ServiceInterface, Class Impl);

    public boolean isRunning();

    public int getPort();
}
