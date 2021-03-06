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
	int x,y;
	int LEFTFLAG,RIGHTFLAG,UPFLAG,DOWNFLAG;

	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
	Image currentImg;

	public MainCanvas(){
	  try
	  {
		  //��
		  for(int i=0;i<heroLeftImg.length;i++){
			  heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
		  }
		  //��
		   for(int i=0;i<heroRightImg.length;i++){
			  heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
		  }
		  //��
		  for(int i=0;i<heroUpImg.length;i++){
			  heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
		  }
		  //��
		  for(int i=0;i<heroDownImg.length;i++){
			  heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
		  }
		currentImg=heroDownImg[1];

		LEFTFLAG=1;
		RIGHTFLAG=1;
		UPFLAG=1;
		DOWNFLAG=1;

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
			  currentImg=heroLeftImg[0];
			  LEFTFLAG++;
		  }
		  else if(LEFTFLAG==2){
			  currentImg=heroLeftImg[2];
			  LEFTFLAG=1;
		  }
		  x=x-1;
		  repaint();
	  }
	   else if(action==RIGHT){
		   if(RIGHTFLAG==1){
			  currentImg=heroRightImg[0];
			  RIGHTFLAG++;
		  }
		  else if(RIGHTFLAG==2){
			  currentImg=heroRightImg[2];
			  RIGHTFLAG=1;
		  }
		  x=x+1;
		  repaint();
	  }
	   else if(action==UP){
		   if(UPFLAG==1){
			  currentImg=heroUpImg[0];
			  UPFLAG++;
		  }
		  else if(UPFLAG==2){
			  currentImg=heroUpImg[2];
			  UPFLAG=1;
		  }
		  y=y-1;
		  repaint();
	   }
	   else if(action==DOWN){
		   if(DOWNFLAG==1){
			  currentImg=heroDownImg[0];
			  DOWNFLAG++;
		  }
		  else if(DOWNFLAG==2){
			  currentImg=heroDownImg[2];
			  DOWNFLAG=1;
		  }
		  y=y+1;
		  repaint();
	   }
	}
} 