package com.eyekey.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
* @Title: Configuratiion.java
* @Package: com.eyekey.conf
* @ClassName: Configuratiion 
* @Description: 配置文件读取类
* @author zhangxinlei 
* @date 2015年1月6日 下午4:23:11 
*
 */
public class Configuration {

    private static Properties prop;

    static {
        prop = new Properties();
        try {
            InputStream in = Configuration.class.getResourceAsStream("/eyekey.properties");
            if (in == null) {
                System.out.println("can not find eyekey.properties file!");
            } else {
                prop.load(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * 返回一个string value
    * @param key
    * @return
    * @Since 2015年1月6日
     */
    public static String getString(String key) {
        return prop.getProperty(key);
    }
    
    /**
    * 返回一个int value
    * @param key
    * @return
    * @Since 2015年1月6日
     */
    public static int getInt(String key) {
        String sval = prop.getProperty(key);

        if (sval != null && !sval.equals("")) {
            int val = Integer.parseInt(sval);
            return val;
        }

        return -1;
    }
}
