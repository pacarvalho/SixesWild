package main;

import java.net.MalformedURLException;

import javax.swing.JFrame;

import views.Application;
import views.SplashScreenWindow;



public class main {
	
	public static void main(String[] args){
			JFrame frame = new JFrame();
			SplashScreenWindow splash = new SplashScreenWindow(frame);
			Application application = new Application(frame); 
	}

}
