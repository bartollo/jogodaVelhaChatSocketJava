/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao3pts;

/**
 *
 * @author bartollo_user
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Servidor {

        //definindo porta padrão para conexão 1899
	private int porta=1899;
	public Map<Integer, ClienteServidor> clientes;
	private static int idCliente = 0; 
        
	public static void main(String[] args) throws IOException {
		// Servidor inicia na porta 1899
		new Servidor().executa();
	}

	public Servidor () {
		this.clientes = new HashMap<Integer,ClienteServidor>();  
	}

	public void executa() throws IOException {
                                
                //Responsável por esperar a conexão do cliente.                                   
		ServerSocket servidor = new ServerSocket(this.porta);
		System.out.println("Servidor Ativo - Aguardando Conexões!");

		while (true) {
			// aceita um cliente
			Socket cliente = servidor.accept();
			System.out.println("Conexão estabelecida com " + cliente.getInetAddress().getHostAddress());

			// adiciona saida do cliente à lista
			PrintStream ps = new PrintStream(cliente.getOutputStream());			
			ClienteServidor cs = new ClienteServidor();
			cs.setLoginPS(ps);
			this.idCliente++;
			cs.setLoginId(this.idCliente);
			this.clientes.put(this.idCliente, cs);

			// cria tratador de cliente numa nova thread
			TrataCliente tc = new TrataCliente(cliente.getInputStream(), this, cs);
			Thread t = new Thread(tc);
			t.start();
		}
	}

	public void distribuiMensagem(PrintStream cliente, String msg) {
		
		System.out.println(msg);
		
		cliente.println(msg);		
	}

}
