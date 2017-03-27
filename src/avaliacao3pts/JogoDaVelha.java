/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao3pts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author bartollo_user
 */
public class JogoDaVelha extends javax.swing.JFrame {

    public int[][] matrizVelha = {{0, 0, 0},{0, 0, 0},{0, 0, 0}};  
    public final String nomeJogador;
    public final String nomeOponente;
    public final Cliente cliente;
    private int jogador = 1;
    public String chat="";


    /**
     * Creates new form ClienteConexao
     */
    public JogoDaVelha(String nomeJogador, String nomeOponente, Cliente cliente) {
        initComponents();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        	
        this.nomeJogador = nomeJogador;
        this.nomeOponente = nomeOponente;
        this.cliente = cliente;

        //jTextArea1.setText(this.nomeJogador+"\r\n");
        //jTextArea1.setText(this.nomeJogador + " X " + this.nomeOponente+"\r\n");

            this.button_00.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( button_00.getText() != ""){
                        return;
                    }                    
                    button_00.setText("O");
                    cliqueBotaoVelha(0,0);

                    desabilitar();

                }
            });        
            button_00.setBounds(125, 72, 50, 50);

            this.button_10.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( button_10.getText() != ""){
                        return;
                    }
                    button_10.setText("O");
                    cliqueBotaoVelha(1,0);

                    desabilitar();

                }
            });                    
            button_10.setBounds(125, 133, 50, 50);


            this.button_20.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( button_20.getText() != ""){
                        return;
                    }
                    button_20.setText("O");
                    cliqueBotaoVelha(2,0);

                    desabilitar();

                }
            });        
            button_20.setBounds(125, 72, 50, 50);

            this.button_01.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( button_01.getText() != ""){
                        return;
                    }
                    button_01.setText("O");
                    cliqueBotaoVelha(0,1);

                    desabilitar();

                }
            });                    
            button_01.setBounds(125, 133, 50, 50);

            this.button_11.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( button_11.getText() != ""){
                        return;
                    }
                    button_11.setText("O");
                    cliqueBotaoVelha(1,1);

                    desabilitar();

                }
            });                    
            button_11.setBounds(125, 190, 50, 50);


            this.button_21.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( button_21.getText() != ""){
                        return;
                    }
                    button_21.setText("O");
                    cliqueBotaoVelha(2,1);

                    desabilitar();

                }
            });        
            button_21.setBounds(125, 72, 50, 50);

            this.button_02.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( button_02.getText() != ""){
                        return;
                    }
                    button_02.setText("O");
                    cliqueBotaoVelha(0,2);

                    desabilitar();

                }
            });                    
            button_02.setBounds(125, 133, 50, 50);

            this.button_12.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( button_12.getText() != ""){
                        return;
                    }
                    button_12.setText("O");
                    cliqueBotaoVelha(1,2);

                    desabilitar();

                }
            });                    
            button_12.setBounds(125, 190, 50, 50);            

            this.button_22.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( button_22.getText() != ""){
                        return;
                    }
                    
                    button_22.setText("O");
                    cliqueBotaoVelha(2,2);

                    desabilitar();

                }
            });                    
            button_22.setBounds(125, 190, 50, 50);            

            System.out.println(cliente.getId());
            System.out.println(cliente.getIdOponente());
            
            if (Integer.parseInt(cliente.getId()) > Integer.parseInt(cliente.getIdOponente())){
                 habilitaBotoes();
            }else{
                desabilitar();
            }
            
            button_enviar_mensagem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        chat= jTextArea1.getText()+"\n"+cliente.getLogin()+": "+jTextArea3.getText();
                        atualizaChat();
                        cliente.enviaDados("conversar;" + cliente.getId() + ";" + jTextArea3.getText());
                        jTextArea3.setText("");                        
                    } catch (IOException ex) {
                        Logger.getLogger(JogoDaVelha.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });             
	}
    

    public void habilitaBotoes() {        
            /*for(int i=0; i < 3; i++){
                    for(int j=0; j < 3; j++){
                            if(this.matrizVelha[i][j]){
                                    this.matrizVelhaBotao[i][j].setEnabled(false);
                                    labelNomeJogador.setText(this.nomeOponente);                                    
                            }else{
                                    this.matrizVelhaBotao[i][j].setEnabled(true);
                                    labelNomeJogador.setText(this.nomeOponente);
                            }
                    }
            }*/
            
        if(matrizVelha[0][0]<0){            
		button_00.setEnabled(false);
                button_00.setText("X");
        }else{
		button_00.setEnabled(true);
            
        }
        
        if(matrizVelha[0][1]<0){            
		button_01.setEnabled(false);
                button_01.setText("X");
        }else{
		button_01.setEnabled(true);
            
        }
        
        if(matrizVelha[0][2]<0){            
		button_02.setEnabled(false);
                button_02.setText("X");
        }else{
		button_02.setEnabled(true);
            
        }
        
        if(matrizVelha[1][0]<0){            
		button_10.setEnabled(false);
                button_10.setText("X");
        }else{            
		button_10.setEnabled(true);                
        }
        
        if(matrizVelha[1][1]<0){            
		button_11.setEnabled(false);
                button_11.setText("X");
        }else{
            
		button_11.setEnabled(true);
                
        }
        
    	if(matrizVelha[1][2]<0){            
		button_12.setEnabled(false);
                button_12.setText("X");
        }else{
		button_12.setEnabled(true);            
        }
        
        if(matrizVelha[2][0]<0){            
		button_20.setEnabled(false);
                button_20.setText("X");
        }else{            
		button_20.setEnabled(true);                
        }
        
        if(matrizVelha[2][1]<0){            
		button_21.setEnabled(false);
                button_21.setText("X");
        }else{
		button_21.setEnabled(true);            
        }
        
        if(matrizVelha[2][2]<0){            
		button_22.setEnabled(false);
                button_22.setText("X");
        }else{
		button_22.setEnabled(true);            
        }

    }
        
    public void preencheMatriz(int linha, int coluna, int valor) {
        this.matrizVelha[linha][coluna] = valor;
    }    
	    
    public int cliqueBotaoVelha(int linha, int coluna) {
    	
    	try {
			cliente.enviaDados("jogar;" + cliente.getId() + ";" + linha + ";" + coluna);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	int valor = 1;

		preencheMatriz(linha, coluna, valor);
		int retorno = verificaMatriz();
		if(retorno == 1){
			JOptionPane.showMessageDialog(null, nomeJogador+" venceu o jogo!");
			limparVelha();
			return 0;
		}else if(retorno == -1){
			JOptionPane.showMessageDialog(null, nomeOponente+" venceu o jogo!");
			limparVelha();
			return 0;
		}else if(retorno == 2){
			return 0;
		}
		
		return valor;
    }
    

    public int verificaMatriz() {		
            int retornoColunas, retornoLinhas, retornoDiagonais = 0;
            retornoColunas = checaColunas();
            retornoLinhas = checaLinhas();
            retornoDiagonais = checaDiagonais();

            if(retornoColunas == -1 || retornoLinhas == -1 || retornoDiagonais == -1){
                    return -1;
            }

            if(retornoColunas == 1 || retornoLinhas == 1 || retornoDiagonais == 1){
                    return 1;
            }

            for(int i=0; i < 3; i++){
                    for(int j=0; j < 3; j++){
                            if(matrizVelha[i][j] == 0){
                                    return 0;
                            }
                    }
            }

            limparVelha();
            JOptionPane.showMessageDialog(null, "Jogo empatou!");

            return 2;
    }    

	
    public int checaLinhas(){
        for(int linha=0 ; linha<3 ; linha++){

            if( (this.matrizVelha[linha][0] + this.matrizVelha[linha][1] + this.matrizVelha[linha][2]) == -3)
                return -1;
            if( (this.matrizVelha[linha][0] + this.matrizVelha[linha][1] + this.matrizVelha[linha][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }    
	    
    public int checaColunas(){
        for(int coluna=0 ; coluna<3 ; coluna++){

            if( (this.matrizVelha[0][coluna] + this.matrizVelha[1][coluna] + this.matrizVelha[2][coluna]) == -3)
                return -1;
            if( (this.matrizVelha[0][coluna] + this.matrizVelha[1][coluna] + this.matrizVelha[2][coluna]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checaDiagonais(){
        if( (this.matrizVelha[0][0] + this.matrizVelha[1][1] + this.matrizVelha[2][2]) == -3)
            return -1;
        if( (this.matrizVelha[0][0] + this.matrizVelha[1][1] + this.matrizVelha[2][2]) == 3)
            return 1;
        if( (this.matrizVelha[0][2] + this.matrizVelha[1][1] + this.matrizVelha[2][0]) == -3)
            return -1;
        if( (this.matrizVelha[0][2] + this.matrizVelha[1][1] + this.matrizVelha[2][0]) == 3)
            return 1;
        
        return 0;
    }
        
    
    public void limparVelha(){
    	for(int i=0; i < 3; i++){
			for(int j=0; j < 3; j++){
				matrizVelha[i][j] = 0;				
			}
		}
    	
    	button_00.setText("");
    	button_01.setText("");
    	button_02.setText("");
       	button_10.setText("");
    	button_11.setText("");
    	button_12.setText("");
    	button_20.setText("");
    	button_21.setText("");
    	button_22.setText("");    	
    }
    
    public void desabilitar(){
 
    	button_00.setEnabled(false);
    	button_01.setEnabled(false);
    	button_02.setEnabled(false);
       	button_10.setEnabled(false);
    	button_11.setEnabled(false);
    	button_12.setEnabled(false);
    	button_20.setEnabled(false);
    	button_21.setEnabled(false);
    	button_22.setEnabled(false);	
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        button_02 = new javax.swing.JButton();
        button_00 = new javax.swing.JButton();
        button_01 = new javax.swing.JButton();
        button_12 = new javax.swing.JButton();
        button_10 = new javax.swing.JButton();
        button_11 = new javax.swing.JButton();
        button_22 = new javax.swing.JButton();
        button_20 = new javax.swing.JButton();
        button_21 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        button_enviar_mensagem = new javax.swing.JButton();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_12ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        button_enviar_mensagem.setLabel("Enviar");
        button_enviar_mensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_enviar_mensagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_00, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_20, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_01, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button_12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_02, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_22, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_enviar_mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(button_02, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button_00, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_01, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_20, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(button_enviar_mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_enviar_mensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_enviar_mensagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_enviar_mensagemActionPerformed

    private void button_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_12ActionPerformed

    /**
     * @param args the command line arguments
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JogoDaVelha().setVisible(true);
            }
        });
    } */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton button_00;
    public javax.swing.JButton button_01;
    public javax.swing.JButton button_02;
    public javax.swing.JButton button_10;
    public javax.swing.JButton button_11;
    public javax.swing.JButton button_12;
    public javax.swing.JButton button_20;
    public javax.swing.JButton button_21;
    public javax.swing.JButton button_22;
    private javax.swing.JButton button_enviar_mensagem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    public javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
    public JButton[][] matrizVelhaBotao = {{button_00, button_01, button_02},{button_10, button_11, button_12},{button_20, button_21, button_22}};    

    void atualizaChat() {
                System.out.println("atualiza  - ok ");            
        
        jTextArea1.setText(this.chat);
    }

}
