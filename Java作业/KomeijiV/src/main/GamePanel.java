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
	 * ������� 18-2��18031210224 �ܾ���
	 */
	
	private static final long serialVersionUID = 1L;
	//����ͼƬ
	ImageIcon start = new ImageIcon("img/С��Helloworld3.gif");
	ImageIcon bg = new ImageIcon("img/bg.png");
	ImageIcon eye = new ImageIcon("img/С������.gif");
	ImageIcon tongue = new ImageIcon("img/С������.gif");
	ImageIcon smile = new ImageIcon("img/С��΢Ц.gif");
	ImageIcon say = new ImageIcon("img/С��˵��.gif");
	
	//С��˵�Ļ�
	String str = new String();

	//��Ϸ״̬
	boolean isStart = false;
	boolean isFaild = false;
	boolean isEnd = false;
	boolean isEye = false;
	boolean isSay = false;

	

	//��ʼ��
	public void initGame() {
		isStart = true;
		isEnd = false;
		isEye = false;
		isSay = false;
	}
	
	public GamePanel() {
		this.setFocusable(true);
		initGame();
		
		//��Ӽ��̼�����
		this.addKeyListener(this);
		
		//�����������
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

		//��Ϸ״̬����
		if(isStart) {

			g.drawImage(start.getImage(), 0, 420, 350, 350,  null);
			str = "Hello World!";
			
		}
		
		//������ʾ���ַ���
		g.setColor(Color.WHITE);
		g.setFont(new Font("΢���ź�",Font.BOLD,30));
		g.drawString(str,200,400);
		
		
		if(isEnd) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("΢���ź�",Font.BOLD,30));
			g.drawString("�´��ټ���",200,400);
			g.drawString("�������18-2���ܾ��� ������",200,420);
		}

		if(isEye) {
			str = "С��գ��~";
			g.drawImage(eye.getImage(), 0, 420, 340, 340,  null);
		}
		
		if(isSay) {
			str = "С��˵��~";
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
		//�ո����ͣ���������ؿ�
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

	//�ƶ�
	@Override
	public void actionPerformed(ActionEvent e) {

			if(e.getSource() == timer2){
				isEye = true;
				isStart = false;
			
			
		}
		repaint();
	}
}
