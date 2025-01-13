package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;
    private ConnectionPool instance = ConnectionPool.getInstance();

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        this.realConnection.close();
    }

    @Override
    public void close() {
        instance.releaseConnection(this.realConnection);
    }

    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }
    // Implement methods here!
}
