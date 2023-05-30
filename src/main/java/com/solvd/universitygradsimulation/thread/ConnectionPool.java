package com.solvd.universitygradsimulation.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static ConnectionPool connectionPool;

    private final int poolSize;
    private final BlockingQueue<Connection> connections;
    private final Set<Connection> initializedConnections;

    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new LinkedBlockingQueue<>(poolSize);
        this.initializedConnections = new HashSet<>();
    }

    public synchronized static ConnectionPool getInstance(int poolSize) {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool(poolSize);
        }
        return connectionPool;
    }

    public synchronized Connection getConnection() throws InterruptedException {
        Connection connection = connections.poll();
        if (connection == null) {
            if (initializedConnections.size() < poolSize) {
                connection = createConnection();
                initializedConnections.add(connection);
            } else {
                connection = connections.take();
            }
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null && initializedConnections.contains(connection)) {
            connections.offer(connection);
        }
    }

    private Connection createConnection() {
        // Create a new connection object
        return new Connection();
    }
}


