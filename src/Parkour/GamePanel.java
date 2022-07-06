package Parkour;

import Parkour.movements.Obstacles;
import Parkour.movements.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    public static boolean isStart = false;//判断游戏是否正在运行
    public static boolean GameOver = false;//判断游戏是否结束

    public static double score = 0;//判断分数

    public Timer timer = new Timer(10, this);//定时器

    //构造器
    public GamePanel() {
        init();
        //获取键盘的监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        //让时间动起来
        timer.start();
    }

    //初始化
    public void init() {
        Player.playerInit();
        Obstacles.obstaclesInit();
        score = 0;
    }


    //画板：画界面，画小人
    //Graphic：画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.CYAN);//设置背景颜色

        //绘制跑酷背景
        Data.BackGround.paintIcon(this, g, 0, 0);

        //绘制玩家-滑行或奔跑
        if (!Player.isSlide && Player.fly == 0) {
            Data.PlayerRun.paintIcon(this, g, Player.playerX, Player.playerY);
        } else if (Player.isSlide) {
            Data.PlayerSlide.paintIcon(this, g, Player.playerX - 10,
                    Player.playerY - 10);
        }

        //绘制玩家-一段跳或二段跳
        if (Player.fly == 1 && !Player.isSlide) {
            Data.PlayerJump1.paintIcon(this, g, Player.playerX, Player.playerY);
        } else if (Player.fly == 2 && !Player.isSlide) {
            Data.PlayerJump2.paintIcon(this, g, Player.playerX, Player.playerY);
        }


        //绘制障碍物
        Data.obstacles11.paintIcon(this, g, Obstacles.obstacle11X, Obstacles.obstacle11Y);
        Data.obstacles21.paintIcon(this, g, Obstacles.obstacle21X, Obstacles.obstacle21Y);
        Data.obstacles31.paintIcon(this, g, Obstacles.obstacle31X, Obstacles.obstacle31Y);
        Data.obstacles12.paintIcon(this, g, Obstacles.obstacle12X, Obstacles.obstacle12Y);
        Data.obstacles22.paintIcon(this, g, Obstacles.obstacle22X, Obstacles.obstacle22Y);
        Data.obstacles32.paintIcon(this, g, Obstacles.obstacle32X, Obstacles.obstacle32Y);


        //游戏提示：是否开始
        if (!isStart) {
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 390, 300);
        }

        //绘制分数提示
        g.setColor(Color.red);
        g.setFont(new Font("楷体", Font.BOLD, 35));
        g.drawString("分数：" + (int)score, 800, 50);

    }


    public static int keyCode;
    @Override
    public void keyPressed(KeyEvent e) {
        //获取按下的键盘是哪个键
        keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_SPACE) {//按下空格
            isStart = !isStart;
            repaint();
        }

        if (isStart && (Player.fly == 0 || Player.fly == 1)
                && keyCode == KeyEvent.VK_UP) {//按下向上方向键以跳跃
            Player.posY = 1;
            Player.fly++;
            Player.up = 1;
        }

        if (isStart && !Player.isSlide
                && keyCode == KeyEvent.VK_DOWN) {//按下向下方向键以滑行
            Player.isSlide = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //获取按下的键盘是哪个键
        keyCode = e.getKeyCode();

        if (isStart && Player.isSlide && keyCode == KeyEvent.VK_DOWN) {//按下向下方向键以滑行
            Player.isSlide = false;
        }
    }

    //定时器，监听时间，帧：执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于开始状态
        if (isStart) {
            //障碍物移动
            Obstacles.moveObstacles1();

            if (score > 60){
                Obstacles.moveObstacles2();
            }

            score += 0.4;

            //相撞事件
            GameOver = Player.crash();

            //相撞判断
            endGame();

            //玩家跳跃
            if (Player.fly == 1 || Player.fly == 2) {
                Player.jump();
            }
            repaint();
        }
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void endGame(){
        if (GameOver){
            isStart = false;
            repaint();
            Object[] options = {"确定", "取消"};
            int response = JOptionPane.showOptionDialog(this,
                    "很遗憾，特朗普倒在了通往自由的路上\n您的分数是：" + (int)score + "\n请问您要重新开始吗？",
                    "GameOver",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (response == 0) {
                //初始化
                init();
                isStart = true;
            }else {
                System.exit(0);
            }
        }
    }

}
