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
	 * 软件工程 18-2，18031210224 周静琪
	 */
	private static final long serialVersionUID = 1L;
	//加载图片
	ImageIcon start = new ImageIcon("img/Start.jpg");
	ImageIcon right = new ImageIcon("img/right.png");
	ImageIcon left = new ImageIcon("img/left.png");
	ImageIcon rabi = new ImageIcon("img/rabi.png");
	ImageIcon ribi = new ImageIcon("img/ribi.png");
	ImageIcon sf = new ImageIcon("img/sf.png");
	ImageIcon bg = new ImageIcon("img/bg.jpg");

	//player的各个属性
	int player_x = 50;
	int player_y = 500;
	int direction = 0;

	//游戏状态
	boolean isStart = false;
	boolean isFaild = false;
	boolean isEnd = false;

	//初始化
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
		//画敌人
		g.drawImage(sf.getImage(), 1000, 500, 150, 200, null);

		//游戏状态界面
		if(!isStart) {

			g.drawImage(start.getImage(), 0, 0, 1920, 1080,  null);
			g.setColor(Color.BLACK);

			g.setFont(new Font("微软雅黑",Font.BOLD,30));
			g.drawString("按下空格键",960,800);
			g.drawString("上下左右控制移动",1000,600);
		}
		if(isFaild) {
			g.drawImage(bg.getImage(), 0, 0, 1920, 1080,  null);
			g.setColor(Color.black);
			g.setFont(new Font("微软雅黑",Font.BOLD,30));
			g.drawString("被打死了，你是萌萌",960,500);
			g.drawImage(sf.getImage(), 1000, 500, 150, 200, null);
		}
		if(isEnd) {
			g.setColor(Color.black);
			g.setFont(new Font("微软雅黑",Font.BOLD,30));
			g.drawString("感谢游玩。",960,500);
			g.drawString("软件工程18-2，周静琪 制作。",960,700);
		}

		//画玩家
		if(direction == 2){//左
			left.paintIcon(this, g, player_x, player_y);
		}else{//上下右或者不动
			right.paintIcon(this, g, player_x, player_y);
		}



		//TODO:画兔子



	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//空格键暂停、继续、重开
		if(keyCode == KeyEvent.VK_SPACE){
			if(isFaild){
				initGame();
			}
			else{
				isStart = !isStart;
			}
		}



		//控制移动    0不动，1右，2左，3上，4下
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

		//控制移动    0不动，1右，2左，3上，4下
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

	//移动
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();

		if(isStart && !isFaild && !isEnd) {

			//碰撞检测
			if(((player_x >= 850)&&(player_x <= 1150)) && ((player_y >= 400)&&(player_y <= 650)))
				isFaild = true;

			if(direction == 1) {//右
				if(player_x <= 1920 )
					player_x += 10;
				else
					player_x -= 20;
			}else if(direction == 2) {//左
				if(player_x >= 0)
					player_x -= 10;
				else
					player_x += 20;
			}else if(direction == 3) {//上
				if(player_y >= 0)
					player_y -= 10;
				else
					player_y += 20;
			}else if(direction == 4) {//下
				if(player_y < 1000 )
					player_y += 10;
				else 
					player_y -= 20;
			}

		}
		repaint();
	}
}
