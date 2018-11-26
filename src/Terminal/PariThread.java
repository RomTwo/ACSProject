package Terminal;

import Terminal.Contrat;

public class PariThread implements Runnable{
	
	Pari p;
	Contrat distObject;

	public PariThread(Pari p, Contrat c) {
		this.p = p;
		this.distObject = c;
	}
	
	@Override
	public void run() {
		try {
			synchronized(p){
				p.set(distObject.addPari());
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}
