package 레이저메이즈;

public class Token {
	private String id, direction ;
	private int x,y;
	private boolean rotateFlag,moveFlag;
	
	public void setID(String id){ this.id=id;}//오버라이드 필요
	public void setX(int x){this.x=x;}
	public void setY(int y){this.y=y;}
	public void setDirection(String direction){this.direction=direction;}
	public void setRotateableFlag(String flag){
		if(flag.equals("Y")) this.rotateFlag=true;
		if(flag.equals("N")) this.rotateFlag=false;
	}
	public void setMoveableFlag(String flag){
		if(flag.equals("Y")) this.moveFlag=true;
		if(flag.equals("N")) this.moveFlag=false;
	}
	
	public String getID() {return id;}
	public int getX() {return x;}
	public int getY() {return y;}
	public String getDirection() {return direction;}
	public boolean getRotateableFlag() {return rotateFlag;}
	public boolean getMoveableFlag() {return moveFlag;}
	
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		return tempDir;
	}
}
