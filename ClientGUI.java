import java.net.*;						
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ClientGUI extends JFrame implements ActionListener {

    Color empty = new Color(0, 0, 0);
    Color Reds = new Color(255, 0, 0);
    Color Yellows = new Color(255, 215, 0);


    public JButton jb11;
    public JButton jb12;
    public JButton jb13;
    public JButton jb14;
    public JButton jb15;
    public JButton jb16;
    public JButton jb17;

    public JButton jb21;
    public JButton jb22;
    public JButton jb23;
    public JButton jb24;
    public JButton jb25;
    public JButton jb26;
    public JButton jb27;

    public JButton jb31;
    public JButton jb32;
    public JButton jb33;
    public JButton jb34;
    public JButton jb35;
    public JButton jb36;
    public JButton jb37;

    public JButton jb41;
    public JButton jb42;
    public JButton jb43;
    public JButton jb44;
    public JButton jb45;
    public JButton jb46;
    public JButton jb47;

    public JButton jb51;
    public JButton jb52;
    public JButton jb53;
    public JButton jb54;
    public JButton jb55;
    public JButton jb56;
    public JButton jb57;

    public JButton jb61;
    public JButton jb62;
    public JButton jb63;
    public JButton jb64;
    public JButton jb65;
    public JButton jb66;
    public JButton jb67;

    public ClientGUI() {
        JPanel jpMain = new JPanel(new GridLayout(6,1));

        JPanel jpOne = new JPanel(new GridLayout(0,7));

        jb11 = new JButton();
        jb11.setBackground(empty);
        jb12 = new JButton();
        jb12.setBackground(empty);
        jb13 = new JButton();
        jb13.setBackground(empty);
        jb14 = new JButton();
        jb14.setBackground(empty);
        jb15 = new JButton();
        jb15.setBackground(empty);
        jb16 = new JButton();
        jb16.setBackground(empty);
        jb17 = new JButton();
        jb17.setBackground(empty);

        jpOne.add(jb11);
        jpOne.add(jb12);
        jpOne.add(jb13);
        jpOne.add(jb14);
        jpOne.add(jb15);
        jpOne.add(jb16);
        jpOne.add(jb17);

        jpMain.add(jpOne);

        JPanel jpTwo = new JPanel(new GridLayout(0,7));

        jb21 = new JButton();
        jb21.setBackground(empty);
        jb22 = new JButton();
        jb22.setBackground(empty);
        jb23 = new JButton();
        jb23.setBackground(empty);
        jb24 = new JButton();
        jb24.setBackground(empty);
        jb25 = new JButton();
        jb25.setBackground(empty);
        jb26 = new JButton();
        jb26.setBackground(empty);
        jb27 = new JButton();
        jb27.setBackground(empty);

        jpTwo.add(jb21);
        jpTwo.add(jb22);
        jpTwo.add(jb23);
        jpTwo.add(jb24);
        jpTwo.add(jb25);
        jpTwo.add(jb26);
        jpTwo.add(jb27);

        jpMain.add(jpTwo);

        JPanel jpThree = new JPanel(new GridLayout(0,7));

        jb31 = new JButton();
        jb31.setBackground(empty);
        jb32 = new JButton();
        jb32.setBackground(empty);
        jb33 = new JButton();
        jb33.setBackground(empty);
        jb34 = new JButton();
        jb34.setBackground(empty);
        jb35 = new JButton();
        jb35.setBackground(empty);
        jb36 = new JButton();
        jb36.setBackground(empty);
        jb37 = new JButton();
        jb37.setBackground(empty);

        jpThree.add(jb31);
        jpThree.add(jb32);
        jpThree.add(jb33);
        jpThree.add(jb34);
        jpThree.add(jb35);
        jpThree.add(jb36);
        jpThree.add(jb37);

        jpMain.add(jpThree);

        JPanel jpFour = new JPanel(new GridLayout(0,7));

        jb41 = new JButton();
        jb41.setBackground(empty);
        jb42 = new JButton();
        jb42.setBackground(empty);
        jb43 = new JButton();
        jb43.setBackground(empty);
        jb44 = new JButton();
        jb44.setBackground(empty);
        jb45 = new JButton();
        jb45.setBackground(empty);
        jb46 = new JButton();
        jb46.setBackground(empty);
        jb47 = new JButton();
        jb47.setBackground(empty);

        jpFour.add(jb41);
        jpFour.add(jb42);
        jpFour.add(jb43);
        jpFour.add(jb44);
        jpFour.add(jb45);
        jpFour.add(jb46);
        jpFour.add(jb47);

        jpMain.add(jpFour);

        JPanel jpFive = new JPanel(new GridLayout(0,7));

        jb51 = new JButton();
        jb51.setBackground(empty);
        jb52 = new JButton();
        jb52.setBackground(empty);
        jb53 = new JButton();
        jb53.setBackground(empty);
        jb54 = new JButton();
        jb54.setBackground(empty);
        jb55 = new JButton();
        jb55.setBackground(empty);
        jb56 = new JButton();
        jb56.setBackground(empty);
        jb57 = new JButton();
        jb57.setBackground(empty);

        jpFive.add(jb51);
        jpFive.add(jb52);
        jpFive.add(jb53);
        jpFive.add(jb54);
        jpFive.add(jb55);
        jpFive.add(jb56);
        jpFive.add(jb57);

        jpMain.add(jpFive);

        JPanel jpSix = new JPanel(new GridLayout(0,7));

        jb61 = new JButton();
        jb61.setBackground(empty);
        jb62 = new JButton();
        jb62.setBackground(empty);
        jb63 = new JButton();
        jb63.setBackground(empty);
        jb64 = new JButton();
        jb64.setBackground(empty);
        jb65 = new JButton();
        jb65.setBackground(empty);
        jb66 = new JButton();
        jb66.setBackground(empty);
        jb67 = new JButton();
        jb67.setBackground(empty);

        jpSix.add(jb61);
        jpSix.add(jb62);
        jpSix.add(jb63);
        jpSix.add(jb64);
        jpSix.add(jb65);
        jpSix.add(jb66);
        jpSix.add(jb67);

        jpMain.add(jpSix);

        add(jpMain);

    }

    public static void main (String [] args){
        ClientGUI cgi = new ClientGUI();
        cgi.setTitle("FourWithFriends");
        cgi.setLocationRelativeTo(null);
        cgi.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cgi.setPreferredSize(new Dimension(300, 200));
        cgi.pack();
        cgi.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        Object choice = ae.getSource();
        
    }
}