package com.company;

import javax.swing.JFrame;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class capture {
	static OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();


	public static void main(String[] args) throws Exception, InterruptedException{
		 OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
	        grabber.start();   //开始获取摄像头数据
	        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
	        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        canvas.setAlwaysOnTop(true);
	        int ex = 0;
	        while(true)
	        {
	            if(!canvas.isDisplayable())
	            {//窗口是否关闭
	                grabber.stop();//停止抓取
	                System.exit(2);//退出
	                break;
	            }       
	            canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
	            opencv_core.Mat mat = converter.convertToMat(grabber.grabFrame());
	            ex++;
	            //每隔2秒保存一张图片
	            if(ex%5==1) {
	            	opencv_imgcodecs.imwrite("/Users/chenweiru/Desktop/identify/" + (ex/5)%100 + ".jpg", mat);
	            }
	            Thread.sleep(200);//200毫秒刷新一次图像
	        }
	        
	      //关闭接收器
	        grabber.close();
	        
	        canvas.dispose();
	        return;	
	} 
	
}