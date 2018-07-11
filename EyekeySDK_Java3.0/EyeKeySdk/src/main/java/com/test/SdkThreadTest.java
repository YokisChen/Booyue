
import com.alibaba.fastjson.JSONObject;
import com.eyekey.http.EyeKeyHttp;

public class SdkThreadTest {
    
    public static void main(String[] args) {
        SdkThreadTest t = new SdkThreadTest();
        for(int i = 0;i < 7;i++){
            new Thread(t.new SdkThread()).start();
        }
    }

    public class SdkThread implements Runnable {
        public void run() {
            EyeKeyHttp request = new EyeKeyHttp("000000","000000");
            JSONObject o = request.checkingImgUrl("http://img.bimg.126.net/photo/PB4A4hYW98DuED4pTE5VFg==/5705779252902308357.jpg", null);
            System.out.println(Thread.currentThread().getName() + "------" + o);
        }
    }
}
