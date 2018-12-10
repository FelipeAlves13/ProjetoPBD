package br.com.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.complemento.Criptografia;
import br.com.daobeans.DaoPessoa;
import br.com.exception.DaoException;
import br.com.modelbeans.Pessoa;
import br.com.view.TelaCadastroCliente;
import br.com.view.TelaCliente;

public class ControleCliente implements ActionListener {
	private TelaCadastroCliente telaCadastroCliente;
	private TelaCliente telaCliente;
	private DaoPessoa daoPessoa;
	private ArrayList<Pessoa> clientes;
	
	public ControleCliente(TelaCadastroCliente telaCadastroCliente,TelaCliente telaCliente) {
		this.telaCadastroCliente  =telaCadastroCliente;
		this.telaCliente = telaCliente;
		
		this.daoPessoa = new DaoPessoa();
		
		this.telaCliente.getBtnAtualizar().addActionListener(this);
		this.telaCliente.getBtnBuscar().addActionListener(this);
		this.telaCliente.getBtnReset().addActionListener(this);
		this.telaCliente.getBtnEditar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.telaCliente.getBtnAtualizar()==e.getSource()) {
			this.telaCadastroCliente.getCepField().setText("");
			this.telaCadastroCliente.getCidadeField().setText("");
			this.telaCadastroCliente.getTelefoneField().setText("");
			this.telaCadastroCliente.getUfBox().setSelectedIndex(0);
			this.telaCadastroCliente.getBairroField().setText("");
			this.telaCadastroCliente.getRuaField().setText("");
			//verifica se a pessoa e fisica ou juridica para poder exibir o cpf ou cnpj respectivamente 
			//if(clientes.get(this.telaCliente.getTable().getSelectedRow()).getPessoaJuridica()==null) {
			
			this.telaCadastroCliente.getCpfouCnpjField().setText("");
			this.telaCadastroCliente.getCpfouCnpjBox().setSelectedIndex(0);
			this.telaCadastroCliente.getCnpjField().setText("");
			this.telaCadastroCliente.getVencHabField().setText("");
			
			this.telaCadastroCliente.getCodigoField().setText("");
			this.telaCadastroCliente.getNomeField().setText("");
			this.telaCadastroCliente.getLoginField().setText("");
			this.telaCadastroCliente.getInscField().setText("");
			this.telaCadastroCliente.getPasswordField().setText("");
		
			this.telaCadastroCliente.getSexoBox().setSelectedIndex(0);
			Calendar c = Calendar.getInstance();
			//c.setTime();
			//String mes = null;
			SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
			//adicionar um zero quando o numero do mes so tem um digito
//		
		//	if(((""+c.get(c.MONTH)+1)).length()==2) {
//				mes = "0"+(c.get(c.MONTH)+1);
//			}else {  
//				mes=""+(c.get(c.MONTH)+1);
//			}
//			String s = c.get(c.DAY_OF_MONTH)+""+mes+""+c.get(c.YEAR);
			this.telaCadastroCliente.getNascField().setText("");
			
			
			this.telaCadastroCliente.setVisible(true);
		}else if(this.telaCliente.getBtnBuscar()==e.getSource()) {
			
			try {
				clientes=new ArrayList<>();
				clientes=(ArrayList<Pessoa>) daoPessoa.BuscaPessoa(this.telaCliente.getTextField().getText());
			
				Object[][] linhas = new Object[clientes.size()][4];
				
				int i = 0;
				for(Pessoa p: clientes) {
					linhas[i][0] = p.getNome();
					
					if(p.getPessoaJuridica()==null) {
						linhas[i][1] = p.getPessoaFisica().getCpf();
					}else {
						linhas[i][1] = p.getPessoaJuridica().getCnpj();
					}
					String mes = null;
					Calendar c = Calendar.getInstance();
					c.setTime(p.getData_nasc());
					if(((""+c.get(c.MONTH)+1)).length()==2) {
						mes = "0"+(c.get(c.MONTH)+1);
					}else {
						mes=""+(c.get(c.MONTH)+1);
					}
					linhas[i][2] = c.get(c.DAY_OF_MONTH)+"/"+mes+"/"+c.get(c.YEAR);
					linhas[i][3] = p.getSexo();
					i++;
				}
				
				this.telaCliente.getTable().setModel(new DefaultTableModel(linhas,new String[] {
					"Nome", "CPF/CNPJ", "Data de nascimento", "Sexo"
				}));
				
				this.telaCliente.getTable().setBackground(Color.white);
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(this.telaCliente.getBtnReset()==e.getSource()) {
			try {
				if(this.telaCliente.getTable().getSelectedRow()>=0){
					clientes.get(this.telaCliente.getTable().getSelectedRow()).setSenha(Criptografia.encrypt("epilef"));
					daoPessoa.updatePessoa(clientes.get(this.telaCliente.getTable().getSelectedRow()));
					JOptionPane.showMessageDialog(null,"Senha resetada!!Nova senha: "+Criptografia.decrypt(clientes.get(this.telaCliente.getTable().getSelectedRow()).getSenha()));
				}else{
					JOptionPane.showMessageDialog(null,"Selecione um Cliente da tabela para reseta a senha!!");
				}
			} catch (InvalidKeyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BadPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalBlockSizeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidAlgorithmParameterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(this.telaCliente.getBtnEditar()==e.getSource()){
			if(this.telaCliente.getTable().getSelectedRow()>=0) {
				try {
					this.telaCadastroCliente.getCepField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getEndereco().getCep());
					this.telaCadastroCliente.getCidadeField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getEndereco().getCidade());
					this.telaCadastroCliente.getTelefoneField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getEndereco().getTelefone());
					this.telaCadastroCliente.getUfBox().setSelectedItem(clientes.get(this.telaCliente.getTable().getSelectedRow()).getEndereco().getUf());
					this.telaCadastroCliente.getRuaField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getEndereco().getRua());
					this.telaCadastroCliente.getBairroField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getEndereco().getBairro());
					//verifica se a pessoa e fisica ou juridica para poder exibir o cpf ou cnpj respectivamente 
					if(clientes.get(this.telaCliente.getTable().getSelectedRow()).getPessoaJuridica()==null) {
						this.telaCadastroCliente.getCpfouCnpjBox().setSelectedIndex(0);
						this.telaCadastroCliente.getCpfouCnpjField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getPessoaFisica().getCpf());
						this.telaCadastroCliente.getnHabField().setText(""+clientes.get(this.telaCliente.getTable().getSelectedRow()).getPessoaFisica().getNum_habilitacao());
						SimpleDateFormat sdf3 = new SimpleDateFormat("dd/mm/yyyy");
						this.telaCadastroCliente.getVencHabField().setText(sdf3.format(clientes.get(this.telaCliente.getTable().getSelectedRow()).getPessoaFisica().getData_venc_habilita()));
					}else {
						this.telaCadastroCliente.getCpfouCnpjBox().setSelectedIndex(1);
						this.telaCadastroCliente.getCnpjField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getPessoaJuridica().getCnpj());
						this.telaCadastroCliente.getInscField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getPessoaJuridica().getInscricao_estadual());
					}
					this.telaCadastroCliente.getCodigoField().setText(""+clientes.get(this.telaCliente.getTable().getSelectedRow()).getCodigo());
					this.telaCadastroCliente.getNomeField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getNome());
					this.telaCadastroCliente.getLoginField().setText(clientes.get(this.telaCliente.getTable().getSelectedRow()).getLogin());
				
					this.telaCadastroCliente.getPasswordField().setText(Criptografia.decrypt(clientes.get(this.telaCliente.getTable().getSelectedRow()).getSenha()));
				
					this.telaCadastroCliente.getSexoBox().setSelectedItem(clientes.get(this.telaCliente.getTable().getSelectedRow()).getSexo());
					Calendar c = Calendar.getInstance();
					//c.setTime();
					//String mes = null;
					SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
					//adicionar um zero quando o numero do mes so tem um digito
//				
				//	if(((""+c.get(c.MONTH)+1)).length()==2) {
//						mes = "0"+(c.get(c.MONTH)+1);
//					}else {  
//						mes=""+(c.get(c.MONTH)+1);
//					}
//					String s = c.get(c.DAY_OF_MONTH)+""+mes+""+c.get(c.YEAR);
					this.telaCadastroCliente.getNascField().setText(sdf3.format(clientes.get(this.telaCliente.getTable().getSelectedRow()).getData_nasc()));
					this.telaCadastroCliente.setVisible(true);
				} catch (InvalidKeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BadPaddingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchPaddingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalBlockSizeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidAlgorithmParameterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else {
				JOptionPane.showMessageDialog(null,"Selecione um clinte da tabela para editar!!");
			}
		}
		
	}

	public ArrayList<Pessoa> getClientes() {
		return clientes;
	}

	public TelaCliente getTelaCliente() {
		return telaCliente;
	}
	
	
}
