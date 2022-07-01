package syazreenaida.assessment.Task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class HTTPRequest implements Runnable{
    private Socket sock;
  private LinkedList<String> directories;
  private boolean resourceFound;

  public void MainClient(Socket sock, LinkedList<String> directories){
    this.sock = sock;
    this.directories = directories;
  }
 
  @Override
  public void run(){
    System.out.println("Starting a client thread");
    try {

      
      InputStreamReader isr =  new InputStreamReader(sock.getInputStream());
      BufferedReader reader = new BufferedReader(isr);
      LinkedList<String> data = new LinkedList<>();
      String line = reader.readLine();
      while (!line.isEmpty()){
          data.add(line);
          line = reader.readLine();
      }

      
      System.out.println("Exiting the thread !");
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

  public void checkResource(String resource){
    resourceFound = false;
    while(resourceFound == false){
      for(int i=0; i<directories.size();i++){

        Path path = Paths.get(directories.get(i)+resource);

        if(Files.exists(path)){
          resourceFound = true;
          directories.get(i).replaceAll(resource,"");
          break;
        }
      }
      break;
    }
  }
}
