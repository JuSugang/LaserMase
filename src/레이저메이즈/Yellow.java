package 레이저메이즈;

public class Yellow extends Token{
	@Override
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		System.out.println("노란토큰");
		switch(tempDir){
			case "S":
			case "W":
				if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("노란토큰통과");}
				else {System.out.println("노란벽부딪힘");lazerMaze.setClearFlag(0);}break;
			
			case "A":
			case "D":
				if(this.getDirection().equals("A")||this.getDirection().equals("D")){System.out.println("노란토큰통과");}
				else {System.out.println("노란벽부딪힘");lazerMaze.setClearFlag(0);}break;
		}
		return tempDir;
	}
}
