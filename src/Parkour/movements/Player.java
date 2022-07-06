package Parkour.movements;

import Parkour.GamePanel;

public class Player extends GamePanel {

    public static int playerX;//玩家坐标X
    public static int playerY;//玩家坐标Y

    //判断玩家运动状态
    public static int up;//判断玩家跳跃阶段
    public static int fly;//判断玩家是一段跳还是二段跳
    public static int posY;//判断玩家是否该下落
    public  static boolean isSlide;//判断玩家是否滑行

    //玩家初始化
    public static void playerInit(){
        playerX = 130;
        playerY = 400;

        up = 1;
        fly = 0;
        posY = 1;
        isSlide = false;
    }

    //玩家跳跃方法
    public static void jump() {
        if (up == 1) {
            playerY -= 6;
            posY += 6;
            if (posY >= 175){
                up = 0;
            }
        } else if (up == 0) {
            playerY += 5;
            if (playerY >= 400){
                up = -1;
            }
        } else if (up == -1){
            playerY = 400;
            posY = 1;
            fly = 0;
        }
    }

    public static boolean crash(){
        boolean crash = false;

        int ob1 = 55;
        int ob2 = 35;

        //撞击障碍物判定
        if (playerX < Obstacles.obstacle11X + ob1
                && playerY > Obstacles.obstacle11Y - 35
                && playerX > Obstacles.obstacle11X - ob2){
            crash = true;
        } else if (playerX < Obstacles.obstacle12X + ob1
                && playerY > Obstacles.obstacle12Y - 35
                && playerX > Obstacles.obstacle12X - ob2){
            crash = true;
        } else if(playerX < Obstacles.obstacle21X + ob1
                && playerY > Obstacles.obstacle21Y - 50
                && playerX > Obstacles.obstacle21X - ob2){
            crash = true;
        } else if (playerX < Obstacles.obstacle22X + ob1
                && playerY > Obstacles.obstacle22Y - 50
                && playerX > Obstacles.obstacle22X - ob2){
            crash = true;
        } else if (playerX < Obstacles.obstacle31X + ob1
                && playerY < Obstacles.obstacle31Y + 182
                && playerY > Obstacles.obstacle21Y - 120
                && playerX > Obstacles.obstacle31X - ob2
                && !isSlide){
            crash = true;
        } else if (playerX < Obstacles.obstacle32X + ob1
                && playerY < Obstacles.obstacle32Y + 182
                && playerY > Obstacles.obstacle21Y - 120
                && playerX > Obstacles.obstacle32X - ob2
                && !isSlide) {
            crash = true;
        }
        return crash;
    }
}
