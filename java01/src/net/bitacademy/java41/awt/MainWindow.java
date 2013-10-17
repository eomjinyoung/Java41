package net.bitacademy.java41.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

public class MainWindow extends Frame {

	public MainWindow() {
		//Button btn = new Button("오호라 버튼");
		
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		Panel northPanel = new Panel();
		this.add(northPanel, BorderLayout.NORTH);
		
		northPanel.add(new Button("테스트1"));
		northPanel.add(new Button("테스트2"));
		northPanel.add(new Button("테스트3"));
		
		Panel leftPanel = new Panel();
		this.add(leftPanel, BorderLayout.WEST);
		
		Label l = new Label();
		l.setText("안녕하세요");
		leftPanel.add(l);
		
		
		//
	}
	
	public static void main(String[] args) {
		MainWindow w = new MainWindow();
		w.setSize(300, 200);
		w.setVisible(true);

	}

}
