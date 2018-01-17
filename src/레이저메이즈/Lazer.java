package 레이저메이즈;

import java.util.ArrayList;//겜끝나면 레이저 초기화

public class Lazer {
	private ArrayList<Integer> indexX =new ArrayList<Integer>() ;
	private ArrayList<Integer> indexY =new ArrayList<Integer>() ;
	
	public Lazer(int initX,int initY){
		indexX.add(initX);
		indexY.add(initY);
	}
	public void addIndex(int tempIndexX, int tempIndexY) {
		indexX.add(tempIndexX);
		indexY.add(tempIndexY);
	}
	public ArrayList<Integer> getXArr(){
		return indexX;
	}
	public ArrayList<Integer> getYArr(){
		return indexY;
	}
	public int getindexX(int index){
		return indexX.get(index);
	}
	public int getindexY(int index){
		return indexY.get(index);
	}
}
