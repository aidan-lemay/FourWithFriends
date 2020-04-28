import java.net.*;
import java.io.*;

/**
 * ISTE-121 final project backend multithreaded server code
 *
 * @author Thomas Chenevey, Andrew Korchowsky
 * @version 1.1
 * @date: 4/27/2020
 * @project: four with friends
 */

public class BackendNET {
	public static void main(String [] args) {
		new BackendNET();
	}

   //creating BackendNET constructor
	public BackendNET() {
		ServerSocket ss = null;
      //Initializes a blank connect4 board
      char[][] board = {{'N','N','N','N','N','N'},{'N','N','N','N','N','N'},
         {'N','N','N','N','N','N'},{'N','N','N','N','N','N'},{'N','N','N','N','N','N'},
         {'N','N','N','N','N','N'},{'N','N','N','N','N','N'}};   
   
      // getting the addresses of the localhost and the computer
		try {
		  System.out.println("getLocalHost: "+InetAddress.getLocalHost() );
		  System.out.println("getByName:    "+InetAddress.getByName("localhost") );

		  ss = new ServerSocket(16789);
		  Socket cs = null;
        System.out.println("Server Started");

        //after socket is created the server waits for a client to be accepted
        System.out.println("Waiting for a client...");
		  while(true){
			 cs = ss.accept();
          System.out.println("Client accepted");
			 ThreadServer ts = new ThreadServer( cs );
			 ts.start();
		  }
		}
		catch( BindException be ) {
			System.out.println("Server running, stopping");
		}
		catch( IOException ioe ) {
			System.out.println("IO Exception has occured inside catch (constructor)");
			ioe.printStackTrace();
		}
	}
   
   /**
    * The following is roughly the code needed to implement win checker
    * The code below cannot be implemented, since the method cannot return multiple things
    * If there is a way to send clients messages from the code below, that would fix this
    *
    * Currently, the method recieves the board and the player's move in the form of the index
    * of the column that player played into, and returns the updated board state. This method would
    * theoretically be able to be implemented in a place where it has access to some way to update
    * board, and send a message to either player. I am extremely sorry for leaving this mess, but
    * hopefully it is helpful to you in some way. IF THIS CODE IS NOT HELPFUL, PLEASE DELETE IT.
   **/
   public char[][] receiveMove(char[][] board, int column, char playerColor){      
      /**
       * Checks for the next free space in the column that was played, and updates that with
       * the color of the player who just played. If the column is full, this determines that.
      **/
      int rowIndex = 0;
      char nextChar = board[column][rowIndex];
      while(rowIndex < 5 && nextChar != 'N'){
         nextChar = board[column][rowIndex +1];
         rowIndex += 1;
      }
      if(rowIndex == 5 && nextChar != 'N'){
         /**
          * In this case, a player attempted to place a piece in a filled column. Implement the proper
          * procedure for telling the client that it did this here
          */
          return board;
      }
      else{
         board[column][rowIndex] = playerColor;
         /**
          * I could not get java to recognize my class, and I don't know what I was doing wrong. This is where
          * wins are supposed to be tested for. The method definitely works, and this is how it is supposed to
          * be implemented, but for some reason java doesn't see the Connect4WinChecker class.
         if(new Connect4WinChecker().checkWin(board, column)){
            //Implement winning procedure here (What to do if a player won using this move)
            return board;
         }
         **/
         return board;
      }
      //At this point the player has made their move uneventfully. Pass the turn.
      return board;
   }


   //Threadserver class
	class ThreadServer extends Thread {
		Socket cs;

	public ThreadServer( Socket cs ) {
		this.cs = cs;
		}

      //run method that handles receiving messages from client as well as sending messages back
		public void run() {
			BufferedReader br;
			PrintWriter pw;
			String clientMsg;

         try {
			  br = new BufferedReader(new InputStreamReader(cs.getInputStream()));

			  pw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));

			  clientMsg = br.readLine();
			  System.out.println("Server read: "+ clientMsg);
			  pw.println(clientMsg.toUpperCase());
			  pw.flush();
           }

			catch( IOException ioe ) {
				System.out.println("IO exception occurred inside catch");
				ioe.printStackTrace();
			}

         } //run method
	 } //ThreadServer
}//BackendNET
