package Parkour;

import javax.swing.*;
import java.net.URL;

//存放外部数据
public class Data {
    //背景图片  URL：定位图片地址      ImageIcon：图片
    public static URL BackGroundURL = Data.class.getResource("statics/bg/pbg.png");
    public static ImageIcon BackGround = new ImageIcon(BackGroundURL);

    //玩家跑步图片
    public static URL PlayerRunURL = Data.class.getResource("statics/player/run.png");
    public static ImageIcon PlayerRun = new ImageIcon(PlayerRunURL);

    //玩家跳跃图片
    public static URL PlayerJump1URL = Data.class.getResource("statics/player/jump1.png");
    public static ImageIcon PlayerJump1 = new ImageIcon(PlayerJump1URL);

    //玩家二段跳图片
    public static URL PlayerJump2URL = Data.class.getResource("statics/player/jump2.png");
    public static ImageIcon PlayerJump2 = new ImageIcon(PlayerJump2URL);

    //玩家滑行图片
    public static URL PlayerSlideURL = Data.class.getResource("statics/player/slide.png");
    public static ImageIcon PlayerSlide = new ImageIcon(PlayerSlideURL);

    //障碍物11
    public static URL obstacles11URL = Data.class.getResource("statics/obstacles/ob1.png");
    public static ImageIcon obstacles11 = new ImageIcon(obstacles11URL);

    //障碍物21
    public static URL obstacles21URL = Data.class.getResource("statics/obstacles/ob2.png");
    public static ImageIcon obstacles21 = new ImageIcon(obstacles21URL);

    //障碍物31
    public static URL obstacles31URL = Data.class.getResource("statics/obstacles/ob3.png");
    public static ImageIcon obstacles31 = new ImageIcon(obstacles31URL);

    //障碍物12
    public static URL obstacles12URL = Data.class.getResource("statics/obstacles/ob1.png");
    public static ImageIcon obstacles12 = new ImageIcon(obstacles12URL);

    //障碍物22
    public static URL obstacles22URL = Data.class.getResource("statics/obstacles/ob2.png");
    public static ImageIcon obstacles22 = new ImageIcon(obstacles22URL);

    //障碍物32
    public static URL obstacles32URL = Data.class.getResource("statics/obstacles/ob3.png");
    public static ImageIcon obstacles32 = new ImageIcon(obstacles32URL);
}
