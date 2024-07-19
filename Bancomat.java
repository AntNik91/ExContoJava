package application;

import java.util.ArrayList;

public class Bancomat {
	
	ArrayList <ContoCorrente> ContiCorrenti;
	
	public Bancomat () {
		ContiCorrenti = new ArrayList<>();
	
	}
	 
	
public void addConto(ContoCorrente conto1) {
		
		ContiCorrenti.add(conto1);
		
		
	}
	

	
	
	@Override
public String toString() {
	return "Bancomat [ContiCorrenti=" + ContiCorrenti + "]";
}


	public boolean check (String pin) {
		boolean check = false;
		
		for (ContoCorrente c : ContiCorrenti ) {
			if (pin.equals(c.getPin()))
				check = true;
		}

	return check;
	}
	
	
	public int getSaldo(String pin) {
		
		int Saldo = 0;
	
		for (ContoCorrente c : ContiCorrenti ) {
			if (pin.equals(c.getPin())) {
				Saldo = c.getSaldo();
			}
	}
		return Saldo;
	}
	
	
	
	public void Preleva (String pin, int importo) {
		
		for (ContoCorrente c : ContiCorrenti ) {
			if (pin.equals(c.getPin()))
				if (c.getSaldo()>= importo) {
					c.setSaldo(c.getSaldo()- importo);
					System.out.println("prelievo eseguito con successo");
				}
		 else {
			System.out.println("impossibile prelevare");
		
									
		}		
		}
	}
public void Versa (String pin, int importo) {
	
	for (ContoCorrente c : ContiCorrenti ) {
		if (pin.equals(c.getPin()))
				{
			c.setSaldo(c.getSaldo()+importo);
			System.out.println("Deposito eseguito con successo");
	
				}
	}}}
	
	
	
	
	
	

