package ������������;

public class Sky extends Token{
	@Override
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		System.out.println("�ϴû���ū");
		switch(tempDir){
		case "S":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("������");tempDir="D";}
			else {System.out.println("����");tempDir="A";} break;
		case "A":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("����");tempDir="W";}
			else {System.out.println("�Ʒ���");tempDir="S";} break;
		case "W":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("����");tempDir="A";}
			else {System.out.println("������");tempDir="D";} break;
		case "D":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("�Ʒ���");tempDir="S";}
			else {System.out.println("����");tempDir="W";} break;
		}
		return tempDir;
	}
}
