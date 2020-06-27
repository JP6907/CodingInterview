package com.jp.Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NIO {

    //服务器端通过 SelectionKey（选择键）获取到 SocketChannel（通道），
    // 而通道都注册到 Selector（选择器）上，所有的客户端都可以获得对应的通道，
    // 而不是所有客户端都排队堵塞等待一个服务器连接，这样就实现多路复用的效果了。
    // 多路指的是多个通道（SocketChannel），而复用指的是一个服务器端连接重复被不同的客户端使用。
    //多路复用
    public static void NIOTest(){
        int port = 6666;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Selector selector = Selector.open();
                     ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();){
                    serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(),port));
                    serverSocketChannel.configureBlocking(false);
                    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                    while (true){
                        selector.select();  //阻塞等待就绪的Channel
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()){
                            SelectionKey key = iterator.next();
                            try (SocketChannel channel = ((ServerSocketChannel)key.channel()).accept()){
                                channel.write(Charset.defaultCharset().encode("你好····"));
                            }
                            iterator.remove();
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //客户端1，接受信息并打印
                try (Socket cSocket = new Socket(InetAddress.getLocalHost(), port)) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                    bufferedReader.lines().forEach(s -> System.out.println("客户端 1 打印：" + s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //客户端1，接受信息并打印
                try (Socket cSocket = new Socket(InetAddress.getLocalHost(), port)) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                    bufferedReader.lines().forEach(s -> System.out.println("客户端 2 打印：" + s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //AIO（Asynchronous IO）测试，实现异步非堵塞 IO
    public static void AIOTest() throws IOException, ExecutionException, InterruptedException {
        int port = 8888;
        new Thread(new Runnable() {
            @Override
            public void run() {
                AsynchronousChannelGroup group = null;
                try {
                    group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(4));
                    AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                    server.accept(null, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
                        @Override
                        public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
                            server.accept(null, this); // 接收下一个请求
                            try {
                                Future<Integer> f = result.write(Charset.defaultCharset().encode("Hi, 老王"));
                                f.get();
                                System.out.println("服务端发送时间：" + DateFormat.getDateTimeInstance().format(new Date()));
                                result.close();
                            } catch (InterruptedException | ExecutionException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {
                        }
                    });
                    group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Socket 客户端
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future<Void> future = client.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
        future.get();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        client.read(buffer, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println("客户端打印：" + new String(buffer.array()));
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(10 * 1000);
    }

    public static void main(String[] agrs) throws InterruptedException, ExecutionException, IOException {
        //NIOTest();
        AIOTest();
    }
}
