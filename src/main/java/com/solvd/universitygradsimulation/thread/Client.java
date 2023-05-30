package com.solvd.universitygradsimulation.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        final Integer POOL_SIZE = 5;
        ConnectionPool connectionPool = ConnectionPool.getInstance(POOL_SIZE);
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        List<CompletableFuture<Connection>> connectionFutures = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            int finalI = i+1;
            CompletableFuture<Connection> connectionFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    Connection connection = connectionPool.getConnection();

                    connection.establish(new Integer(finalI).toString());
                    Thread.sleep(1000);
                    connection.release(new Integer(finalI).toString());

                    connectionPool.releaseConnection(connection);
                    return connection;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            }, executorService);
            connectionFutures.add(connectionFuture);
        }

        CompletableFuture<Void> allConnectionsFuture = CompletableFuture.allOf(
                connectionFutures.toArray(new CompletableFuture[0]));

        allConnectionsFuture.thenRun(() -> {
            System.out.println("All connections have been processed.");
            executorService.shutdown();
        });

        try {
            allConnectionsFuture.get(); // Wait for all connections to complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

