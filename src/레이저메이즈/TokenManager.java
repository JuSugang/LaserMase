package ������������;

public class TokenManager {
	private int targetNumber=0;
	
	private String[] tokenList;
	private Token[] token;
	private int tokenNumber=0;
	
	public TokenManager(Card card){
		targetNumber=card.getTargetNumber();
		
		tokenNumber=card.getTokenNumber();//���� ī���� ��ū�� ������ ����
		tokenList= new String[tokenNumber];//��ū����
		tokenList=card.getTokenInfo();	//string Arr�� ���� �� ����
		token= new Token[tokenNumber];//��ū ����
		
		for(int i=0; i<tokenNumber;i++){	//��ū ������ŭ �����ϴϱ� ���� �ѹ� ������ ���Ǵ� ��ū�� ����� ������ ������ �Էµ�
		
			String[] tempSplit=tokenList[i].split(" ");
		
			/*
			 * Red Purple purple(pointed) Sky Black Yellow Green 
			 * ���� WASD
			 * Y/N ȸ�����ɿ���
			 * Y/N �̵����ɿ���
			 * 1	//�������� ����(16ź �̹����� 6)
			 * 1	//Ÿ�� ����
			 * 3	//��ġ�� ��ū�� ����
			 * R 1 1 S N N	//��ū ����
			 * p 3 3 A N N	//��ū����
			 * S 0 0 W Y Y	//����� �� �ִ� ��ū�� ����
			 */
			if(tempSplit[0].equals("R"))
				token[i]= new Red();
			if(tempSplit[0].equals("P"))
				token[i]= new Purple();
			if(tempSplit[0].equals("p"))
				token[i]= new PurplePointed();
			if(tempSplit[0].equals("S"))
				token[i]= new Sky();
			if(tempSplit[0].equals("B"))
				token[i]= new Black();
			if(tempSplit[0].equals("Y"))
				token[i]= new Yellow();
			if(tempSplit[0].equals("G"))
				token[i]= new Green();
			token[i].setID(tempSplit[0]);
			token[i].setDirection(tempSplit[3]);
			token[i].setRotateableFlag(tempSplit[4]);
			token[i].setMoveableFlag(tempSplit[5]);
			if(token[i].getMoveableFlag()==false){
				token[i].setX(Integer.parseInt(tempSplit[1])*90+90);//ȭ��ũ��
				token[i].setY(Integer.parseInt(tempSplit[2])*90+320);
			}
			else{
				token[i].setX(Integer.parseInt(tempSplit[1])*90+20);//ȭ��ũ��
				token[i].setY(Integer.parseInt(tempSplit[2])*90+140);
			}
		}	
	}
	
	public int getTargetNumber() {return targetNumber;}
	public int getTokenNumber() {return tokenNumber;}
	public Token getToken(int index) {return token[index];	}

}
