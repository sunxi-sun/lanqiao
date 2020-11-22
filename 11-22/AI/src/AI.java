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
	Image  heroImg[][]=new Image[4][3];//四个方向，每个方向3张图片，0是left，1是right，2是up，2是down
	Image currentImg;


	public MainCanvas(){
	  try
	  {
		  for(int i=0;i<heroImg.length;i++){
			  for(int j=0;j<heroImg[i].length;j++){
				  heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			  }
		  }
		currentImg=heroImg[3][1];

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
			  currentImg=heroImg[0][0];
			  LEFTFLAG++;
		  }
		  else if(LEFTFLAG==2){
			  currentImg=heroImg[0][2];
			  LEFTFLAG=1;
		  }
		  x=x-1;
		  repaint();
	  }
	   else if(action==RIGHT){
		   if(RIGHTFLAG==1){
			  currentImg=heroImg[1][0];
			  RIGHTFLAG++;
		  }
		  else if(RIGHTFLAG==2){
			  currentImg=heroImg[1][2];
			  RIGHTFLAG=1;
		  }
		  x=x+1;
		  repaint();
	  }
	   else if(action==UP){
		   if(UPFLAG==1){
			  currentImg=heroImg[2][0];
			  UPFLAG++;
		  }
		  else if(UPFLAG==2){
			  currentImg=heroImg[2][2];
			  UPFLAG=1;
		  }
		  y=y-1;
		  repaint();
	   }
	   else if(action==DOWN){
		   if(DOWNFLAG==1){
			  currentImg=heroImg[3][0];
			  DOWNFLAG++;
		  }
		  else if(DOWNFLAG==2){
			  currentImg=heroImg[3][2];
			  DOWNFLAG=1;
		  }
		  y=y+1;
		  repaint();
	   }
	}
} 