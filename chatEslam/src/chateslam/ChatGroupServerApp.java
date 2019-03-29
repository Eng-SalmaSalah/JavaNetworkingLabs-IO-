
package chat.group.server.app;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatGroupServerApp 
{
    public static void main(String[] args) 
    {
        try (ServerSocket serverSocket = new ServerSocket(8189))
		{
			while (true)
			{  
				Socket socket = serverSocket.accept();
				ChatHandler runObject = new ChatHandler(socket);
                                ChatHandler.activeClients.add(runObject);
				Thread clientThread = new Thread(runObject);
				clientThread.start();
			}
		}
		catch (IOException e)
		{  
			e.printStackTrace();
		}
    }
}
