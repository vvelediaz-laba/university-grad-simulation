package com.solvd.universitygradsimulation.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private final int poolSize;
    private final BlockingQueue<Connection> connections;

    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new LinkedBlockingQueue<>(poolSize);
        this.initializePool();
    }

    public static ConnectionPool create(int poolSize) {
        return new ConnectionPool(poolSize);
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connections.offer(connection);
        }
    }

    private void initializePool() {
        for (int i = 0; i < poolSize; i++) {
            connections.offer(createConnection());
        }
    }

    private Connection createConnection() {
        // Create a new connection object
        return new Connection();
    }
}

