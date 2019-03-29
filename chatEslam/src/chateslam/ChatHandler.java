
package chat.group.server.app;

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatHandler implements Runnable
{
    private Socket incomingSocket;
    static ArrayList<ChatHandler> activeClients = new ArrayList<ChatHandler>();
    public ChatHandler(Socket incomingSocket)
    {
        this.incomingSocket = incomingSocket;
        //activeClients.add(this);
    }
    @Override
    public void run()
    {
        Scanner scanner = null;
        try (InputStream inStream = incomingSocket.getInputStream())
        {
            scanner = new Scanner(inStream, "UTF-8");
            boolean done = false;
            if(scanner != null)
            {
		while (!done)
		{
                    if(scanner.hasNextLine())
                    {
                        String line = scanner.nextLine(); 
                        for(ChatHandler c : activeClients)
                        {
                            OutputStream outStream = c.incomingSocket.getOutputStream();
                            PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true);
                            out.println(line);
 
                            //out.flush();
                        }
                    }
		}
            }
        }
        catch(IOException e)
	{
            e.printStackTrace();
	}
	finally
	{
            scanner.close();
	}
    }
}
