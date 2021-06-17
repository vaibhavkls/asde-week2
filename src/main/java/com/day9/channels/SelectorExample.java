package com.day9.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

public class SelectorExample {
    public static void main(String[] args) throws IOException {
        // Get selector
        Selector selector = Selector.open();
        System.out.println("Selector open: " + selector.isOpen());
        // Get server socket channel and register with selector
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 5454);
        serverSocket.bind(hostAddress);
        serverSocket.configureBlocking(false);
        int ops = serverSocket.validOps();
        SelectionKey selectKey = serverSocket.register(selector, ops, null);
        for (;;) {
            System.out.println("Waiting for select...");
            int noOfKeys = selector.select();
            System.out.println("Number of selected keys: " + noOfKeys);
            Set selectedKeys = selector.selectedKeys();
            Iterator iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                if (key.isAcceptable()) {
                    // Accept the new client connection
                    SocketChannel client = serverSocket.accept();
                    client.configureBlocking(false);
                    // Add the new connection to the selector
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("Accepted new connection from client: " + client);
                } else if (key.isReadable()) {
                    // Read the data from client
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);
                    String output = new String(buffer.array()).trim();
                    System.out.println("Message read from client: " + output);
                    if (output.equals("Bye.")) {
                        client.close();
                        System.out.println("Client messages are complete; close.");
                    }
                }
                iterator.remove();
            }
        }
    }
}
