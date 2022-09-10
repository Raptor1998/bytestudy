package com.raptor.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/22  18:23
 */
public class NioClient {
    public void start() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(6789));
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NioClientHandler(selector)).start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String request = scanner.nextLine();
            if (request != null && request.length() > 0) {
                socketChannel.write(StandardCharsets.UTF_8.encode(request));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NioClient().start();
    }

    private class NioClientHandler implements Runnable {
        private Selector selector;

        public NioClientHandler(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();

                    Iterator iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = (SelectionKey) iterator.next();
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        StringBuilder response = new StringBuilder();
                        while (socketChannel.read(byteBuffer) > 0) {
                            byteBuffer.flip();
                            response.append(StandardCharsets.UTF_8.decode(byteBuffer));
                        }
                        if (response.length() > 0) {
                            System.out.println("接收服务端消息:" + response);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

