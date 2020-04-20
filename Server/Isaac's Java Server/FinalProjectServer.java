import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class FinalProjectServer extends JFrame implements ActionListener {
   //Create all networking items
      //Create socket
      ServerSocket serverSocket;
      //Define default port number - change number to change default port
      int portNum = 9234;
   //Create all GUI items
      JLabel staticStatus = new JLabel("Server status: ");
      JLabel serverStatus = new JLabel();
      JLabel serverIP = new JLabel("Server IP: N/A");
      JButton start = new JButton("Start");
      JButton exit = new JButton("Exit");
      
   
   
   //default constructor
   public FinalProjectServer() {
      //default server icon to offline
      serverStatus.setIcon(new ImageIcon(new ImageIcon("offline_icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
      
      //Window setup
      JPanel statusRow = new JPanel(new FlowLayout());
         statusRow.add(staticStatus);
         statusRow.add(serverStatus);
         
      JPanel infoRow = new JPanel (new FlowLayout());
         infoRow.add(serverIP);
      
      JPanel controlRow1 = new JPanel(new FlowLayout());
         controlRow1.add(start);
         start.addActionListener(this);
         controlRow1.add(exit);
         exit.addActionListener(this);
         
      
      JPanel mainPanel = new JPanel(new GridLayout(0, 1));
         mainPanel.add(statusRow);
         mainPanel.add(infoRow);
         mainPanel.add(controlRow1);
         
         add(mainPanel, BorderLayout.CENTER);
   }
   
   //overloaded constructor - accepts port input
   public FinalProjectServer(int _portNum) {
      //change portnum
      portNum = _portNum;
      
      //default server icon to offline
      serverStatus.setIcon(new ImageIcon(new ImageIcon("offline_icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
      
      //Window setup
      JPanel statusRow = new JPanel(new FlowLayout());
         statusRow.add(staticStatus);
         statusRow.add(serverStatus);
         
      JPanel infoRow = new JPanel (new FlowLayout());
         infoRow.add(serverIP);
      
      JPanel controlRow1 = new JPanel(new FlowLayout());
         controlRow1.add(start);
         start.addActionListener(this);
         controlRow1.add(exit);
         exit.addActionListener(this);
         
      
      JPanel mainPanel = new JPanel(new GridLayout(0, 1));
         mainPanel.add(statusRow);
         mainPanel.add(infoRow);
         mainPanel.add(controlRow1);
         
         add(mainPanel, BorderLayout.CENTER);
   }
   
   //methods
   String getLocalIP() {
      String store;
      try {
         store = (InetAddress.getLocalHost()).getHostAddress() + ":" + portNum;
      } catch (UnknownHostException uhe) {
         System.out.println(uhe);
         store = "Error Initializing Server";
      }
      return store;
   }
   
   
   //action events
   public void actionPerformed(ActionEvent event){
      //set object
      Object obj = event.getSource();
      
      if (obj == start) {
         //start server
         try {
            serverSocket = new ServerSocket(portNum);
            serverStatus.setIcon(new ImageIcon(new ImageIcon("online_icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
         } catch (IOException ioe) {
            System.out.println("ERROR: " + ioe + "\n" + "Cannot host using port " + portNum);
            serverStatus.setIcon(new ImageIcon(new ImageIcon("offline_icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
         }
         //update server address
         serverIP.setText("Server IP: " + getLocalIP());
      }
      
      if (obj == exit) {
         System.exit(0);
      }
      
   }
   
   
   public static void main(String[] args) {
      //declare frame
      FinalProjectServer frame;
      
      //initialize frame
      if (args.length == 0) {
         frame = new FinalProjectServer();
      }
      else {
         System.out.println(Integer.parseInt(args[0]));
         frame = new FinalProjectServer(Integer.parseInt(args[0]));
      }
      
      //setup for window
      frame.setTitle("FinalProjectServer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300, 120);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
   }
}