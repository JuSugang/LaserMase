package ������������;

public class PurplePointed extends Token{
	@Override
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		System.out.println("Ÿ�ٺ�����ū");
		switch(tempDir){
		case "S":
			if(this.getDirection().equals("W")){System.out.println("Ÿ�ٸ���");lazerMaze.incHitNumber();tempDir="F";}
			else if(this.getDirection().equals("D")){System.out.println("����");tempDir="A";}
			else if(this.getDirection().equals("S")){System.out.println("������");tempDir="D";}
			else {System.out.println("������ū�����΋H��");tempDir="F";lazerMaze.setClearFlag(0);}
			break;
		case "A":
			if(this.getDirection().equals("W")){System.out.println("������ū�����΋H��");tempDir="F";lazerMaze.setClearFlag(0);}
			else if(this.getDirection().equals("D")){System.out.println("Ÿ�ٸ���");lazerMaze.incHitNumber();tempDir="F";}
			else if(this.getDirection().equals("S")){System.out.println("����");tempDir="W";}
			else {System.out.println("�Ʒ���");tempDir="S";}
			break;
		case "W":
			if(this.getDirection().equals("W")){System.out.println("����");tempDir="A";}
			else if(this.getDirection().equals("D")){System.out.println("������ū�����΋H��");tempDir="F";lazerMaze.setClearFlag(0);}
			else if(this.getDirection().equals("S")){System.out.println("Ÿ�ٸ���");lazerMaze.incHitNumber();tempDir="F";}
			else {System.out.println("������");tempDir="D";}
			break;
		case "D":
			if(this.getDirection().equals("W")){System.out.println("�Ʒ���");tempDir="S";}
			else if(this.getDirection().equals("D")){System.out.println("����");tempDir="W";}
			else if(this.getDirection().equals("S")){System.out.println("������ū�����΋H��");tempDir="F";lazerMaze.setClearFlag(0);}
			else {System.out.println("Ÿ�ٸ���");lazerMaze.incHitNumber();tempDir="F";}
			break;
		}
		return tempDir;
	}
}
