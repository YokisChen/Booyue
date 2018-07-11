package com.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eyekey.http.EyeKeyHttp;

import Decoder.BASE64Encoder;

/**
 * 人脸检测的Demo
 * @Title: CheckingDemo.java
 * @Package: com.test
 * @ClassName: CheckingDemo
 * @author Jaylee
 *@date 2015年12月12日 上午10:23:45
 */
public class CheckingDemo {
	
	//待检测图片的网络路径
	private static String imgUrl="http://img2.imgtn.bdimg.com/it/u=3350941610,3792241192&fm=206&gp=0.jpg";
	//待检测图片的本地路径
	private static String imgPath="//Users//chenweiru//Desktop//identify//";

	private static Connection con;

	private static boolean openness=true;

	public static void main(String[] args) {
		connectMysql();
	/*********************第一种方法：通过网络图片的url来进行检测  begin********************/
		//System.out.println("人脸检测信息1："+checkImgByUrl(imgUrl));//
	/*********************第一种方法：通过网络图片的url来进行检测  end**********************/
		
		int i=0;
	/*********************第二种方法：通过本地图片的url来进行检测  begin********************/
		while(true) {
			File img = new File(imgPath+i%100+".jpg");
			while (!img.exists())
			{
				System.out.println(i+"((((((((");
				try{
					Thread.sleep(200);
				}catch(Exception e){
					System.exit(0);//退出程序
				}
			}
			if(img.exists()) {
				//System.out.println("人脸检测信息2：" + i + "((((((" + checkImgBybase64(encodeImgageToBase64(img)));
				String jsonStr = checkImgBybase64(encodeImgageToBase64(img));

				JSONObject json = JSONObject.parseObject(jsonStr);

				if(json.getString("res_code").equals("0000")){

					//System.err.println("两张图片比对的结果为："+getSimilarityByfaceid(face_id1, face_id2));

					}

					System.out.println("闸门开启");
					openness = true;
				}
				else if(openness==true){
					System.out.println("闸门关闭");
					openness = false;
				}

				//System.out.printf("code:%s",json.getString("res_code"));

				int a = 0;
				if (i>=40) {
					a=i-40;
				}
				else a=60+i;
				File file = new File(imgPath+a+".jpg");
				if (file.delete()) {
					System.out.println("删除单个文件" + a + "成功！");
				}
				i=(i+1)%100;
			}

			}


	/*********************第二种方法：通过本地图片的url来进行检测  begin********************/	
	

	
	
	/**
	 * 1.通过网络图片url进行人脸检测
	 * @param url 网络图片地址
	 * @return 人脸检测的json字符串
	 * @author Jaylee
	 */
	public static String checkImgByUrl(String url){
		EyeKeyHttp e=new EyeKeyHttp("e235a3688da641b69f8a1c7e5c49bb96","5b0ffb6f2f884f84ab1f64d7d22d1b83");
		return e.checkingImgUrl(url, null).toJSONString();
	}
	
	/**
	 * 2.通过图片的base64方式进行人脸检测到
	 * @param base64
	 * @return 人脸检测的json字符串
	 * @author Jaylee
	 */
	public static String checkImgBybase64(String base64){
		EyeKeyHttp e=new EyeKeyHttp("e235a3688da641b69f8a1c7e5c49bb96","5b0ffb6f2f884f84ab1f64d7d22d1b83");
		//System.out.println(e.checkingImgB64(base64, null).toJSONString());
		return e.checkingImgB64(base64, null).toJSONString();
	}
	
	
	/**
	 * File文件转base64格式
	 * @param imageFile
	 * @author Jaylee
	 * @return string
	 */
	 public static String encodeImgageToBase64(File imageFile) {
		 
		 ByteArrayOutputStream outputStream = null;
		    try {
		      BufferedImage bufferedImage = ImageIO.read(imageFile);
		      outputStream = new ByteArrayOutputStream();
		      ImageIO.write(bufferedImage, "jpg", outputStream);
		    } catch (MalformedURLException e1) {
		      e1.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    
		    BASE64Encoder encoder = new BASE64Encoder();
		 	//System.out.println(encoder.encode(outputStream.toByteArray()));
		    return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
	}


	/**
	 * 比对两个faceid返回相似值
	 * @param face_id1
	 * @param face_id2
	 * @return 比对结果
	 * @author Jaylee
	 */
	public static String getSimilarityByfaceid(String face_id1,String face_id2){
		EyeKeyHttp e=new EyeKeyHttp();
		return e.matchCompare(face_id1, face_id2).toJSONString();
	}



	public static void connectMysql() {

				//声明Connection对象

				//驱动程序名
				String driver = "com.mysql.jdbc.Driver";
				//URL指向要访问的数据库名mydata
				String url = "jdbc:mysql://qdm171689336.my3w.com:3306/qdm171689336_db?serverTimezone=UTC";
				//MySQL配置时的用户名
				String user = "qdm171689336";
				//MySQL配置时的密码
				String password = "123459876";
				//遍历查询结果集
				try {
					//加载驱动程序
					Class.forName(driver);
					//1.getConnection()方法，连接MySQL数据库！！
					con = DriverManager.getConnection(url,user,password);
					if(!con.isClosed())
						System.out.println("Succeeded connecting to the Database!");

				} catch(ClassNotFoundException e) {
					//数据库驱动类异常处理
					System.out.println("Sorry,can`t find the Driver!");
					e.printStackTrace();
				} catch(SQLException e) {
					//数据库连接失败异常处理
					e.printStackTrace();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}



	public static void get_face() {
		//2.创建statement类对象，用来执行SQL语句！！
		try {
			Statement statement = con.createStatement();
			//要执行的SQL语句
			String sql = "select picture_code from guest";
			//3.ResultSet类，用来存放获取的结果集！！
			ResultSet rs = statement.executeQuery(sql);

			String job = null;
			String id = null;
			while (rs.next()) {
				//获取stuname这列数据
				job = rs.getString("ad_id");
				//获取stuid这列数据
				id = rs.getString("ad_pwd");

				//输出结果
				System.out.println(id + "\t" + job);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			System.out.println("数据库数据成功获取！！");
		}
		//rs.close();
		//con.close();

	}


	}


