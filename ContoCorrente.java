package application;

public class ContoCorrente {
	
	private String pin;
	
	private int saldo;

	public ContoCorrente(String pin, int saldo) {
	
		this.pin = pin;
		this.saldo = saldo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	

}
