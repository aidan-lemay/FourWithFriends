import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Client extends JFrame implements ActionListener {
  //create variables
  JPanel mainGrid = new JPanel(new GridLayout(0, 7));

  //items for menu
  private JMenuBar mBar;
  private JMenu mGame;
  private JMenuItem mConnect;
  private JMenuItem mHelp;
  private JMenuItem mExit;
  private JRadioButtonMenuItem rbMenuItem;
  private JCheckBoxMenuItem cbMenuItem;

  //icons
  ImageIcon white = new ImageIcon("ClientAssets/white64.png");
  ImageIcon blue = new ImageIcon("ClientAssets/blue64.png");
  ImageIcon orange = new ImageIcon("ClientAssets/orange64.png");

  //Labels
  //Row 1 (starting from the bottom)
  JLabel R1C1 = new JLabel(white);
  JLabel R1C2 = new JLabel(white);
  JLabel R1C3 = new JLabel(white);
  JLabel R1C4 = new JLabel(white);
  JLabel R1C5 = new JLabel(white);
  JLabel R1C6 = new JLabel(white);
  JLabel R1C7 = new JLabel(white);

  //Row 2
  JLabel R2C1 = new JLabel(white);
  JLabel R2C2 = new JLabel(white);
  JLabel R2C3 = new JLabel(white);
  JLabel R2C4 = new JLabel(white);
  JLabel R2C5 = new JLabel(white);
  JLabel R2C6 = new JLabel(white);
  JLabel R2C7 = new JLabel(white);

  //Row 3
  JLabel R3C1 = new JLabel(white);
  JLabel R3C2 = new JLabel(white);
  JLabel R3C3 = new JLabel(white);
  JLabel R3C4 = new JLabel(white);
  JLabel R3C5 = new JLabel(white);
  JLabel R3C6 = new JLabel(white);
  JLabel R3C7 = new JLabel(white);

  //Row 4
  JLabel R4C1 = new JLabel(white);
  JLabel R4C2 = new JLabel(white);
  JLabel R4C3 = new JLabel(white);
  JLabel R4C4 = new JLabel(white);
  JLabel R4C5 = new JLabel(white);
  JLabel R4C6 = new JLabel(white);
  JLabel R4C7 = new JLabel(white);

  //Row 5
  JLabel R5C1 = new JLabel(white);
  JLabel R5C2 = new JLabel(white);
  JLabel R5C3 = new JLabel(white);
  JLabel R5C4 = new JLabel(white);
  JLabel R5C5 = new JLabel(white);
  JLabel R5C6 = new JLabel(white);
  JLabel R5C7 = new JLabel(white);

  //Row 6
  JLabel R6C1 = new JLabel(white);
  JLabel R6C2 = new JLabel(white);
  JLabel R6C3 = new JLabel(white);
  JLabel R6C4 = new JLabel(white);
  JLabel R6C5 = new JLabel(white);
  JLabel R6C6 = new JLabel(white);
  JLabel R6C7 = new JLabel(white);

  //Buttons (starting from the left)
  JButton C1Button = new JButton("Drop Piece");
  JButton C2Button = new JButton("Drop Piece");
  JButton C3Button = new JButton("Drop Piece");
  JButton C4Button = new JButton("Drop Piece");
  JButton C5Button = new JButton("Drop Piece");
  JButton C6Button = new JButton("Drop Piece");
  JButton C7Button = new JButton("Drop Piece");




  //constructor
  public Client(){

    //Create the menu bar.
    mBar = new JMenuBar();

    //Build the file menu.
    mGame = new JMenu("Game");
    mBar.add(mGame);

    //make and add JMenuItems
    mConnect = new JMenuItem("Connect");
    mConnect.addActionListener(this);
    mGame.add(mConnect);

    mHelp = new JMenuItem("Help");
    mHelp.addActionListener(this);
    mGame.add(mHelp);

    mExit = new JMenuItem("Exit");
    mExit.addActionListener(this);
    mGame.add(mExit);

    //set menu bar
    setJMenuBar(mBar);

    //main grid
    mainGrid.setBackground(new Color(0, 0, 0));

    add(mainGrid, BorderLayout.CENTER);

    //add objects to main grid
    mainGrid.add(C1Button);
    mainGrid.add(C2Button);
    mainGrid.add(C3Button);
    mainGrid.add(C4Button);
    mainGrid.add(C5Button);
    mainGrid.add(C6Button);
    mainGrid.add(C7Button);

    mainGrid.add(R6C1);
    mainGrid.add(R6C2);
    mainGrid.add(R6C3);
    mainGrid.add(R6C4);
    mainGrid.add(R6C5);
    mainGrid.add(R6C6);
    mainGrid.add(R6C7);

    mainGrid.add(R5C1);
    mainGrid.add(R5C2);
    mainGrid.add(R5C3);
    mainGrid.add(R5C4);
    mainGrid.add(R5C5);
    mainGrid.add(R5C6);
    mainGrid.add(R5C7);

    mainGrid.add(R4C1);
    mainGrid.add(R4C2);
    mainGrid.add(R4C3);
    mainGrid.add(R4C4);
    mainGrid.add(R4C5);
    mainGrid.add(R4C6);
    mainGrid.add(R4C7);

    mainGrid.add(R3C1);
    mainGrid.add(R3C2);
    mainGrid.add(R3C3);
    mainGrid.add(R3C4);
    mainGrid.add(R3C5);
    mainGrid.add(R3C6);
    mainGrid.add(R3C7);

    mainGrid.add(R2C1);
    mainGrid.add(R2C2);
    mainGrid.add(R2C3);
    mainGrid.add(R2C4);
    mainGrid.add(R2C5);
    mainGrid.add(R2C6);
    mainGrid.add(R2C7);

    mainGrid.add(R1C1);
    mainGrid.add(R1C2);
    mainGrid.add(R1C3);
    mainGrid.add(R1C4);
    mainGrid.add(R1C5);
    mainGrid.add(R1C6);
    mainGrid.add(R1C7);

  }

  //ActionListener things
  public void actionPerformed(ActionEvent event){
      //set object
      Object obj = event.getSource();

      if (obj == mConnect){
        String stPort = JOptionPane.showInputDialog( null, "Input Server Port \n Or click OK for default", "123456");
        int port = Integer.parseInt(stPort);
        String ip = JOptionPane.showInputDialog(null, "Input Server IP \n Or Click OK for default", "123.456.7.89");

        System.out.println("STPort " + stPort + " Port " + port + " IP " + ip);
      }
      if (obj == mExit){
        System.exit(0);
      }



   }

  //main
  public static void main(String[] args) {
    Client frame = new Client();
    frame.setTitle("FourWithFriends");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 600);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void socketConnect (String pasIP, int pasPT) throws UnknownHostException, IOException {
    Socket soc = new Socket (pasIP, pasPT);
  }


}
