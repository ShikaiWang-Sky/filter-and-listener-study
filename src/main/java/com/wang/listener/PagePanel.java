package com.wang.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PagePanel {
    public static void main(String[] args) {
        Frame frame = new Frame("这是一个窗口");       //新建一个窗体
        Panel panel = new Panel(null);              //面板
        frame.setLayout(null);                             //设置窗体的布局

        frame.setBounds(300, 300, 500, 500);
        frame.setBackground(Color.BLUE);                 //设置背景颜色
        panel.setBounds(50, 50, 300, 300);  //设置背景颜色
        panel.setBackground(Color.GREEN);

        frame.add(panel);

        frame.setVisible(true);     //设置窗体可见性

        //监听事件,监听关闭时间
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("正在关闭");
                //0:程序正常关闭
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("已关闭");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("激活");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("未激活");
            }
        });

        //监听窗口的另一种写法,避免对所有方法重写
        //new 一个 WindowAdapter(),选择要重写的方法
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
    }
}
