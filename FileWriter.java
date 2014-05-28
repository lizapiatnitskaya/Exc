package potok;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;



public class FileWriter extends Thread {
	private String Name;
	private boolean NeedStop;
	private int Counter;
	public void  setFileNeedStop(boolean x){
		this.NeedStop= x;
        }
	public String getFileName(){
        return Name;
        }
	public int getFileCounter(){
        return Counter;
        }
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
			 System.out.println("���� �� ����� ���� ������");
			 
		 }
		
	 }
}
