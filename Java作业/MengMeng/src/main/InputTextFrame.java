package main;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InputTextFrame
{
	//�����ͼ������������������
	private JFrame f;
	private JButton bt;
	private JTextField tf;

	//����
	InputTextFrame()//���췽��
	{
		madeFrame();
	}

	public void madeFrame()
	{
		f = new JFrame("����̨");

		//��Frame���л������á�
		f.setBounds(300,500,400,200);//�Կ�ܵ�λ�úʹ�С��������
		f.setLayout(new GridLayout(2,2));



		tf = new JTextField();
		f.add(tf);
		bt = new JButton("����");

		//�������ӵ�Frame��
		f.add(bt);

		//����һ�´����ϵ��¼�
		tfEvent();

		//��ʾ����
		f.setVisible(true);
	}

	private void tfEvent()
	{


		bt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(tf.getText().equals("��������"))
				{
					tf.setText("��Ķ��ֿ������������ȡ�����Ϊ�Լ����ˣ�����������ʤ����");
				}else if(tf.getText().equals("��Ķ��ֿ������������ȡ�����Ϊ�Լ����ˣ�����������ʤ����"))
				{
					tf.setText("��л���档�������18-2  �ܾ��� ����");
				}else if(tf.getText().equals("��л���档�������18-2  �ܾ��� ����"))
				{
					f.setVisible(false);
				}
				else 
					{
					tf.setText("���ֺ��޷�Ӧ");
					}
			}
		});
	}

}