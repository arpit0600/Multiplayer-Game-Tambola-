package arpit_2017A8PS0600P;



class Player extends Thread {
	private int	data1[]=new int[10];
	private boolean match[]=new boolean[10];
	private int id;
	private String name;
	resource r=resource.getresourceInstance();
	
	Player(String name,int id1)
	{	this.name=name;
		id=id1;
		for(int i=0;i<10;i++) {
			data1[i]=(int)(Math.random()*50);
		}
		print();
	}
	public  void run() {
		for(int i=0;i<10;i++) {
			if(r.done==true) {
				break;
			}
				int num=r.getLast(id);
				if(lookup(num)==true) {
					r.count[id]++;
				}
				if(r.count[id]==3) {
					r.done=true;
					break;
					}
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {}			
			}
	}
	private boolean lookup(int number) {
		for(int i=0;i<10;i++) {
			if(number==data1[i] && match[i]==false) {
				match[i]=true;
				return true;
			}
		}
		return false;
	}
	private void print() {
		System.out.print(name +" ticket numbers: {");
		for(int i=0;i<10;i++) {
			System.out.print(" "+data1[i]);
		}
			
		
		System.out.print(" }");
		System.out.println("");
	}
	
}
