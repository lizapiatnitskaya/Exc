package potok;


import java.util.HashMap;
import java.util.Scanner;

public class MultiRandom {
	public static void main(String[] args){
		HashMap<String, FileWriter> threadMap = new HashMap<>();
		 Scanner in = new Scanner(System.in);
		 String Name = new String();
		 while(true){
			 String string = in.nextLine();
			 if( string.startsWith("Start")){
				Name = string.substring(6) ;
				FileWriter writer = new FileWriter(Name);
				threadMap.put(Name,writer);
				writer.start();
				
			 }
			 if( string.startsWith("Stop")){
					Name = string.substring(5) ;
				    if(threadMap.get(Name)!=null) {
				    	FileWriter s=threadMap.get(Name);
				    	s.NeedStop = true;
				    }
				    else{
				    	System.out.println("В данный момент файл не задействован");
				    }
			 }
			 if(string.startsWith("Status")){
				 for(FileWriter s:threadMap.values()){
					 System.out.println(s.Name +" "+s.Counter);
					 
				 }
				 
			 }
			 if(string.startsWith("Exit")){
				 for(FileWriter s:threadMap.values()){
					 s.NeedStop = true;
					 return;
					 
				 }
				 
			 }
				    	
				 
				    	
				    	
				    
					
					
				 
		 }
		 
	}

}
