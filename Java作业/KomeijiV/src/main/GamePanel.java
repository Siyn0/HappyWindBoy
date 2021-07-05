package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener,ActionListener{

	/**
	 * 软件工程 18-2，18031210224 周静琪
	 */
	
	private static final long serialVersionUID = 1L;
	//加载图片
	ImageIcon start = new ImageIcon("img/小觉Helloworld3.gif");
	ImageIcon bg = new ImageIcon("img/bg.png");
	ImageIcon eye = new ImageIcon("img/小觉闭眼.gif");
	ImageIcon tongue = new ImageIcon("img/小觉吐舌.gif");
	ImageIcon smile = new ImageIcon("img/小觉微笑.gif");
	ImageIcon say = new ImageIcon("img/小觉说话.gif");
	
	//小觉说的话
	String str = new String();

	//游戏状态
	boolean isStart = false;
	boolean isFaild = false;
	boolean isEnd = false;
	boolean isEye = false;
	boolean isSay = false;

	

	//初始化
	public void initGame() {
		isStart = true;
		isEnd = false;
		isEye = false;
		isSay = false;
	}
	
	public GamePanel() {
		this.setFocusable(true);
		initGame();
		
		//添加键盘监听器
		this.addKeyListener(this);
		
		//添加鼠标监听器
		this.addMouseListener((new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if(e.getClickCount() > 0) {
        			isSay = !isSay;
        		}
            }
		}
		));
		
		timer1.start();
		timer2.start();
	}

	Timer timer1 = new Timer(10,this);
	Timer timer2 = new Timer(5000,this);

	public void paint(Graphics g) {

		g.fillRect(0, 0, 640, 800);
		g.drawImage(bg.getImage(),0,0,640,800,null);

		//游戏状态界面
		if(isStart) {

			g.drawImage(start.getImage(), 0, 420, 350, 350,  null);
			str = "Hello World!";
			
		}
		
		//总是显示的字符串
		g.setColor(Color.WHITE);
		g.setFont(new Font("微软雅黑",Font.BOLD,30));
		g.drawString(str,200,400);
		
		
		if(isEnd) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("微软雅黑",Font.BOLD,30));
			g.drawString("下次再见。",200,400);
			g.drawString("软件工程18-2，周静琪 制作。",200,420);
		}

		if(isEye) {
			str = "小觉眨眼~";
			g.drawImage(eye.getImage(), 0, 420, 340, 340,  null);
		}
		
		if(isSay) {
			str = "小觉说话~";
			g.drawImage(say.getImage(), 0, 420, 340, 340,  null);
		}
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
			isStart = false;
		}
		
		if(keyCode == KeyEvent.VK_ENTER) {
			InputTextFrame i = new InputTextFrame();
			str = "test";
			isSay = !isSay;
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {

	}

	//移动
	@Override
	public void actionPerformed(ActionEvent e) {

			if(e.getSource() == timer2){
				isEye = true;
				isStart = false;
			
			
		}
		repaint();
	}
}
