package 레이저메이즈;

public class PurplePointed extends Token{
	@Override
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		System.out.println("타겟보라토큰");
		switch(tempDir){
		case "S":
			if(this.getDirection().equals("W")){System.out.println("타겟명중");lazerMaze.incHitNumber();tempDir="F";}
			else if(this.getDirection().equals("D")){System.out.println("왼쪽");tempDir="A";}
			else if(this.getDirection().equals("S")){System.out.println("오른쪽");tempDir="D";}
			else {System.out.println("보라토큰벽에부딫힘");tempDir="F";lazerMaze.setClearFlag(0);}
			break;
		case "A":
			if(this.getDirection().equals("W")){System.out.println("보라토큰벽에부딫힘");tempDir="F";lazerMaze.setClearFlag(0);}
			else if(this.getDirection().equals("D")){System.out.println("타겟명중");lazerMaze.incHitNumber();tempDir="F";}
			else if(this.getDirection().equals("S")){System.out.println("위쪽");tempDir="W";}
			else {System.out.println("아래쪽");tempDir="S";}
			break;
		case "W":
			if(this.getDirection().equals("W")){System.out.println("왼쪽");tempDir="A";}
			else if(this.getDirection().equals("D")){System.out.println("보라토큰벽에부딫힘");tempDir="F";lazerMaze.setClearFlag(0);}
			else if(this.getDirection().equals("S")){System.out.println("타겟명중");lazerMaze.incHitNumber();tempDir="F";}
			else {System.out.println("오른쪽");tempDir="D";}
			break;
		case "D":
			if(this.getDirection().equals("W")){System.out.println("아래쪽");tempDir="S";}
			else if(this.getDirection().equals("D")){System.out.println("위쪽");tempDir="W";}
			else if(this.getDirection().equals("S")){System.out.println("보라토큰벽에부딫힘");tempDir="F";lazerMaze.setClearFlag(0);}
			else {System.out.println("타겟명중");lazerMaze.incHitNumber();tempDir="F";}
			break;
		}
		return tempDir;
	}
}
