package ������������;

public class Purple extends Token{
	@Override
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		switch(tempDir){
		case "S":
			if(this.getDirection().equals("W")){System.out.println("������ū�����΋H��");lazerMaze.setClearFlag(0);tempDir="F";}
			else if(this.getDirection().equals("D")){System.out.println("������ū-�����̵�");tempDir="A";}
			else if(this.getDirection().equals("S")){System.out.println("������ū-�������̵�");tempDir="D";}
			else {System.out.println("������ū�����΋H��");lazerMaze.setClearFlag(0);tempDir="F";}
			break;
		case "A":
			if(this.getDirection().equals("W")){System.out.println("������ū�����΋H��");lazerMaze.setClearFlag(0);tempDir="F";}
			else if(this.getDirection().equals("D")){System.out.println("������ū�����΋H��");lazerMaze.setClearFlag(0);tempDir="F";}
			else if(this.getDirection().equals("S")){System.out.println("������ū-�����̵�");tempDir="W";}
			else {System.out.println("������ū-�Ʒ����̵�");tempDir="S";}
			break;
		case "W":
			if(this.getDirection().equals("W")){System.out.println("������ū-�����̵�");tempDir="A";}
			else if(this.getDirection().equals("D")){System.out.println("������ū�����΋H��");lazerMaze.setClearFlag(0);tempDir="F";}
			else if(this.getDirection().equals("S")){System.out.println("������ū�����΋H��");lazerMaze.setClearFlag(0);tempDir="F";}
			else {System.out.println("������ū-�������̵�");tempDir="D";}
			break;
		case "D":
			if(this.getDirection().equals("W")){System.out.println("������ū-�Ʒ����̵�");tempDir="S";}
			else if(this.getDirection().equals("D")){System.out.println("������ū-�����̵�");tempDir="W";}
			else if(this.getDirection().equals("S")){System.out.println("������ū�����΋H��");lazerMaze.setClearFlag(0);tempDir="F";}
			else {System.out.println("������ū�����΋H��");lazerMaze.setClearFlag(0);tempDir="F";}
			break;
		}
		return tempDir;
	}
}
