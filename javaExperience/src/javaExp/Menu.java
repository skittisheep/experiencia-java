package javaExp;

import java.util.Scanner;

public class Menu {

	int opt, maxCidID, cidID = 0;
	
	Scanner scanner = new Scanner(System.in);
	Paciente[] cidadao = new Paciente[10];
	
	public void logIn() {
		
		String tempEnferCpf;
		Enfermeira usuaria = new Enfermeira();
	
		System.out.printf("Informe o nome da Enfermeira: \n\t>>");
		usuaria.setNome(scanner.nextLine());
		
		do {
			System.out.printf("Informe o CPF da Enfermeira: (somente números)\n\t>>");
			tempEnferCpf = scanner.nextLine();
		} while (usuaria.validaCpf(tempEnferCpf) == false);
		usuaria.setCpf(tempEnferCpf);
	}
	
	public void printListaVacina() {
		for (int cidID = 0; cidID < maxCidID; cidID++) {
			System.out.printf("\n\n\tNome: " + cidadao[cidID].getNome());
			System.out.printf("\n\tCPF : " + cidadao[cidID].getCpf() + "\n");
			for (int i = 0; i <= 3; i++) {
				System.out.printf("\n\t%1d° dose: ", i + 1);
				System.out.print(cidadao[cidID].getDataVacFormat(i));
			} 
		}
	}
	
	public void show() {
		System.out.printf("\n   Opiçoes**\n");
		System.out.printf("\t 1 - Vacinar Cidadão\n");
		System.out.printf("\t 2 - Listar cidadãos vacinados\n");
		System.out.printf("\t 0 - Sair do programa\n");
		System.out.printf("   Seleção: ");
		opt = scanner.nextInt();
		scanner.nextLine();
		
		switch (opt) {
			case 1:
				boolean save = true;
				String tempNome, tempCpf;
				String[] tempData = new String[4];
				
				cidadao[cidID] = new Paciente();
				
				System.out.printf("\nInforme o nome do Cidadão: \n\t>>");
				tempNome = scanner.nextLine();
				
				do {
					System.out.printf("Informe o CPF do Cidadão: (somente números)\n\t>>");
					tempCpf = scanner.nextLine();
				} while (cidadao[cidID].validaCpf(tempCpf) == false);
				System.out.printf("\n");
				
				for (int i = 0; i <= 3; i++) {
					System.out.printf("Informe a Data da %1d° dose: (dd/mm/aaaa)\n\t>>", i + 1);
					tempData[i] = scanner.nextLine();
					if (i > 0 && cidadao[cidID].valDataVac(i, tempData[i], tempData[i-1]) == false) {
						save = false;
						break;
					}
				}
			
				if (save == true) {
					cidadao[cidID].setNome(tempNome);
					cidadao[cidID].setCpf(tempCpf);
					for (int i = 0; i <= 3; i++) {
						cidadao[cidID].setDataVac(i, tempData[i]);
					}
					cidID = cidID + 1;
					maxCidID = cidID;
				}
			break;
			case 2:
				if (cidID == 0) {
					System.out.printf("\n\tNenhum Cidadão vacinado até o momento**\n");
				}
				else {
					printListaVacina();
					System.out.printf("\n");
				}
			break;
			case 0:
				System.out.printf("\nSaindo do sistema!!! ");
				scanner.close();
			break;
			default:
				System.out.printf("***  Opção inválida. ***\n\n");
			break;
		}
	}
}
