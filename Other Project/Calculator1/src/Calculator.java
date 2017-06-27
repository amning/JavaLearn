//package com.shiyann.calculator;
import javax.swing.*;
import java.awt.*;
public class Calculator {

	JFrame frame = new JFrame("Calculator");
	String result;
	JTextField result_TextField = new JTextField(result,20);//创建可以显示20行的文本框
	/*
	 *1、按钮创建
	 */
	//清除按钮创建
	
	JButton clear_Button = new JButton("clear");
	
	//数字键
	
	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	
	//计算按钮与小数点
	
	JButton button_dian = new JButton(".");
	JButton button_jia = new JButton("+");
	JButton button_jian = new JButton("-");
	JButton button_cheng = new JButton("*");
	JButton button_chu = new JButton("/");
	JButton button_deng = new JButton("=");
	
	/*
	 *2、JPanel创建   
	 *	然后把按钮添加到JPanel容器中来 
	 */
	
	//创建容器
	
	JPanel p = new JPanel();
	p.setLayout(new Gridyout(4,4,5,5));
	
	p.add
	//设置容器大小
	

}
