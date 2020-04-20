import java.net.*;
import java.io.*;

/**
 * ISTE-121 final project backend multithreaded server code
 *
 * @author Thomas Chenevey
 * @version 1.0
 * @date: 4/3/2020
 * @project: four with friends
 */

public class BackendNET {
	public static void main(String [] args) {
		new BackendNET();
	}

   //creating BackendNET constructor
	public BackendNET()
	{
		ServerSocket ss = null;

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
			System.out.println("IO Exception has occured");
			ioe.printStackTrace();
		}

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

			catch( IOException e ) {
				System.out.println("Inside catch");
				e.printStackTrace();
			}

         } //run method
	 } //ThreadServer
}//BackendNET
