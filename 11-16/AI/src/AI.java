import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x,y,LEFTFLAG;
	Image Img,Img1,Img2,Img3,Img4,Img5,Img6,Img7,Img8,Img9,Img10,Img11,currentImg;
	public MainCanvas(){
	  try
	  {
		Img=Image.createImage("/sayo10.png");
		Img1=Image.createImage("/sayo12.png");
		Img2=Image.createImage("/sayo16.png");
		Img3=Image.createImage("/sayo14.png");
		Img4=Image.createImage("/sayo02.png");
		Img5=Image.createImage("/sayo22.png");
		Img6=Image.createImage("/sayo06.png");
		Img7=Image.createImage("/sayo26.png");
		Img8=Image.createImage("/sayo04.png");
		Img9=Image.createImage("/sayo24.png");
		Img10=Image.createImage("/sayo00.png");
		Img11=Image.createImage("/sayo20.png");
		currentImg=Img;
		LEFTFLAG=1;
		x=120;
		y=100;
	  }
	  catch (IOException e)
	  {
		  e.printStackTrace();
	  }

	} 

	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}

	public void keyPressed(int keyCode){
	  int action=getGameAction(keyCode);
	  if(action==LEFT){
		  if(LEFTFLAG==1){
			  currentImg=Img4;
			  LEFTFLAG++;
		  }
		  else if(LEFTFLAG==2){
			  currentImg=Img5;
			  LEFTFLAG=1;
		  }
		  x=x-1;
		  repaint();
	  }
	   else if(action==RIGHT){
		   if(LEFTFLAG==1){
			  currentImg=Img6;
			  LEFTFLAG++;
		  }
		  else if(LEFTFLAG==2){
			  currentImg=Img7;
			  LEFTFLAG=1;
		  }
		  x=x+1;
		  repaint();
	  }
	   else if(action==UP){
		   if(LEFTFLAG==1){
			  currentImg=Img8;
			  LEFTFLAG++;
		  }
		  else if(LEFTFLAG==2){
			  currentImg=Img9;
			  LEFTFLAG=1;
		  }
		  y=y-1;
		  repaint();
	   }
	   else if(action==DOWN){
		   if(LEFTFLAG==1){
			  currentImg=Img10;
			  LEFTFLAG++;
		  }
		  else if(LEFTFLAG==2){
			  currentImg=Img11;
			  LEFTFLAG=1;
		  }
		  y=y+1;
		  repaint();
	   }
	}
} 