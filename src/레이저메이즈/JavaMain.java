package 레이저메이즈;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class JavaMain extends JFrame{
	private LazerMaze lazerMaze = null;
	private LazerMazeViewer viewer = null;
	private LazerMazePreviewer previewer =null;
	
	public static void main(String[] args) {
		JavaMain lm= new JavaMain();
		lm.go();
	}
	public void go(){
		Reader r = new Reader("src/CardInfo.txt");
		try {
			   UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		}catch (Exception e) { }
	
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("LazerMaze 201320147 주수강");
		frame.setResizable(false);
		JFrame previewFrame = new JFrame();
		previewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		previewFrame.setTitle("미리보기");
		previewFrame.setResizable(false);
		JPanel menu = new JPanel();
		menu.setBackground(Color.BLACK);
		JPanel previewMenu = new JPanel();
		previewMenu.setBackground(Color.BLACK);
		
		lazerMaze= new LazerMaze(r);
		viewer= new LazerMazeViewer();
		previewer =new LazerMazePreviewer();
		
		lazerMaze.setViewer(viewer);
		viewer.setLazer(lazerMaze);
		previewer.setLazer(lazerMaze);
		
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("CANCEL");
		JButton leftButton = new JButton("◀");
		JButton rightButton = new JButton("▶");
		JButton selectButton = new JButton("SELECT");
		JButton resetButton = new JButton("INIT");
		JButton lazerButton = new JButton("Lazer");
		JButton solutionButton= new JButton("SOLUTION");
		final JTextField levelTextField = new JTextField(2);
		levelTextField.setText("1");
		
		
		solutionButton.setVisible(false);
		resetButton.setVisible(false);
		lazerButton.setVisible(false);
		
		Thread t = new Thread(lazerMaze);
		t.start();
		
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int num=Integer.parseInt(levelTextField.getText());
				--num;
				if(num<=0)
					num=1;
				levelTextField.setText(Integer.toString(num));
			}});
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int num=Integer.parseInt(levelTextField.getText());
				++num;
				if(num>20)
					num=20;
				levelTextField.setText(Integer.toString(num));
			}});
		
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int num=Integer.parseInt(levelTextField.getText());
				if(num>20){
					levelTextField.setText(Integer.toString(20));
					num=Integer.parseInt(levelTextField.getText());
				}
				if(num<1){
					levelTextField.setText(Integer.toString(1));
					num=Integer.parseInt(levelTextField.getText());
				}
				lazerMaze.setIndex(num);
				previewFrame.setVisible(true);
				cancelButton.setVisible(true);
			}});
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				lazerMaze.setStage();
				lazerMaze.setLazerDrawFlag(0);
				lazerMaze.setClearFlag(-1);
			}});
		lazerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				lazerMaze.setLazer();
				lazerMaze.setLazerDrawFlag(1);
			}});
		solutionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				previewer.setShowingState(true);
				previewFrame.setVisible(true);
				cancelButton.setVisible(false);
			}});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				previewFrame.setVisible(false);
			}});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(previewer.getShowingState()==false){
					lazerMaze.setStage();
					previewFrame.setVisible(false);
					resetButton.setVisible(true);
					lazerButton.setVisible(true);
					solutionButton.setVisible(true);
					lazerMaze.setLazerDrawFlag(0);
					lazerMaze.setClearFlag(-1);
					lazerMaze.setLevelDrawFlag(1);
				}
				else{
					previewFrame.setVisible(false);
					previewer.setShowingState(false);
				}
			}});
		
		okButton.setFont(new Font("sanserif",Font.BOLD,15));
		cancelButton.setFont(new Font("sanserif",Font.BOLD,15));
		leftButton.setFont(new Font("sanserif",Font.BOLD,15));
		rightButton.setFont(new Font("sanserif",Font.BOLD,15));
		selectButton.setFont(new Font("sanserif",Font.BOLD,15));
		resetButton.setFont(new Font("sanserif",Font.BOLD,15));
		lazerButton.setFont(new Font("sanserif",Font.BOLD,15));
		solutionButton.setFont(new Font("sanserif",Font.BOLD,15));
		levelTextField.setFont(new Font("sanserif",Font.BOLD,15));
		menu.add(leftButton);
		menu.add(levelTextField);
		menu.add(rightButton);
		menu.add(selectButton);
		menu.add(resetButton);
		menu.add(lazerButton);
		menu.add(solutionButton);
		previewMenu.add(okButton);
		previewMenu.add(cancelButton);
		
		frame.getContentPane().add(BorderLayout.CENTER,viewer);
		frame.getContentPane().add(BorderLayout.SOUTH,menu);
		frame.setLocation(600,10);
		frame.setSize(640,1012);
		frame.setVisible(true);
		
		previewFrame.getContentPane().add(BorderLayout.CENTER,previewer);
		previewFrame.getContentPane().add(BorderLayout.SOUTH,previewMenu);
		previewFrame.setLocation(685, 90);
		previewFrame.setSize(475,781);
		previewFrame.setVisible(false);
	}

	

}
