import java.time.LocalDate;
import java.util.Scanner;

public class ContaDeBanco {
    private String nome;
	private int numero;
	private String agencia;
	private double saldo;
	private String dataDeAbertura = LocalDate.now().toString();
	private double rendimento = 0.1;
	
	public ContaDeBanco(String nome, int numero, String agencia, double saldo) {
		this.nome = nome;
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getDataDeAbertura() {
		return dataDeAbertura;
	}
	
	public void deposita(int valor, int numero,String agencia ) {
		if(this.numero == numero && this.agencia == agencia) {
			this.saldo += valor;
		}
	}
	
	public void saca(int valor) {
		if(getSaldo() < valor) {
			System.out.println("Saldo insuficiente");
		}else {
			this.saldo -= valor;
		}
	}
	
	public double rendimento() {
		return this.rendimento = this.saldo * this.rendimento;
	}
	
	@Override
	public String toString() {
		return  "\n Nome: " + this.nome + 
				"\n Numero: " + this.numero +
				"\n Agencia: " + this.agencia +
				"\n Saldo: " + this.saldo + 
				"\n Data de abertura: " + this.dataDeAbertura;
	}
	
	public static void main(String []args){
		Testa();
	}
	
	public static void Testa() {
		
		Scanner nome = new Scanner(System.in);
		System.out.print("Nome: ");
		String nomeUser = nome.nextLine();
		
		Scanner num = new Scanner(System.in);
		System.out.print("Numero da conta: ");
		int numero = num.nextInt();
		
		Scanner age = new Scanner(System.in);
		System.out.print("Agencia: ");
		String agencia = age.nextLine();	
		
		Scanner sal = new Scanner(System.in);
		System.out.print("Saldo: ");
		int saldo = sal.nextInt();
		
		ContaDeBanco s = new ContaDeBanco(nomeUser,numero,agencia,saldo);
		
		System.out.println(s);
		
		System.out.print("Sacar: ");
		Scanner sac = new Scanner(System.in);
		int sacar = sac.nextInt();
		
		s.saca(sacar);
		
		System.out.println("Seu saldo agora e R$ " + s.getSaldo());
		
		System.out.print("Deposite um valor: ");
		Scanner dep = new Scanner(System.in);
		int deposita = dep.nextInt();
		
		s.deposita(deposita, numero, agencia);
		
		System.out.println("Seu saldo atual e: " + s.getSaldo());
		System.out.println("Seu rendimento do que tem de saldo na conta e: " + s.rendimento());
		
	}

}
