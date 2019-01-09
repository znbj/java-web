package com.itheima;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Server {
    public static void main(String[] args) throws IOException {
        //创建serversocket
        ServerSocket serverSocket = new ServerSocket();
        //绑定到80端口
        serverSocket.bind(new InetSocketAddress(80));
        while (true){
            //接受请求
            Socket cs = serverSocket.accept();
            //客户端带过来的流
            InputStream in = cs.getInputStream();
            //服务器响应内容
            OutputStream out = cs.getOutputStream();
            BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
            //第一行是请求行
            String requestLine=inReader.readLine();
            String method = requestLine.split(" ")[0];
            Map<String, String> requestHeaders=null;
            if("GET".equalsIgnoreCase(method)){
                System.out.println("get请求");
                requestHeaders= get(inReader);
            }else{
                System.out.println("post请求");
                requestHeaders=post(inReader);
            }
            //根据不同请求方式  解析出来 请求带过来数据
            System.out.println(requestHeaders);







            String responseContent="你好";
            StringBuffer response=new StringBuffer();
            response.append("HTTP/1.1 200 OK\r\n");
            response.append("Content-Type: text/html;charset=utf-8\r\n");
            response.append("Date: ").append(new Date().toLocaleString()+"\r\n");
            response.append("Content-Length: ").append(responseContent.getBytes("utf-8").length+"\r\n");
            response.append("\r\n");
            //响应体
            response.append(responseContent);

            out.write(response.toString().getBytes("utf-8"));
            out.close();
            in.close();
        }
    }

    private static Map<String,String> get(BufferedReader inReader) throws IOException {
        //
        Map<String,String> result=new HashMap<>();
        String s=null;
        while ((s = inReader.readLine())!=null){
            //一行行解析请求头
            if(s.equals("")){
                //如果是get请求 读取到这里也就结束了
                return result;
            }
            String[] split = s.split(": ");
            result.put(split[0],split[1]);
        }
        return result;
    }

    private static Map<String,String> post(BufferedReader inReader) throws IOException {
        Map<String,String> result=new HashMap<>();
        String s=null;
        while ((s = inReader.readLine())!=null){
            //一行行解析请求头
            if(s.equals("")){
                //如果是post请求 读取到这里也就结束了 紧接着也就是 请求体了
                //那么此时 请求头中 必然已经包含了 数据长度了
                int length =Integer.parseInt( result.get("Content-Length"));
                //这时候我们就不要读取行了
                char[] bytes = new char[length];
                inReader.read(bytes);
                String requestBody = new String(bytes);
                result.put("requestBody",requestBody);
                return result;
            }else{
                String[] split = s.split(": ");
                result.put(split[0],split[1]);
            }
        }
        return result;

    }
}
