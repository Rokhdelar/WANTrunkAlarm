package com.x;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

/**
 * Created by X on 14/9/12.
 */
public class mainForm extends JFrame{
    private JPanel mainPanel;
    private JTabbedPane tabbedPanel;
    private JPanel bottomPanel;
    private JPanel stateTab;
    private JPanel settingTab;
    private JTextArea settingTextArea;
    private JButton closeButton;
    private JButton redSettingButton;
    private JButton saveSettingButton;
    private JButton readSettingButton;

    private String fileName;

    public mainForm(){
        super();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("城域网中继监视...");
        setSize(600, 450);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        setVisible(true);

        fileName="trunkportinfo.json";


        saveSettingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSetting();
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        readSettingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



    public static void main(String[] args) {
        new mainForm();
    }

    private void readSetting(){
        //读取配置文件。
        try{
            File file=new File(fileName);
            Long fileLength=file.length();
            byte[] fileContent=new byte[fileLength.intValue()];
            FileInputStream fileInputStream=new FileInputStream(file);
            fileInputStream.read(fileContent);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void saveSetting() {
        //保存配置文件。

        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(fileName);

            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.write(settingTextArea.getText());

            fileWriter.close();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
