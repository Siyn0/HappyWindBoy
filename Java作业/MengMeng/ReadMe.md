复制一下当时写的课程设计说明书。  
图片懒得上传了，反正挺简单的，不需要看图哈哈。  
  
# 一、概述  
## 1.1设计目的  
简单的小游戏，可以控制角色移动，目标为寻找打败boss的方法。  
## 1.2开发工具的选择  
使用Eclipse进行开发，主要依赖于JAVA.swing和awt类进行图形化界面的操作。  
## 1.3开发环境  
系统开发平台：Eclipse  
系统开发语言：JAVA  
# 二．设计思路  
## 2.1主界面  
进行游戏的主要界面，要求角色移动操作流畅，可以暂停、继续、重新开始游戏。   
## 2.2控制台界面  
可以输入并提交谜题答案，从而打败boss，游戏胜利。  
# 三．游戏流程图  
   
# 四.实现方法  
## 4.1开始界面  
首先在Game.java中设置游戏主界面的各参数（窗口属性、画布长宽）:  
  
'''
package main;  
import javax.swing.JFrame;  
  
public class Game {  
	public static void main(String[] args) {  
		JFrame frame = new JFrame();  
		frame.setBounds(0,0,1920,1080);  
		frame.setResizable(false);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		  
		GamePanel panel = new GamePanel();
		frame.add(panel);

		frame.setVisible(true);
		
	}
}
'''
  
在GamePanel类中，写出初始化游戏的方法：   
  
'''
public void initGame() {
		isStart = false;
		isFaild = false;
		isEnd = false;
		player_x = 200;
		player_y = 200;
	}
'''
  
使用三个布尔值表示游戏进行状态（isEnd实际未使用，计划为之后写游戏后续关卡准备）。  
player_x和player_y记录了玩家坐标，初始位置为(200,200)。  
当玩家启动游戏时，调用初始化方法：  
  
'''
	public GamePanel() {
		this.setFocusable(true);
		initGame();
		this.addKeyListener(this);
		timer.start();
	}
'''
  
之后在paint(Graphics g)方法中，进行开始界面的绘制：  
  
'''
if(!isStart) {

			g.drawImage(start.getImage(), 0, 0, 1920, 1080,  null);
			g.setColor(Color.BLACK);

			g.setFont(new Font("微软雅黑",Font.BOLD,30));
			g.drawString("按下空格键",960,800);
			g.drawString("上下左右控制移动",1000,600);
		}
 '''
   
在这里，使用isStart布尔值变量检测游戏是否正在进行。  
（如果直接在开始前绘制开始画面，游戏进行中按下暂停，需要重新调用一遍绘制开始画面的方法，这里选择在paint()里绘制开始界面）  
  
 
图1 开始界面  
## 4.2主界面  
作者能力有限，只用画图工具SAI2画出了简陋的背景图和角色图片。  
玩家控制白色猫（头），上下左右键控制移动，黑色幽灵为本关boss。  
   
图2 主界面  
 
图3 向上移动  
玩家移动到屏幕边缘（实际为Graphics画布边缘）时，会自动弹开20像素，防止玩家跑出边界。这段带有边界检测的控制移动代码如下：  
  
'''
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
 
'''
  
图4 向左移动  
为了操作更加真实，向不同方向移动时，猫会面向移动方向，如上图。  
原理为简单的处理图片（水平翻转）。  
   
图5 碰撞检测前  
   
图6 碰撞检测后  
  
玩家触碰到boss会导致游戏失败，此时可以按空格键重新开始游戏。  
  
## 4.3控制台  
按下回车键打开控制台窗口：  
   
图7 控制台  
   
图8 随便输入什么  
在控制台中，上半部分为文本输入框，可以输入任意字符串。  
控制台界面的实现在InputTextFrame类中，方法和主界面相似，这里展示事件响应部分：  
  
'''
private void tfEvent()
	{


		bt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(tf.getText().equals("你是萌萌"))
				{
					tf.setText("你的对手看到“你是萌萌”，以为自己输了，于是你获得了胜利！");
				}else if(tf.getText().equals("你的对手看到“你是萌萌”，以为自己输了，于是你获得了胜利！"))
				{
					tf.setText("感谢游玩。软件工程18-2  xxx 制作");
				}else if(tf.getText().equals("感谢游玩。软件工程18-2  xxx 制作"))
				{
					f.setVisible(false);
				}
				else 
					{
					tf.setText("对手毫无反应");
					}
			}
		});
	}
'''
  
示例：  
输入“1234”，按下发送按钮，检测为输入字符串不是谜题答案，显示为：  
 
图9 发送后  
谜题答案：  
由于这个小游戏中，玩家失败会显示“你是萌萌”，所以向游戏boss发送“你是萌萌”，会导致boss误认为自己游戏失败，退出游戏，于是玩家获胜。  
   
图10 输入“你是萌萌”  
   
图11 发送后  
  
 
图12 继续点击发送按钮  
游戏胜利后，再次点击发送按钮，显示作者信息。  
再次点击则自动退出。  
