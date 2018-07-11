//package com.test;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//
//public class HttpTest {
//    public static void main(String[] args) {
//        testGet();
//    }
//    
////    public static void testPost(){
////        HttpPost httpPost = new HttpPost("http://www.baidu.com");
////        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
////        try {
////            HttpResponse response = httpClient.execute(httpPost);
////            System.out.println(readString(response.getEntity().getContent()));
////        } catch (ClientProtocolException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
////    
//    public static void testGet(){
//        HttpGet httpGet = new HttpGet("http://localhost:8080/jgkdkf");
//        httpGet.addHeader("app_id", "1234567890");
//        httpGet.addHeader("app_key", "0987654321");
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        try {
//            HttpResponse response = httpClient.execute(httpGet);
//            System.out.println(readString(response.getEntity().getContent()));
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    private static String readString(InputStream in) {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        byte[] buf = new byte[1024];
//        int len;
//        byte[] toBuf = null;
//        try {
//            len = in.read(buf);
//            while (len > 0) {
//                out.write(buf, 0, len);
//                len = in.read(buf);
//            }
//            toBuf = out.toByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return new String(toBuf);
//    }
//}
