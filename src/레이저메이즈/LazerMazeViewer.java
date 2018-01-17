package 레이저메이즈;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.*;

public class LazerMazeViewer extends JPanel implements ChangeListener, MouseListener,MouseMotionListener{
	private LazerMaze lazerMaze=null;
	private Image background=null ;
	private Image[] redToken=new Image[4];
	private Image[] purpleToken=new Image[4];
	private Image[] purplePointedToken=new Image[4];
	private Image[] skyToken=new Image[2];
	private Image blackToken=null;
	private Image[] yellowToken=new Image[2];
	private Image[] greenToken=new Image[2];
	private Image[] level=new Image[20];
	private Image locker=null;
	private Image guide=null;
	private Image success=null;
	private Image tryAgain=null;
	private Image arrow=null;
	private int tempLevelIndex;
	

	
	public LazerMazeViewer(){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		ImageIcon sid =new ImageIcon(LazerMaze.class.getResource("background.png"));
		background=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenRedW.png"));
		redToken[0]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenRedD.png"));
		redToken[1]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenRedS.png"));
		redToken[2]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenRedA.png"));
		redToken[3]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenPurpleW.png"));
		purpleToken[0]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenPurpleD.png"));
		purpleToken[1]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenPurpleS.png"));
		purpleToken[2]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenPurpleA.png"));
		purpleToken[3]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenPurplePointedW.png"));
		purplePointedToken[0]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenPurplePointedD.png"));
		purplePointedToken[1]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenPurplePointedS.png"));
		purplePointedToken[2]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenPurplePointedA.png"));
		purplePointedToken[3]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenBlueW.png"));
		skyToken[0]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenBlueA.png"));
		skyToken[1]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenBlack.png"));
		blackToken=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenYellowW.png"));
		yellowToken[0]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenYellowA.png"));
		yellowToken[1]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenGreenW.png"));
		greenToken[0]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("TokenGreenA.png"));
		greenToken[1]=sid.getImage();
		for(int i=1;i<=20;i++){
			sid =new ImageIcon(LazerMaze.class.getResource(i+".png"));
			level[i-1]=sid.getImage();
		}
		sid =new ImageIcon(LazerMaze.class.getResource("Locked.png"));
		locker=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("Guide.png"));
		guide=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("Success.png"));
		success=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("Tryagain.png"));
		tryAgain=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("arrow.PNG"));
		arrow=sid.getImage();
	}
	
	public void setLazer(LazerMaze lazerMaze){
		lazerMaze.addChangeListener(this);
		if(this.lazerMaze!=null){
			this.lazerMaze.removeChangeListener(this);
		}
		this.lazerMaze = lazerMaze;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(13,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		g2.setColor(Color.BLACK);
	
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Color lazerColor= new Color(242,108,104);
		g2.setColor(lazerColor);
		g.drawImage(background, 0, 0, null);
		
		if(lazerMaze.getStageDrawFlag()==1){
			
			for(int i=0; i<lazerMaze.getTokenManager().getTokenNumber();i++){
				String tempDir=lazerMaze.getTokenManager().getToken(i).getDirection();
				boolean tempRotateable=lazerMaze.getTokenManager().getToken(i).getRotateableFlag();
				
				switch(lazerMaze.getTokenManager().getToken(i).getID()){
				case "R":
					if(tempDir.equals("W"))
							g.drawImage(redToken[0], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null);
					if(tempDir.equals("D"))
							g.drawImage(redToken[1], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null);
					if(tempDir.equals("S"))
							g.drawImage(redToken[2], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null);
					if(tempDir.equals("A"))
							g.drawImage(redToken[3], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null);
					break;
				case "P":
					if(tempDir.equals("W"))
						g.drawImage(purpleToken[0], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); 
					if(tempDir.equals("D"))
						g.drawImage(purpleToken[1], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); 
					if(tempDir.equals("S"))
						g.drawImage(purpleToken[2], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); 
					if(tempDir.equals("A"))
						g.drawImage(purpleToken[3], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); 
					break;
				case "p":
					if(tempDir.equals("W"))
						g.drawImage(purplePointedToken[0], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); 
					if(tempDir.equals("D"))
						g.drawImage(purplePointedToken[1], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null);
					if(tempDir.equals("S"))
						g.drawImage(purplePointedToken[2], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null);
					if(tempDir.equals("A"))
						g.drawImage(purplePointedToken[3], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null);
					break;
				case "S":
					if(tempDir.equals("W")||tempDir.equals("S"))
						g.drawImage(skyToken[0], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); 
					if(tempDir.equals("A")||tempDir.equals("D"))
						g.drawImage(skyToken[1], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); break;
				case "B":
					g.drawImage(blackToken, lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); break;
				case "Y":
					if(tempDir.equals("W")||tempDir.equals("S"))
						g.drawImage(yellowToken[0], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); 
					if(tempDir.equals("A")||tempDir.equals("D"))
						g.drawImage(yellowToken[1], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null);
					break;
				case "G":
					if(tempDir.equals("W")||tempDir.equals("S"))
						g.drawImage(greenToken[0], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null); 
					if(tempDir.equals("A")||tempDir.equals("D"))
						g.drawImage(greenToken[1], lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY(), null);
					break;
				}
				if(tempRotateable==false)
					g.drawImage(locker, lazerMaze.getTokenManager().getToken(i).getX(), lazerMaze.getTokenManager().getToken(i).getY() , null);
			}
			if(lazerMaze.getLevelDrawFlag()==1){
				tempLevelIndex = lazerMaze.getIndex();
				lazerMaze.setLevelDrawFlag(0);
			}
			g.drawImage(level[tempLevelIndex], 520, 850, null);
			g.drawImage(guide, 100, 865, null);
			if(lazerMaze.getClearFlag()==0)g.drawImage(tryAgain, 165, 165, null);
			if(lazerMaze.getClearFlag()==1)g.drawImage(success, 165, 165, null);
		}
		if(lazerMaze.getLazerDrawFlag()==1){
			ArrayList<Integer> allLazerIndex =new ArrayList<Integer>();
			for(int i=0; i<lazerMaze.lazerArrList.size();i++){
						
				for(int j=0;j<lazerMaze.lazerArrList.get(lazerMaze.lazerArrList.size()-i-1).getXArr().size()-1;j++){
					
					int x1=lazerMaze.lazerArrList.get(lazerMaze.lazerArrList.size()-i-1).getindexX(j);
					int y1=lazerMaze.lazerArrList.get(lazerMaze.lazerArrList.size()-i-1).getindexY(j);
					int x2=lazerMaze.lazerArrList.get(lazerMaze.lazerArrList.size()-i-1).getindexX(j+1);
					int y2=lazerMaze.lazerArrList.get(lazerMaze.lazerArrList.size()-i-1).getindexY(j+1);
					allLazerIndex.add(x1);
					allLazerIndex.add(y1);
					allLazerIndex.add(x2);
					allLazerIndex.add(y2);
					//g2.drawLine(x1*90+135, y1*90+365, x2*90+135, y2*90+365);
				}
			}
		
			for(int i=0; i<allLazerIndex.size() ; i++){
				if(i==lazerMaze.getCooltime()*4)return;
				g2.drawImage(arrow, allLazerIndex.get(i+2)*90+121, allLazerIndex.get(i+3)*90+351, null);
				g2.drawLine(allLazerIndex.get(i)*90+135, allLazerIndex.get(i+1)*90+365, allLazerIndex.get(i+2)*90+135, allLazerIndex.get(i+3)*90+365);
				
				i+=3;
			}
			
		}
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		this.repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {	
		lazerMaze.setX(e.getX());
		lazerMaze.setY(e.getY());	
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){			
			lazerMaze.rotate();
		}		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		lazerMaze.setX(e.getX());
		lazerMaze.setY(e.getY());		
		lazerMaze.clicked();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		lazerMaze.released();
	}
}
