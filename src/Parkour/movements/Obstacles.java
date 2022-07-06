package Parkour.movements;


import Parkour.GamePanel;

import java.util.Random;

public class Obstacles extends GamePanel {

    public static int movementSpeed; //障碍物移动速度

    public static int obstacle11X;//障碍物1坐标X
    public static int obstacle11Y;//障碍物1坐标Y

    public static int obstacle21X;//障碍物1坐标X
    public static int obstacle21Y;//障碍物1坐标Y

    public static int obstacle31X;//障碍物1坐标X
    public static int obstacle31Y;//障碍物1坐标Y

    public static int obstacle12X;//障碍物1坐标X
    public static int obstacle12Y;//障碍物1坐标Y

    public static int obstacle22X;//障碍物1坐标X
    public static int obstacle22Y;//障碍物1坐标Y

    public static int obstacle32X;//障碍物1坐标X
    public static int obstacle32Y;//障碍物1坐标Y

    public static int type1 = 1;//障碍物种类判定
    public static int type2 = 1;//障碍物种类判定

    //初始化障碍物
    public static void obstaclesInit() {

        obstacle11X = 1200;
        obstacle21X = 1200;
        obstacle31X = 1200;
        obstacle12X = 1200;
        obstacle22X = 1200;
        obstacle32X = 1200;

        obstacle11Y = 340;
        obstacle21Y = 250;
        obstacle31Y = 220;
        obstacle12Y = 340;
        obstacle22Y = 250;
        obstacle32Y = 220;

        movementSpeed = 5;
    }


    //障碍物移动
    public static void moveObstacles1() {
        if (type1 == 1) {
            if (obstacle11X > -200) {
                obstacle11X -= movementSpeed;
            } else {
                type1 = replaceType();
                obstacle11X = 1200;
            }
        } else if (type1 == 2) {
            if (obstacle21X > -200) {
                obstacle21X -= movementSpeed;
            } else {
                type1 = replaceType();
                obstacle21X = 1200;
            }
        }else if (type1 == 3){
            if (obstacle31X > -200) {
                obstacle31X -= movementSpeed;
            } else {
                type1 = replaceType();
                obstacle31X = 1200;
            }
        }
    }

    public static void moveObstacles2() {
        if (type2 == 1) {
            if (obstacle12X > -200) {
                obstacle12X -= movementSpeed;
            } else {
                type2 = replaceType();
                obstacle12X = 1200;
            }
        } else if (type2 == 2) {
            if (obstacle22X > -200) {
                obstacle22X -= movementSpeed;
            } else {
                type2 = replaceType();
                obstacle22X = 1200;
            }
        }else if (type2 == 3){
            if (obstacle32X > -200) {
                obstacle32X -= movementSpeed;
            } else {
                type2 = replaceType();
                obstacle32X = 1200;
            }
        }
    }

    //替换障碍物
    public static int replaceType() {
        return new Random().nextInt(3) + 1;
    }
}
