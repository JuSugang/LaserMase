package 레이저메이즈;

public class Green extends Token{
	Lazer lazer2=null;
	@Override
	public String doSomethingToLazer(Lazer lazer,LazerMaze lazerMaze,String tempDir) {
		// TODO Auto-generated method stub
		System.out.println("초록색토큰");
		int tempIndexX=(super.getX()-90)/90;
		int	tempIndexY=(super.getY()-320)/90;
		String tempDir2=null;
		switch(tempDir){
		case "S":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("New오른쪽");tempDir2="D";}
			else {System.out.println("New왼쪽");tempDir2="A";} break;
		case "A":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("New위쪽");tempDir2="W";}
			else {System.out.println("New아래쪽");tempDir2="S";} break;
		case "W":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("New왼쪽");tempDir2="A";}
			else {System.out.println("New오른쪽");tempDir2="D";} break;
		case "D":
			if(this.getDirection().equals("W")||this.getDirection().equals("S")){System.out.println("New아래쪽");tempDir2="S";}
			else {System.out.println("New위쪽");tempDir2="W";} break;
		}
		System.out.println("New좌표:"+tempIndexX+" "+tempIndexY);
		lazer2=new Lazer(tempIndexX,tempIndexY);
		
		while(true){
			switch(tempDir2){
			case "W":
				if(tempIndexY==0){	
					lazer2.addIndex(tempIndexX, tempIndexY);
					lazerMaze.setClearFlag(0);
					System.out.println("New위쪽벽에막힘");
					lazerMaze.lazerArrList.add(lazer2);
					return tempDir;
				}
				else{
					System.out.println("New위로이동");
					tempIndexY--;
					for(int i=0;i<lazerMaze.getTokenManager().getTokenNumber();i++){
						if((lazerMaze.getTokenManager().getToken(i).getX()-90)/90==tempIndexX&&(lazerMaze.getTokenManager().getToken(i).getY()-320)/90==tempIndexY){
							System.out.println("New "+tempIndexX+" "+tempIndexY+"에서 토큰충돌");
							if(lazerMaze.getTokenManager().getToken(i).getID().equals("p")||lazerMaze.getTokenManager().getToken(i).getID().equals("S")||lazerMaze.getTokenManager().getToken(i).getID().equals("B")){}
							else lazerMaze.incTempTokenCount();
							lazer2.addIndex(tempIndexX, tempIndexY);
							tempDir2=lazerMaze.getTokenManager().getToken(i).doSomethingToLazer(lazer2,lazerMaze,tempDir2);//index저장&방향설정&타겟개수설정
						}
					}
				}break;
			case "D":
				if(tempIndexX==4){	
					System.out.println("New오른쪽벽에막힘");
					lazer2.addIndex(tempIndexX, tempIndexY);
					lazerMaze.setClearFlag(0);
					lazerMaze.lazerArrList.add(lazer2);
					return tempDir;
				}
				else{
					System.out.println("New오른쪽로이동");
					tempIndexX++;
					for(int i=0;i<lazerMaze.getTokenManager().getTokenNumber();i++){
						if((lazerMaze.getTokenManager().getToken(i).getX()-90)/90==tempIndexX&&(lazerMaze.getTokenManager().getToken(i).getY()-320)/90==tempIndexY){
							System.out.println("New "+tempIndexX+" "+tempIndexY+"에서 토큰충돌");
							if(lazerMaze.getTokenManager().getToken(i).getID().equals("p")||lazerMaze.getTokenManager().getToken(i).getID().equals("S")||lazerMaze.getTokenManager().getToken(i).getID().equals("B")){}
							else lazerMaze.incTempTokenCount();
							lazer2.addIndex(tempIndexX, tempIndexY);
							tempDir2=lazerMaze.getTokenManager().getToken(i).doSomethingToLazer(lazer2,lazerMaze,tempDir2);//index저장&방향설정&타겟개수설정
						}
					}
				}break;
			case "S":
				if(tempIndexY==4){	
					System.out.println("New아래쪽벽에막힘");
					lazer2.addIndex(tempIndexX, tempIndexY);
					lazerMaze.setClearFlag(0);
					lazerMaze.lazerArrList.add(lazer2);
					return tempDir;
				}
				else{
					System.out.println("New아래쪽으로이동");
					tempIndexY++;
					for(int i=0;i<lazerMaze.getTokenManager().getTokenNumber();i++){
						if((lazerMaze.getTokenManager().getToken(i).getX()-90)/90==tempIndexX&&(lazerMaze.getTokenManager().getToken(i).getY()-320)/90==tempIndexY){
							System.out.println("New "+tempIndexX+" "+tempIndexY+"에서 토큰충돌");
							if(lazerMaze.getTokenManager().getToken(i).getID().equals("p")||lazerMaze.getTokenManager().getToken(i).getID().equals("S")||lazerMaze.getTokenManager().getToken(i).getID().equals("B")){}
							else lazerMaze.incTempTokenCount();
							lazer2.addIndex(tempIndexX, tempIndexY);
							tempDir2=lazerMaze.getTokenManager().getToken(i).doSomethingToLazer(lazer2,lazerMaze,tempDir2);//index저장&방향설정&타겟개수설정
						}
					}
				}break;
			case "A":
				if(tempIndexX==0){	
					System.out.println("New왼쪽벽에막힘");
					lazer2.addIndex(tempIndexX, tempIndexY);
					lazerMaze.setClearFlag(0);
					lazerMaze.lazerArrList.add(lazer2);
					return tempDir;
				}
				else{
					System.out.println("New왼쪽으로이동");
					tempIndexX--;
					for(int i=0;i<lazerMaze.getTokenManager().getTokenNumber();i++){
						if((lazerMaze.getTokenManager().getToken(i).getX()-90)/90==tempIndexX&&(lazerMaze.getTokenManager().getToken(i).getY()-320)/90==tempIndexY){
							System.out.println("New "+tempIndexX+" "+tempIndexY+"에서 토큰충돌");
							if(lazerMaze.getTokenManager().getToken(i).getID().equals("p")||lazerMaze.getTokenManager().getToken(i).getID().equals("S")||lazerMaze.getTokenManager().getToken(i).getID().equals("B")){}
							else lazerMaze.incTempTokenCount();
							lazer2.addIndex(tempIndexX, tempIndexY);
							tempDir2=lazerMaze.getTokenManager().getToken(i).doSomethingToLazer(lazer2,lazerMaze,tempDir2);//index저장&방향설정&타겟개수설정
						}
					}
				}break;
			case "F":System.out.println("New레이저정지");lazerMaze.lazerArrList.add(lazer2);return tempDir;
			}
		}
		
	}
}
