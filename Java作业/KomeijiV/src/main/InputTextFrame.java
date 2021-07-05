package main;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InputTextFrame
{
	//定义该图形中所需的组件的引用
	private JFrame f;
	private JButton bt;
	private JTextField tf;

	//方法
	InputTextFrame()//构造方法
	{
		madeFrame();
	}

	public void madeFrame()
	{
		f = new JFrame("和小觉说话！");

		//对Frame进行基本设置。
		f.setBounds(300,500,400,200);//对框架的位置和大小进行设置
		f.setLayout(new GridLayout(2,2));



		tf = new JTextField();
		f.add(tf);
		bt = new JButton("发送");

		//将组件添加到Frame中
		f.add(bt);

		//加载一下窗体上的事件
		tfEvent();

		//显示窗体
		f.setVisible(true);
	}

	private void tfEvent()
	{


		bt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(tf.getText().equals("admin"))
				{
					tf.setText("TODO:接入聊天机器人");
				}else if(tf.getText().equals("退出"))
				{
					tf.setText("感谢游玩。软件工程18-2  xxx 制作");
				}else if(tf.getText().equals("感谢游玩。软件工程18-2  xxx 制作"))
				{
					f.setVisible(false);
				}
				else 
					{
					tf.setText("小觉目前还听不懂你说的话");
					}
			}
		});
	}

}
