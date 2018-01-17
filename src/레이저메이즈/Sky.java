package 레이저메이즈;

public class Sky extends Token{
	@Override
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		System.out.println("하늘색토큰");
		switch(tempDir){
		case "S":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("오른쪽");tempDir="D";}
			else {System.out.println("왼쪽");tempDir="A";} break;
		case "A":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("위쪽");tempDir="W";}
			else {System.out.println("아래쪽");tempDir="S";} break;
		case "W":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("왼쪽");tempDir="A";}
			else {System.out.println("오른쪽");tempDir="D";} break;
		case "D":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("아래쪽");tempDir="S";}
			else {System.out.println("위쪽");tempDir="W";} break;
		}
		return tempDir;
	}
}
