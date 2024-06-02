package Minesweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MinesweeperVisual extends JFrame {
    JTextField widthField, heightFeild, mineFeild;
    String width, height, mines;
    JButton startButton;
    JPanel gamePanel;
    public MinesweeperVisual(){
        setLayout(new GridLayout(4, 2));
        widthField= new JTextField();
        heightFeild = new JTextField();
        mineFeild = new JTextField();
        startButton = new JButton("start");
        widthField.setSize(new Dimension(100,50));
        heightFeild.setSize(new Dimension(100,50));
        mineFeild.setSize(new Dimension(100,50));
        add(widthField);
        add(heightFeild);
        add(mineFeild);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        startButton.setSize(new Dimension(100,50));
        add(startButton);
        pack();
        setVisible(true);
    }
    private void startGame(){
        width = widthField.getText();
        height = heightFeild.getText();
        mines = mineFeild.getText();
        remove(widthField);
        remove(heightFeild);
        remove(mineFeild);
        remove(startButton);
        setLayout(new GridLayout(1,1));
        gamePanel = new JPanel();
        gamePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(gamePanel);
        revalidate();
        repaint();
    }
}
