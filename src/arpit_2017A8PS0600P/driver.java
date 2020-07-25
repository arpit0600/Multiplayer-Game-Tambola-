package arpit_2017A8PS0600P;

import java.io.*;


public class driver {
	public static void main(String[] args)throws Exception {
		System.out.println("There are 4 player in the game, please fill name of all the 4 players respectively.");
		System.out.println("");
		InputStreamReader r=new InputStreamReader(System.in);    
	    BufferedReader br=new BufferedReader(r); 
	    System.out.println("Enter player 1 Name");
	    String name1=br.readLine();
	    System.out.println("Enter player 2 Name");
	    String name2=br.readLine();
	    System.out.println("Enter player 3 Name");
	    String name3=br.readLine();
	    System.out.println("Enter player 4 Name");
	    String name4=br.readLine();
	    
		resource r1=resource.getresourceInstance();
		Dealer d1  =Dealer.getDealerInstance();
		Player p1  =new Player(name1,0);
		Player p2  =new Player(name2,1);
		Player p3  =new Player(name3,2);
		Player p4  =new Player(name4,3);
		
		d1.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		try {
		d1.join();
		p1.join();
		p2.join();
		p3.join();
		p4.join();
		}
		catch (InterruptedException e) {}
		System.out.println("No. of matches for "+name1+":"+r1.count[0]);
		System.out.println("No. of matches for "+name2+":"+r1.count[1]);
		System.out.println("No. of matches for "+name3+":"+r1.count[2]);
		System.out.println("No. of matches for "+name4+":"+r1.count[3]);
			 if(r1.count[0]==3) {
				 System.out.println( name1+" has won");
				 
			 }
			 else if(r1.count[1]==3) {
				 System.out.println(name2+" has won");
			}
			 else if(r1.count[2]==3) {
				 System.out.println(name3+" has won");
			}
			 else if(r1.count[3]==3) {
				 System.out.println(name4+" has won");
			}
			 else {
				 System.out.println("No one won");	 
			 }
		}

}
