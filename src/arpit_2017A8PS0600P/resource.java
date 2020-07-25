package arpit_2017A8PS0600P;

import java.util.ArrayList;


class resource {
	static private resource r1;
	public boolean[] seen = new boolean[] {true,true,true,true} ;
	private int lastNum=-1;
	private boolean available=false;
	public boolean done=false;
	public int[] count=new int[4];
	private ArrayList<Integer> sharedData = new ArrayList<Integer>();
	public synchronized int getLast(int id) {
			
		 while(available==false) {
			try {
				 wait();
				 } catch (InterruptedException e) {}
		}
		 seen[id]=true;
		 if(seen[0]&&seen[1]&&seen[2]&&seen[3]) {
			 available=false;
			 }
		 notifyAll();
		 return lastNum;
		
		 
	 }
	 public synchronized void setLast(int num) {
		 while(available==true) {
			 try {
		            wait();
		         } catch (InterruptedException e) { }
			 
		 }
		 System.out.println("Dealer Generated : "+num);
		 sharedData.add(num);
		  lastNum=num;
		  available=true;
		 seen[0]=false;
		 seen[1]=false;
		 seen[2]=false;
		 seen[3]=false;
		 notifyAll();
		 try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {}
	 }
	 public static resource getresourceInstance() {
		 if(r1==null) {
			 r1=new resource();
		 }
		 return r1;
	 }
}



