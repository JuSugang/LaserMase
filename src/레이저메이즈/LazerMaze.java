package 레이저메이즈;


import java.util.ArrayList;



import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LazerMaze implements Runnable{

	private int index=-1;
	private ArrayList<Card> cardList;
	private TokenManager manager= null;
	private LazerMazeViewer viewer=null;
	private Card card=null;
	private Lazer lazer=null;
	
	private String tempDir=null;
	private int x,y;
	private int movesw=0;
	private int selectsw=0;
	private int stageDrawFlag=0;
	private int kx,ky;
	private int tokenIndex=0;
	private int returnX,returnY;
	private int clearFlag=-1;
	private int lazerDrawFlag=-1;
	private int hitNumber=0;
	private int tokenhitCount=0;
	private int tempTokenHitCount=0;
	private int levelDrawFlag=0;
	private int cooltime=0;
	
	private ArrayList<ChangeListener> listeners;
	ArrayList<Lazer> lazerArrList;
	public LazerMaze(Reader r){
		cardList=r.getCardList();
		listeners = new ArrayList<ChangeListener>();
		lazerArrList = new ArrayList<Lazer>();
	}
	
	public void setLevelDrawFlag(int flag) {levelDrawFlag=flag;}
	public void setLazerDrawFlag(int flag) {lazerDrawFlag=flag;}
	public void setX(int x) {this.x=x;}
	public void setY(int y) {this.y=y;}
	public void setIndex(int num) {index=num-1;}	//stage는 1부터 시작한다.
	public void setViewer(LazerMazeViewer viewer) {this.viewer=viewer;}
	public void setStage(){
		selectsw=1;
		stageDrawFlag=1;
		card=cardList.get(index);
		manager= new TokenManager(card);
		
		tokenhitCount=manager.getTokenNumber()-1;//빨간토큰 제외
		for(int i=0; i<manager.getTokenNumber(); ++i){		
			if(manager.getToken(i).getID().equals("p")||manager.getToken(i).getID().equals("S")||manager.getToken(i).getID().equals("B"))			
				tokenhitCount--;
		}		
		viewer.repaint();
	}
	
	public int getLevelDrawFlag() {return levelDrawFlag;}
	public TokenManager getTokenManager() {return manager;}	
	public int getStageDrawFlag(){return stageDrawFlag;}
	public int getIndex() {return index;}
	public int getLazerDrawFlag() {return lazerDrawFlag;}
	public void clicked(){
		if(selectsw==0)return;	//select 누르기 전엔 좌표를 받지 않음
		
		for(int i=0; i<manager.getTokenNumber(); ++i){
			if(manager.getToken(i).getMoveableFlag()==true){	//moveable이 Y인 토큰만 움직임
				if(x>=manager.getToken(i).getX() && x<manager.getToken(i).getX()+90 && y>=manager.getToken(i).getY() && y<manager.getToken(i).getY()+90){					
					movesw=1;
					returnX=manager.getToken(i).getX(); //바로 이전 토큰의 위치
					returnY=manager.getToken(i).getY();
					kx=x-manager.getToken(i).getX();	//마우스와 토큰의 간격
					ky=y-manager.getToken(i).getY();
					tokenIndex=i;		//클릭된 토큰 인덱스 정보
					break;
				}
			}
		}
	}
	public void released(){
		if(movesw==1){
			if(x<95||x>540||y<320||y>770){
				manager.getToken(tokenIndex).setX(returnX);
				manager.getToken(tokenIndex).setY(returnY);
			}
			else{
				int tempX,tempY;
				tempX=manager.getToken(tokenIndex).getX()+kx;	//현재 토큰의 왼쪽 위 좌표를 받아옴
				tempY=manager.getToken(tokenIndex).getY()+ky;
				if(tempX<184)
					tempX=95;
				else if(tempX<273)
					tempX=184;
				else if(tempX<362)
					tempX=273;
				else if(tempX<451)
					tempX=362;
				else
					tempX=451;
				if(tempY<410)
					tempY=320;
				else if(tempY<500)
					tempY=410;
				else if(tempY<590)
					tempY=500;
				else if(tempY<680)
					tempY=590;
				else
					tempY=680;
				
				boolean collisionflag=false;

				for(int j=0;j<manager.getTokenNumber();j++){
					if(j!=tokenIndex){
						if((tempX-95)/89==(manager.getToken(j).getX()-90)/90 && (tempY-320)/90==(manager.getToken(j).getY()-320)/90){
							collisionflag=true;
						}
					}
				}				
				if(collisionflag==true){
					manager.getToken(tokenIndex).setX(returnX);
					manager.getToken(tokenIndex).setY(returnY);
					collisionflag=false;
				}
				else{
					manager.getToken(tokenIndex).setX(tempX);
					manager.getToken(tokenIndex).setY(tempY);
				}
			}
		}
		this.movesw=0;
		viewer.repaint();
	}
	public void move(int tokenIndex){
		manager.getToken(tokenIndex).setX(x-kx);
		manager.getToken(tokenIndex).setY(y-ky);
		viewer.stateChanged(new ChangeEvent(this));
	}
		
	@Override
	public void run() {
	int cooltimeHelper =0;
		while(true){
			if(movesw==1 )
				this.move(tokenIndex);
			viewer.repaint();
			if(cooltimeHelper==20){
				cooltime++;
				cooltimeHelper=0;
			}
			else{
				cooltimeHelper++;
			}
			try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
		}
	}	

	public void rotate() {
		for(int i=0; i<manager.getTokenNumber(); ++i){
			if(x>=manager.getToken(i).getX() && x<manager.getToken(i).getX()+90 && y>=manager.getToken(i).getY() && y<manager.getToken(i).getY()+90){
				
				if(manager.getToken(i).getRotateableFlag()==true){
					switch(manager.getToken(i).getDirection()){
					case "W":
						manager.getToken(i).setDirection("D");break;
					case "D":
						manager.getToken(i).setDirection("S");break;
					case "S":
						manager.getToken(i).setDirection("A");break;
					case "A":
						manager.getToken(i).setDirection("W");break;
					}
					viewer.repaint();
				}
				break;
			}
		}
	}
	
	public String getTempDir() {return tempDir;}
	public void setTempDir(String dir) {tempDir=dir;}
	public int getClearFlag() {return clearFlag;}
	public void setClearFlag(int flag){
		clearFlag=flag;
		
		if(clearFlag==0){
			System.out.println("fail!");
			tempTokenHitCount=0;
		}
		if(clearFlag==1){
			if(tempTokenHitCount==tokenhitCount){
				System.out.println("모든블록지나갔음");
				System.out.println("부딪힌수:"+tempTokenHitCount);
				System.out.println("블록개수:"+tokenhitCount);
				System.out.println("clear");
				tempTokenHitCount=0;
			}
			else{
				System.out.println("모든블록안지나갔음");
				System.out.println("부딪힌수:"+tempTokenHitCount);
				System.out.println("블록개수:"+tokenhitCount);
				System.out.println("fail!");
				setClearFlag(0);
				tempTokenHitCount=0;
			}			
		}
		
		viewer.repaint();
	}
	
	public void	incHitNumber(){
		this.hitNumber++;		
	}
	public void	incTempTokenCount(){
		this.tempTokenHitCount++;
	}
	public int getHitNumber() {return hitNumber;}
	public Lazer getLazer() {return lazer;}
	public void setLazer() {	
		hitNumber=0;
		lazerArrList.clear();
		int tempIndexX=-1,tempIndexY=-1;
		cooltime=0;
		
		for(int i=0; i<manager.getTokenNumber(); ++i){
			if(manager.getToken(i).getY()>310){
				if(manager.getToken(i).getID().equals("R")){
					tempIndexX=(manager.getToken(i).getX()-90)/90;
					tempIndexY=(manager.getToken(i).getY()-320)/90;
					tempDir=manager.getToken(i).getDirection();
				}
			}
		}
		
		if(tempIndexX==-1)return;
		
		lazer=new Lazer(tempIndexX,tempIndexY);
		System.out.println("타겟개수:"+manager.getTargetNumber());
		System.out.println("시작위치:"+tempIndexX+" "+tempIndexY);
		while(true){
			switch(tempDir){
			case "W":
				if(tempIndexY==0){	
					System.out.println("위쪽벽에막힘");
					lazer.addIndex(tempIndexX, tempIndexY);
					setClearFlag(0);	
					lazerArrList.add(lazer);
					return;
				}
				else{
					System.out.println("위로이동");
					tempIndexY--;
					for(int i=0;i<manager.getTokenNumber();i++){
						if((manager.getToken(i).getX()-90)/90==tempIndexX&&(manager.getToken(i).getY()-320)/90==tempIndexY){
							System.out.println(tempIndexX+" "+tempIndexY+"에서 토큰충돌");
							
							if(manager.getToken(i).getID().equals("p")||manager.getToken(i).getID().equals("S")||manager.getToken(i).getID().equals("B")){}
							else incTempTokenCount();
							
							lazer.addIndex(tempIndexX, tempIndexY);
							tempDir=manager.getToken(i).doSomethingToLazer(lazer,this,tempDir);
						}
					}
				}break;
			case "D":
				if(tempIndexX==4){	
					System.out.println("오른쪽 벽에 막힘");
					lazer.addIndex(tempIndexX, tempIndexY);
					setClearFlag(0);					
					lazerArrList.add(lazer);
					return;
				}
				else{
					System.out.println("오른쪽 이동");
					tempIndexX++;
					
					for(int i=0;i<manager.getTokenNumber();i++){
						if((manager.getToken(i).getX()-90)/90==tempIndexX&&(manager.getToken(i).getY()-320)/90==tempIndexY){
							System.out.println(tempIndexX+" "+tempIndexY+"에서 토큰충돌");
							if(manager.getToken(i).getID().equals("p")||manager.getToken(i).getID().equals("S")||manager.getToken(i).getID().equals("B")){}
							else incTempTokenCount();
							lazer.addIndex(tempIndexX, tempIndexY);
							tempDir=manager.getToken(i).doSomethingToLazer(lazer,this,tempDir);//index저장&방향설정&타겟개수설정
						}
					}					
				}break;
			case "S":
				if(tempIndexY==4){	
					System.out.println("아래쪽 벽에 막힘");
					lazer.addIndex(tempIndexX, tempIndexY);
					setClearFlag(0);
					lazerArrList.add(lazer);
					return;
				}
				else{
					System.out.println("아래로 이동");
					tempIndexY++;
					for(int i=0;i<manager.getTokenNumber();i++){
						if((manager.getToken(i).getX()-90)/90==tempIndexX&&(manager.getToken(i).getY()-320)/90==tempIndexY){
							System.out.println(tempIndexX+" "+tempIndexY+"에서 토큰충돌");
							if(manager.getToken(i).getID().equals("p")||manager.getToken(i).getID().equals("S")||manager.getToken(i).getID().equals("B")){}
							else incTempTokenCount();
							lazer.addIndex(tempIndexX, tempIndexY);
							tempDir=manager.getToken(i).doSomethingToLazer(lazer,this,tempDir);//index저장&방향설정&타겟개수설정
						}
					}
				}break;
			case "A":
				if(tempIndexX==0){	
					System.out.println("왼쪽벽에 막힘");
					lazer.addIndex(tempIndexX, tempIndexY);
					setClearFlag(0);
					lazerArrList.add(lazer);
					return;
				}
				else{
					System.out.println("왼쪽으로 이동");
					tempIndexX--;
					for(int i=0;i<manager.getTokenNumber();i++){
						if((manager.getToken(i).getX()-90)/90==tempIndexX&&(manager.getToken(i).getY()-320)/90==tempIndexY){
							System.out.println(tempIndexX+" "+tempIndexY+"에서 토큰충돌");
							if(manager.getToken(i).getID().equals("p")||manager.getToken(i).getID().equals("S")||manager.getToken(i).getID().equals("B")){}
							else incTempTokenCount();
							lazer.addIndex(tempIndexX, tempIndexY);
							tempDir=manager.getToken(i).doSomethingToLazer(lazer,this,tempDir);//index저장&방향설정&타겟개수설정
						}
					}
				}break;
			case "F":
				System.out.println("레이저정지");
				System.out.println("히트수:타겟수="+hitNumber+":"+manager.getTargetNumber());
				if(hitNumber==manager.getTargetNumber()){
					setClearFlag(1);
				}
				lazerArrList.add(lazer);
				return;
			}
		}
	}
	public void addChangeListener(ChangeListener l) {
		this.listeners.add(l);
	}
	public void removeChangeListener(ChangeListener l) {
		this.listeners.remove(l);
	}
	public ChangeListener[] getChangeListeners() {
		return (ChangeListener[])(this.listeners.toArray());
	}

	public int getCooltime() {
		// TODO Auto-generated method stub
		return cooltime;
	}
	public void setCooltime(int i){
		cooltime=i;
	}
}
