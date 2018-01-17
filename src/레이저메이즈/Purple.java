package 레이저메이즈;

public class Purple extends Token{
	@Override
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		switch(tempDir){
		case "S":
			if(this.getDirection().equals("W")){System.out.println("보라토큰벽에부딫힘");lazerMaze.setClearFlag(0);tempDir="F";}
			else if(this.getDirection().equals("D")){System.out.println("보라토큰-왼쪽이동");tempDir="A";}
			else if(this.getDirection().equals("S")){System.out.println("보라토큰-오른쪽이동");tempDir="D";}
			else {System.out.println("보라토큰벽에부딫힘");lazerMaze.setClearFlag(0);tempDir="F";}
			break;
		case "A":
			if(this.getDirection().equals("W")){System.out.println("보라토큰벽에부딫힘");lazerMaze.setClearFlag(0);tempDir="F";}
			else if(this.getDirection().equals("D")){System.out.println("보라토큰벽에부딫힘");lazerMaze.setClearFlag(0);tempDir="F";}
			else if(this.getDirection().equals("S")){System.out.println("보라토큰-위쪽이동");tempDir="W";}
			else {System.out.println("보라토큰-아래쪽이동");tempDir="S";}
			break;
		case "W":
			if(this.getDirection().equals("W")){System.out.println("보라토큰-왼쪽이동");tempDir="A";}
			else if(this.getDirection().equals("D")){System.out.println("보라토큰벽에부딫힘");lazerMaze.setClearFlag(0);tempDir="F";}
			else if(this.getDirection().equals("S")){System.out.println("보라토큰벽에부딫힘");lazerMaze.setClearFlag(0);tempDir="F";}
			else {System.out.println("보라토큰-오른쪽이동");tempDir="D";}
			break;
		case "D":
			if(this.getDirection().equals("W")){System.out.println("보라토큰-아래쪽이동");tempDir="S";}
			else if(this.getDirection().equals("D")){System.out.println("보라토큰-위쪽이동");tempDir="W";}
			else if(this.getDirection().equals("S")){System.out.println("보라토큰벽에부딫힘");lazerMaze.setClearFlag(0);tempDir="F";}
			else {System.out.println("보라토큰벽에부딫힘");lazerMaze.setClearFlag(0);tempDir="F";}
			break;
		}
		return tempDir;
	}
}
