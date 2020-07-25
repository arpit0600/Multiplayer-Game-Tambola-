package arpit_2017A8PS0600P;



class Dealer extends Thread { 
	private int  num;
	resource r=resource.getresourceInstance();
	private static Dealer d1;
	
	public void run() {
		for(int i=0;i<10;i++) {
			if(r.done==true) {
				break;
			}
			num=(int)(Math.random()*50);
					r.setLast(num);
				}
		try {
			sleep(1000);
		}
		catch (InterruptedException e) {}
			}
	public static Dealer getDealerInstance() {
		 if(d1==null) {
			 d1=new Dealer();
		 }
		 return d1;
	 }
}
