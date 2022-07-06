package Parkour;

import javax.swing.*;

public class StartGames {

    //1.绘制一个静态窗口 JFrame
    public static JFrame frame = new JFrame("迷你特朗普——————不醒人室出品");

    public static void main(String[] args) {

        //1.绘制一个静态窗口 JFrame
        frame.setBounds(150,100,1090,595);//设置界面的大小
        frame.setResizable(false);//设置窗口大小不可以改变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭事件，游戏可以关闭了

        startGames(frame);

    }

    public static void startGames(JFrame frame) {

        //2.面板 JPanel   可以加入到JFrame
        frame.add(new GamePanel());

        //3.菜单JMenu     添加菜单
        new Menu().initMenu(frame);

        frame.setVisible(true);//让窗口能够展现出来
    }

}
