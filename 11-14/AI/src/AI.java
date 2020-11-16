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
	Image DOWNImg,LEFTImg,RIGHTmg,UPImg,currentImg;
	public MainCanvas(){
	  try
	  {
		DOWNImg=Image.createImage("/sayo10.png");
		LEFTImg=Image.createImage("/sayo12.png");
		RIGHTImg=Image.createImage("/sayo16.png");
		UPImg=Image.createImage("/sayo14.png");
		currentImg=DOWNImg;
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
		g.drawImage(currentImg,120,100,0);
	}

	public void keyPressed(int keyCode){
	  int action=getGameAction(keyCode);
	  if(action==LEFT){
	   currentImg=LEFTImg;/*移动一个像素*/
	   System.out.println("向左转");
	   repaint();
	  }
	   else if(action==RIGHT){
	   currentImg=RIGHTImg;
	   System.out.println("向右转");
	   repaint();
	  }
	   else if(action==UP){
	   currentImg=UPImg;
	   System.out.println("向上转");
	   repaint();
	   }
	   else if(action==DOWN){
	   currentImg=DOWNImg;
	   System.out.println("向下转");
	   repaint();
	   }
	}
}