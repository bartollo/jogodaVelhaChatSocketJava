/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao3pts;

import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 *
 * @author bartollo_user
 */



public class Recebedor implements Runnable {
	JogoDaVelha tabuleiro ;
	private InputStream servidor;

	public Recebedor(InputStream servidor) {
		this.servidor = servidor;
	}

	public void run() {
		Scanner s = new Scanner(servidor);

		while (s.hasNextLine()) {
			String entrada = s.nextLine();
                        System.out.println("entreda - ok ");
			this.trataEntrada(entrada);
			System.out.println(entrada);
			//servidor.distribuiMensagem(s.nextLine());
		}
	}
	
	public void trataEntrada(String entrada){
		String[] array = entrada.split(";");

		switch (array[0]) {
		case "logar":
			//Id, loginOponente, idOponente 
			this.logar(array[1], array[2], array[3]);
			break;
		
		case "jogar":
			this.jogar(array[1], array[2]);
			break;
                        
		
		case "conversar":
                    System.out.println("trata entrada - ok ");
                        //nome da pessoa e conversa.
			this.conversar(array[1], array[2]);
			break;
	                        
	
		default:
			break;
		}
	}
	
	public void logar(String id, String loginOponente, String idOponente){
		
		Cliente cliente = Cliente.getInstance();
		cliente.setId(id);	
		cliente.setIdOponente(idOponente);
		System.out.println("Player 1 (Cliente) : "+loginOponente);
		System.out.println("Player 2 (Recebedor) : "+cliente.getLogin());
		
		this.tabuleiro = new JogoDaVelha(cliente.getLogin(), loginOponente, cliente);
		this.tabuleiro.show();
	}
	
	public void jogar(String linha, String coluna){
		
//		this.tabuleiro.matrizVelhaBotao[Integer.parseInt(linha)][Integer.parseInt(coluna)].setText("X");
                

		this.tabuleiro.matrizVelha[Integer.parseInt(linha)][Integer.parseInt(coluna)] = -1;
		
		int retorno = this.tabuleiro.verificaMatriz();
		if(retorno == 1){
			JOptionPane.showMessageDialog(null, this.tabuleiro.nomeJogador+" venceu o jogo!");
			this.tabuleiro.limparVelha();			
		}else if(retorno == -1){
			JOptionPane.showMessageDialog(null, this.tabuleiro.nomeOponente+" venceu o jogo!");
			this.tabuleiro.limparVelha();		
		}
		
		this.tabuleiro.habilitaBotoes();		
	}
        

	public void conversar(String nome, String texto){		
                   
            

                System.out.println("conversar - ok ");            
		StringBuilder sb = new StringBuilder();

                sb.append(this.tabuleiro.chat);
                sb.append("\n");
                sb.append(nome+": ");
                sb.append(texto);
                
                try{
                    this.tabuleiro.chat=sb.toString();                    
                    this.tabuleiro.atualizaChat();
                }catch( Exception e){
                    System.out.println("Falha na comunicação do chat");
                    e.printStackTrace();
                }                

	}        
	
}
