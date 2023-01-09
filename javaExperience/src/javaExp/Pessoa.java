package javaExp;

import java.text.SimpleDateFormat;

abstract class Pessoa extends Validar{
	
	public String formato;
	private String cpf, nome;
	
	protected SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	public String getCpf() {
		return (this.cpf);
	}

	public String printCpf() {
		return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
				cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public boolean validaCpf(String cpf) {
		if (Validar.verificarCPF(cpf) == true) {
			return(true);
		}
		else {
			System.out.printf("\t*** Erro, CPF invalido ***\n\t     Tente novamente.\n\n");
			return(false);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
