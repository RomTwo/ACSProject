package Terminal;

public class Pari{

	Double valeur;

	public Pari(){
		valeur = null;
	}

	synchronized public Double get() {
		if (valeur == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return valeur;
	}
	
	public void set(double v) {
		notify();
		valeur = v;
	}
}
