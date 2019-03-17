package com.yychatclient.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FriendChat extends JFrame implements ActionListener{
	JTextArea jta;
	JScrollPane jsp;
	
	JPanel jp;
	JTextField jtf;
	JButton jb;
	
	
	public FriendChat(String sender,String receiver) {
		jta=new JTextArea();
		jta.setEditable(false);
		jta.setForeground(Color.red);
		jsp=new JScrollPane(jta);
		this.add(jsp);
		
		jp=new JPanel();
		jtf=new JTextField(15);
		jtf.setForeground(Color.red);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp.add(jtf);
		jp.add(jb);
		this.add(jp,"South");
		
		this.setTitle(sender+"正在和"+receiver+"聊天");
		this.setSize(350,240);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		//FriendChat friendChat=new FriendChat("1","2");
		
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb) jta.append(jtf.getText()+"\r\n");
		
	}
	
	

}
