package ������������;

public class Yellow extends Token{
	@Override
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		System.out.println("�����ū");
		switch(tempDir){
			case "S":
			case "W":
				if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("�����ū���");}
				else {System.out.println("������ε���");lazerMaze.setClearFlag(0);}break;
			
			case "A":
			case "D":
				if(this.getDirection().equals("A")||this.getDirection().equals("D")){System.out.println("�����ū���");}
				else {System.out.println("������ε���");lazerMaze.setClearFlag(0);}break;
		}
		return tempDir;
	}
}
