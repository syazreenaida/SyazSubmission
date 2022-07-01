package syazreenaida.assessment.Task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws Exception{
        if (args.length < 1) return;
 
        String domainName = args[0];
 
        String hostname = "task02.chuklee.com";
        int port = 80;
        
        try(Socket socket = new Socket(hostname, port))
        {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(domainName);

            InputStream input = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;

            while((line = reader.readLine()) != null)
            {
                String receivedResponse = input.readUTF(line);
            }
            }catch(UnknownHostException ex){
                System.out.println("Server not found: " + ex.getMessage());
            }catch(IOException ex){
                System.out.println("I/O error: " + ex.getMessage());
        }
    } 
}
