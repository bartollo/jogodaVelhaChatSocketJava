package avaliacao3pts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bartollo_user
 */


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {

	private String host;
	private int porta=1899;
	private Socket socketCliente;
	PrintStream saida;
	private String id;
	private String idOponente;
	private String login;
	private static Cliente cliente;


	public Cliente (String host, String login) {
		this.host = host;
		this.login = login;
		cliente = this;
	}

	public void executa(String nomeUsuario) throws UnknownHostException, IOException {
		this.socketCliente = new Socket(this.host, this.porta);
		System.out.println(nomeUsuario+" se conectou ao servidor!");
		
		InputStream is = this.socketCliente.getInputStream();
		Recebedor rec = new Recebedor(is);
		Thread t = new Thread(rec);
		t.start();
	}
	
	public void enviaDados(String dado) throws IOException {
		// l� msgs do teclado e manda pro servidor
                
                System.out.println("cliente envia dados");
                
		this.saida = new PrintStream(this.socketCliente.getOutputStream());
		
		this.saida.println(dado);
	}
		
	public void fechaConexao() throws IOException{
		this.saida.close();
		this.socketCliente.close();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdOponente() {
		return idOponente;
	}

	public void setIdOponente(String idOponente) {
		this.idOponente = idOponente;
	}
	
	public static synchronized Cliente getInstance() 
	{
		if (cliente == null) {
			cliente = new Cliente("127.0.0.1", "Login");
		}
		return cliente;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
}

