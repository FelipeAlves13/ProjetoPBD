package br.com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import br.com.app.App;
import br.com.complemento.Formatos;
import br.com.daobeans.DaoBackup;
import br.com.model.entidadesbeans.Backup;
import br.com.view.ExibirMensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControleBackup implements Initializable {
	@FXML
    private TextField diretorioField;
	
    @FXML
    private Button backupButton;

    @FXML
    private TextField nomeField;
    
    public static Backup b;
    
    private DaoBackup daoBackup;

    @FXML
    void actionPeformed(ActionEvent e) throws ParseException {
    	if(backupButton==e.getSource()) {
    		try {
    			Backup b = new Backup();
    			b.setId(this.b.getId());
    			b.setDiretorio(diretorioField.getText());
				b.setNome(nomeField.getText());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								
				GregorianCalendar gc = new GregorianCalendar();
			
				gc.setTimeInMillis(new Date().getTime());
				
				gc.add(Calendar.DAY_OF_MONTH, 1);
				b.setData(sdf.parse(sdf.format(gc.getTime())));
				b.setHora(ControleBackup.b.getHora());
				b.setStatus(true);
				daoBackup.updateBackup(b);
				this.b.setStatus(true);
    			fazerBackup(diretorioField.getText()+nomeField.getText()+Formatos.getDataOutroFormat().format(new Date())+".backup");
    			
				App.getBf().invisivel();
    		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(b!=null) {
			preencher();
		}
		daoBackup = new DaoBackup();
		
	}
	public void preencher() {
		
		diretorioField.setText(b.getDiretorio());
		nomeField.setText(b.getNome());
	}
	
	public  void fazerBackup(String diretorio) throws IOException {
		ProcessBuilder pb;
		Process p;
		 BufferedReader br = null;
		pb = new ProcessBuilder("C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe","-i","-h","localhost","-p","5432","-U","postgres","-F","c","-b","-v","-f",diretorio,"banco_pbd");
		pb.environment().put("PGPASSWORD", "123");
		pb.redirectErrorStream(true);
		p = pb.start();
		final InputStreamReader isr = new InputStreamReader(p.getInputStream());
        br = new BufferedReader(isr);
         
        String line;
        String temp = null;
        int i =0;
        while((line = br.readLine()) != null) {
        	if(i==0) {
        		temp = line;
        	    	
        	}else {
        		temp=temp+"\n"+line;
        	}
        	
        	i++;
        }
		ExibirMensagem.exibir("Backup Feito com sucesso!!");
		
		//JOptionPane.showMessageDialog(null,"Backup realizaddo");
	}
	
	
	public static Backup getB() {
		return b;
	}
	public static void setB(Backup b) {
		ControleBackup.b = b;
	}
	
	
}
