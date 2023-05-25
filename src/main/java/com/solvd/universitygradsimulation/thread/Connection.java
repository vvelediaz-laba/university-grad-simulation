package com.solvd.universitygradsimulation.thread;

public class Connection {
    private boolean isConnected;

    public Connection() {
        this.isConnected = false;
    }

    public void establish(String name) {
        isConnected = true;
        System.out.println("Connection established for " + name + " ...");
    }

    public void release(String name) {
        isConnected = false;
        System.out.println("Connection released for " + name + " ...");
    }

    public boolean isValid() {
        return isConnected;
    }
}

