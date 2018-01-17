package 레이저메이즈;

public class Card {
	
	private int targetNumber=0;
	private int tokenNumber=0;
	private String[] tokenInfo;

	public void setTargetNumber(int targetNumber) {this.targetNumber=targetNumber;}
	public void setTokenNumber(int num) {tokenNumber=num;}
	public void setTokenInfo( String[] tokenInfoArr) {this.tokenInfo=tokenInfoArr;}
	
	public int getTargetNumber() {return targetNumber;}
	public int getTokenNumber() {return tokenNumber;}
	public String[] getTokenInfo() {return tokenInfo;}

}
