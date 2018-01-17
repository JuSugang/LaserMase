package 레이저메이즈;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	private String fileName;
	private ArrayList<Card> cardList = new ArrayList();
	public Reader(String fileName){
		this.fileName=fileName;
		File f = new File(fileName);
		try{
			Scanner sc= new Scanner(f);
			while(sc.hasNextLine()){
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
				int stageLevel=sc.nextInt();
				sc.nextLine();
				int targetNumber=sc.nextInt();
				sc.nextLine();
				
				int NumOfToken=sc.nextInt();
				sc.nextLine();
				String[] tokenInfoArr= new String[NumOfToken];
								
				for(int i=0;i<NumOfToken;i++){
					tokenInfoArr[i]=sc.nextLine();
				}
				
				Card card = new Card();
				card.setTargetNumber(targetNumber);
				card.setTokenNumber(NumOfToken);
				card.setTokenInfo(tokenInfoArr);
	
				cardList.add(card);
			}
		}
		catch(IOException e){
			System.out.println("파일을 읽을 수 없습니다.");
		}
	}
	
	public ArrayList<Card> getCardList(){
		return cardList;
	}
	public Card getCard(int index){
		Card card=cardList.get(index);
		return card;
	}
	 
}
