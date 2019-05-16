package lesson_13.gui;

import lesson_13.Cell;
import lesson_13.GeneratorBoard;
import lesson_13.logics.Easy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    private static final JPanel controlPanel = new JPanel();
    private static final GUIBoard board = new GUIBoard();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame();
                frame.setTitle("Сапер");
                frame.setLayout(new BorderLayout());
                frame.setSize(500, 500);
                frame.add(board, BorderLayout.CENTER);
                board.setBorder(new EmptyBorder(10, 10, 10, 10));
                frame.add(controlPanel, BorderLayout.PAGE_END);
                controlPanel.setLayout(new FlowLayout());
                final JButton generate = new JButton("Начать");
                generate.addActionListener(
                        new GUIAction(
                                new Easy(), board, new GeneratorBoard() {
                            @Override
                            public Cell[][] generate() {
                                return new Cell[][]{{new GUICell(true), new GUICell(false), new GUICell(false)},
                                        {new GUICell(false), new GUICell(false), new GUICell(false)},
                                        {new GUICell(false), new GUICell(false), new GUICell(true)}};
                            }
                        }
                        )
                );
                controlPanel.add(generate);
                centre(frame);
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        closePerfom(frame);
                    }
                });
                frame.setVisible(true);
            }
        });
    }

    public static void centre(Window w) {
        Dimension us = w.getSize();
        Dimension them = Toolkit.getDefaultToolkit().getScreenSize();
        int newX = (them.width - us.width) / 2;
        int newY = (them.height - us.height) / 2;
        w.setLocation(newX, newY);

    }

    public static void closePerfom(JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }

}
