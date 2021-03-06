package com.yychatserver.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.yychat.model.Message;

public class ServerReceiverThread extends Thread{
	Socket s;
	public ServerReceiverThread(Socket s){
		this.s=s;
	}
	
	public void run(){
		ObjectInputStream ois;
		ObjectOutputStream oos;
		Message mess;
		try {
			ois = new ObjectInputStream(s.getInputStream());
			mess=(Message)ois.readObject();//接受聊天信息
			System.out.println(mess.getSender()+"对"+mess.getReceiver()+"说："+mess.getContent());
			
			Socket s1=(Socket)StartServer.hsmSocket.get(mess.getReceiver());
			oos=new ObjectOutputStream(s1.getOutputStream());
			oos.writeObject(mess);//转发聊天信息
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}