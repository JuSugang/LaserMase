package ������������;


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
			System.out.println("������ ���� �� �����ϴ�.");
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
