package potok;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;



public class FileWriter extends Thread {
	String Name;
	boolean NeedStop;
	int Counter;
	FileWriter( String FileName ){
		Name = FileName;
		NeedStop = false;
	
	}
	 public void run() {
	
		 try{
			 File file = new File(Name);
			 if(!file.exists()) {
			   
			   file.createNewFile();
			}
			 
			PrintWriter add = new PrintWriter(file);
			 Random rand = new Random();
			 while(! NeedStop ){
				 add.print(rand.nextInt());
				 try {
				     sleep(100);
				    } catch (InterruptedException e) {}
				
				 Counter ++;
				 add.flush();
			 }
		 add.close();
		 }
		 catch (IOException e)  {
			 System.out.println("Файл не может быть создан");
			 
		 }
		
	 }
}
