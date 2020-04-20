import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalProjectClient extends JFrame implements ActionListener {
   //create all items
      
   
   
   
   public FinalProjectClient() {
      //set container
      Container container = getContentPane();
      
      
      
   }
   
   
   public void actionPerformed(ActionEvent event){
      //set object
      Object obj = event.getSource();
      
      
      
   }
   
   
   public static void main(String[] args) {
      FinalProjectClient frame = new FinalProjectClient();
      frame.setTitle("FinalProjectClient");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 300);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
}