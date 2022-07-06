package Parkour;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends GamePanel implements ActionListener {
    public void initMenu(JFrame frame) {
        // 创建菜单及菜单选项
        JMenuBar jmb = new JMenuBar();
        JMenu jm1 = new JMenu("游戏");
        jm1.setFont(new Font("微软雅黑", Font.PLAIN, 13));// 设置菜单显示的字体
        JMenu jm2 = new JMenu("帮助");
        jm2.setFont(new Font("微软雅黑", Font.PLAIN, 13));

        JMenuItem jmi1 = new JMenuItem("开始新游戏");
        JMenuItem jmi2 = new JMenuItem("退出");
        jmi1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        jmi2.setFont(new Font("微软雅黑", Font.PLAIN, 13));

        JMenuItem jmi3 = new JMenuItem("操作说明");
        jmi3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        JMenuItem jmi4 = new JMenuItem("玩家目标");
        jmi4.setFont(new Font("微软雅黑", Font.PLAIN, 13));

        jm1.add(jmi1);
        jm1.add(jmi2);

        jm2.add(jmi3);
        jm2.add(jmi4);

        jmb.add(jm1);
        jmb.add(jm2);
        frame.setJMenuBar(jmb);// 菜单Bar放到JFrame上
        jmi1.addActionListener(this);
        jmi1.setActionCommand("Restart");
        jmi2.addActionListener(this);
        jmi2.setActionCommand("Exit");

        jmi3.addActionListener(this);
        jmi3.setActionCommand("help1");
        jmi4.addActionListener(this);
        jmi4.setActionCommand("help2");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.BOLD, 18)));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.BOLD, 18)));
        if ("Exit".equals(command)) {
            Object[] options = {"确定", "取消"};
            int response = JOptionPane.showOptionDialog(this,
                    "您确认要退出吗？", "提示！",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);
            if (response == 0) {
                System.exit(0);
            }
        } else if ("Restart".equals(command)) {
            isStart = false;
            repaint();
            Object[] options = {"确定", "取消"};
            int response = JOptionPane.showOptionDialog(this,
                    "正在游戏中，您确认要重新开始吗",
                    "提示！", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);
            if (response == 0) {
                //直接结束游戏
                GameOver = true;
                endGame();
            }

        } else if ("help1".equals(command)) {
            JOptionPane.showMessageDialog(null,
                    "用上和下方向键控制特朗普跳跃或滑行，躲避障碍物。",
                    "提示！", JOptionPane.INFORMATION_MESSAGE);
        } else if ("help2".equals(command)) {
            JOptionPane.showMessageDialog(null,
                    "被障碍物撞到游戏失败，强者是没有终点的，尽力坚持更长时间吧！",
                    "提示！", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
