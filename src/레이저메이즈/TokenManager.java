package 레이저메이즈;

public class TokenManager {
	private int targetNumber=0;
	
	private String[] tokenList;
	private Token[] token;
	private int tokenNumber=0;
	
	public TokenManager(Card card){
		targetNumber=card.getTargetNumber();
		
		tokenNumber=card.getTokenNumber();//현재 카드의 토큰의 갯수를 받음
		tokenList= new String[tokenNumber];//토큰생성
		tokenList=card.getTokenInfo();	//string Arr에 정보 다 대입
		token= new Token[tokenNumber];//토큰 생성
		
		for(int i=0; i<tokenNumber;i++){	//토큰 갯수만큼 실행하니까 세팅 한번 누르면 헤당되는 토큰이 생기고 각각의 정보가 입력됨
		
			String[] tempSplit=tokenList[i].split(" ");
		
			/*
			 * Red Purple purple(pointed) Sky Black Yellow Green 
			 * 방향 WASD
			 * Y/N 회전가능여부
			 * Y/N 이동가능여부
			 * 1	//스테이지 레벨(16탄 이미지는 6)
			 * 1	//타겟 개수
			 * 3	//배치된 토큰의 갯수
			 * R 1 1 S N N	//토큰 정보
			 * p 3 3 A N N	//토큰정보
			 * S 0 0 W Y Y	//사용할 수 있는 토큰의 정보
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
				token[i].setX(Integer.parseInt(tempSplit[1])*90+90);//화면크기
				token[i].setY(Integer.parseInt(tempSplit[2])*90+320);
			}
			else{
				token[i].setX(Integer.parseInt(tempSplit[1])*90+20);//화면크기
				token[i].setY(Integer.parseInt(tempSplit[2])*90+140);
			}
		}	
	}
	
	public int getTargetNumber() {return targetNumber;}
	public int getTokenNumber() {return tokenNumber;}
	public Token getToken(int index) {return token[index];	}

}
