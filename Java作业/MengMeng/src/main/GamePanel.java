package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener,ActionListener{

	/**
	 * ������� 18-2��18031210224 �ܾ���
	 */
	private static final long serialVersionUID = 1L;
	//����ͼƬ
	ImageIcon start = new ImageIcon("img/Start.jpg");
	ImageIcon right = new ImageIcon("img/right.png");
	ImageIcon left = new ImageIcon("img/left.png");
	ImageIcon rabi = new ImageIcon("img/rabi.png");
	ImageIcon ribi = new ImageIcon("img/ribi.png");
	ImageIcon sf = new ImageIcon("img/sf.png");
	ImageIcon bg = new ImageIcon("img/bg.jpg");

	//player�ĸ�������
	int player_x = 50;
	int player_y = 500;
	int direction = 0;

	//��Ϸ״̬
	boolean isStart = false;
	boolean isFaild = false;
	boolean isEnd = false;

	//��ʼ��
	public void initGame() {
		isStart = false;
		isFaild = false;
		isEnd = false;
		player_x = 200;
		player_y = 200;

	}
	public GamePanel() {
		this.setFocusable(true);
		initGame();
		this.addKeyListener(this);
		timer.start();
	}

	Timer timer = new Timer(20,this);

	public void paint(Graphics g) {

		g.fillRect(0, 0, 1920, 1080);
		//right.paintIcon(this,g,50,500);
		g.drawImage(bg.getImage(),0,0,1920,1080,null);
		//������
		g.drawImage(sf.getImage(), 1000, 500, 150, 200, null);

		//��Ϸ״̬����
		if(!isStart) {

			g.drawImage(start.getImage(), 0, 0, 1920, 1080,  null);
			g.setColor(Color.BLACK);

			g.setFont(new Font("΢���ź�",Font.BOLD,30));
			g.drawString("���¿ո��",960,800);
			g.drawString("�������ҿ����ƶ�",1000,600);
		}
		if(isFaild) {
			g.drawImage(bg.getImage(), 0, 0, 1920, 1080,  null);
			g.setColor(Color.black);
			g.setFont(new Font("΢���ź�",Font.BOLD,30));
			g.drawString("�������ˣ���������",960,500);
			g.drawImage(sf.getImage(), 1000, 500, 150, 200, null);
		}
		if(isEnd) {
			g.setColor(Color.black);
			g.setFont(new Font("΢���ź�",Font.BOLD,30));
			g.drawString("��л���档",960,500);
			g.drawString("�������18-2���ܾ��� ������",960,700);
		}

		//�����
		if(direction == 2){//��
			left.paintIcon(this, g, player_x, player_y);
		}else{//�����һ��߲���
			right.paintIcon(this, g, player_x, player_y);
		}



		//TODO:������



	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//�ո����ͣ���������ؿ�
		if(keyCode == KeyEvent.VK_SPACE){
			if(isFaild){
				initGame();
			}
			else{
				isStart = !isStart;
			}
		}



		//�����ƶ�    0������1�ң�2��3�ϣ�4��
		else if(keyCode == KeyEvent.VK_UP) {
			direction = 3;
		}else if(keyCode == KeyEvent.VK_DOWN) {
			direction = 4;
		}else if(keyCode == KeyEvent.VK_LEFT) {
			direction = 2;
		}else if(keyCode == KeyEvent.VK_RIGHT) {
			direction = 1;
		}else if(keyCode == KeyEvent.VK_ENTER) {
			InputTextFrame i = new InputTextFrame();
			
		}
	}


	/*
	public void keyDown(KeyEvent e) {
		int keyCode = e.getKeyCode();

		//�����ƶ�    0������1�ң�2��3�ϣ�4��
		if(keyCode == KeyEvent.VK_UP) {
			direction = 3;
		}else if(keyCode == KeyEvent.VK_DOWN) {
			direction = 4;
		}else if(keyCode == KeyEvent.VK_LEFT) {
			direction = 2;
		}else if(keyCode == KeyEvent.VK_RIGHT) {
			direction = 1;
		}
	}*/



	@Override
	public void keyReleased(KeyEvent e) {

		direction = 0;
	}

	//�ƶ�
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();

		if(isStart && !isFaild && !isEnd) {

			//��ײ���
			if(((player_x >= 850)&&(player_x <= 1150)) && ((player_y >= 400)&&(player_y <= 650)))
				isFaild = true;

			if(direction == 1) {//��
				if(player_x <= 1920 )
					player_x += 10;
				else
					player_x -= 20;
			}else if(direction == 2) {//��
				if(player_x >= 0)
					player_x -= 10;
				else
					player_x += 20;
			}else if(direction == 3) {//��
				if(player_y >= 0)
					player_y -= 10;
				else
					player_y += 20;
			}else if(direction == 4) {//��
				if(player_y < 1000 )
					player_y += 10;
				else 
					player_y -= 20;
			}

		}
		repaint();
	}
}
