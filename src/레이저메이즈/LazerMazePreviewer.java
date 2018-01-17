package 레이저메이즈;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LazerMazePreviewer extends JPanel implements ChangeListener{
	private LazerMaze lazerMaze=null;
	private Image previewLogo=null ;
	private Image[] problemCard = new Image[20];
	private Image[] solutionCard = new Image[20];
	private boolean showingState=false;
	public LazerMazePreviewer(){
		ImageIcon sid ;
		for(int i=1;i<=9;i++){
			sid =new ImageIcon(LazerMaze.class.getResource("Card0"+i+".png"));
			problemCard[i-1]=sid.getImage();
			sid =new ImageIcon(LazerMaze.class.getResource("Solution0"+i+".png"));
			solutionCard[i-1]=sid.getImage();
		}
		for(int i=0;i<=9;i++){
			sid =new ImageIcon(LazerMaze.class.getResource("Card1"+i+".png"));
			problemCard[i+9]=sid.getImage();
			sid =new ImageIcon(LazerMaze.class.getResource("Solution1"+i+".png"));
			solutionCard[i+9]=sid.getImage();
		}
		sid =new ImageIcon(LazerMaze.class.getResource("Card20.png"));
		problemCard[19]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("Solution20.png"));
		solutionCard[19]=sid.getImage();
		sid =new ImageIcon(LazerMaze.class.getResource("Preview.PNG"));
		previewLogo=sid.getImage();
	}
	
	public void setLazer(LazerMaze lazerMaze){
		lazerMaze.addChangeListener(this);
		if(this.lazerMaze!=null){
			this.lazerMaze.removeChangeListener(this);
		}
		this.lazerMaze = lazerMaze;
	}
	public void setShowingState(boolean t) {showingState=t;}
	public boolean getShowingState() {return showingState;}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int index=lazerMaze.getIndex();
		if(showingState==false){
			g.drawImage(problemCard[index], 0, 0, null);
			g.drawImage(previewLogo, 0,0,null);
		}
		else g.drawImage(solutionCard[index], 0, 0, null);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		this.repaint();
	}
}