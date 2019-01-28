package br.com.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;

import br.com.complemento.Formatos;
import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoFilial;
import br.com.daobeans.DaoUsuariosTemporario;
import br.com.daobeans.DaoVeiculo;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Categoria;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.UsuariosTemporario;
import br.com.model.entidadesbeans.Veiculo;
import br.com.view.ExibirMensagem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControleCadastroVeiculoPanel implements Initializable {
	@FXML
    private Pane CadastroVeiculoPanel;
	@FXML
	private TextField anoModeloField;
	
    @FXML
    private TextField modeloField;

    @FXML
    private TextField fabricanteField;

    @FXML
    private ComboBox<String> categoriaBox;

    @FXML
    private TextField anoFabField;

    @FXML
    private ComboBox<String> tamanhoBox;

    @FXML
    private TextField nChassiField;

    @FXML
    private TextField nMotorField;

    @FXML
    private TextField nPassageiroField;

    @FXML
    private TextField nPortasField;

    @FXML
    private ComboBox<String> filialBox;

    @FXML
    private ComboBox<String> combustivelField;

    @FXML
    private TextField corField;

    @FXML
    private TextField torqueMotorField;

    @FXML
    private TextField quilometragemAntigaField;

    @FXML
    private TextField quilometragemAtualField;

    @FXML
    private Button salvarButton;

    @FXML
    private TextField placaField;
	
	@FXML
    private Pane panelCarga;

    @FXML
    private ComboBox<String> cambioBox;

    @FXML
    private CheckBox cameraBox;

    @FXML
    private CheckBox direcaoBox;

    @FXML
    private CheckBox mp3Box;

    @FXML
    private CheckBox arcondBox;

    @FXML
    private CheckBox dvdBox;

    @FXML
    private CheckBox radioBox;

    @FXML
    private TextField desempenhoField;

    @FXML
    private TextField capacidadeField;

    @FXML
    private TextField potenciaMotField;

    @FXML
    private TextField distEixosField;

    @FXML
    private TextField volumeField;

    @FXML
    private ComboBox embreagemBox;

    @FXML
    private Pane panelPassageiro;

    @FXML
    private CheckBox rodaBox;

    @FXML
    private CheckBox airBagBox;

    @FXML
    private CheckBox cintoBox;

    @FXML
    private CheckBox controlePolBox;

    @FXML
    private CheckBox direcaoAbox;

    @FXML
    private CheckBox mp3Box1;

    @FXML
    private CheckBox dvdBox1;

    @FXML
    private CheckBox cameraBox1;

    @FXML
    private CheckBox direcaoBox1;

    @FXML
    private CheckBox arcondBox1;

    @FXML
    private CheckBox radioBox1;

    @FXML
    private ComboBox<String> cambioBox1;

    @FXML
    private Pane pane;
	
    private DaoVeiculo daoVeiculo;
    private DaoCategoria daoCategoria;
    private DaoFilial daoFilial;
    private DaoUsuariosTemporario daoUsuariosTemporario;
    private List<Categoria> categorias  =new ArrayList<>();
    private List<Filial> filiais = new ArrayList<>();
    
    private static Veiculo veiculo=null;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			daoUsuariosTemporario = new DaoUsuariosTemporario();
			
			ObservableList<String> tamanhos = FXCollections.observableArrayList("Nenhum","Pequeno","Medio","Grande");
			tamanhoBox.getItems().addAll(tamanhos);
			
			tamanhoBox.getSelectionModel().select(0);
			
			ObservableList<String> cambios = FXCollections.observableArrayList("Manual","Automatico");
			//tamanhoBox.getItems().addAll(tamanhos);
			
			cambioBox.getItems().addAll(cambios);
			cambioBox1.getItems().addAll(cambios);
			
			ObservableList<String> combustiveis = FXCollections.observableArrayList("Nenhum","Gasolina","Etanol","Diesel","Gasolina e Etanol","Gasolina e Disel");
			
			combustivelField.getItems().addAll(combustiveis);
			
			daoVeiculo = new DaoVeiculo();
			daoCategoria  = new DaoCategoria();
			daoFilial = new DaoFilial();
			
			if(categorias.size()>0) {
				categorias.removeAll(categorias);
			}
			categorias = daoCategoria.BuscaCategoria("");
			
			if(categoriaBox.getItems().size()>0) {
				categoriaBox.getItems().removeAll(categoriaBox.getItems());
			}
			//categoriaBox.getItems().add("Nenhuma");
			for(Categoria c: categorias) {
				categoriaBox.getItems().add(c.getNome());
			}
			
			categoriaBox.getSelectionModel().select(0);
			ObservableList<String> tipos = FXCollections.observableArrayList("Manual","Hidraulica");
			embreagemBox.getItems().addAll(tipos);
			if(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro()!=null) {
				panelCarga.setVisible(false);
				panelPassageiro.setVisible(true);
				cambioBox.getSelectionModel().select(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getTipo_cambio());
				arcondBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isAr_condicionado());
				radioBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isRádio());
				dvdBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDvd());
				cameraBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isCamera_re());
				direcaoAbox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isDireção_assistida());
				direcaoBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDirecao_hidraulica());
				airBagBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isAir_bag());
				cintoBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isCinto_de_seguranca_trazeiro());
				mp3Box.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isMp3());
				controlePolBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isControle_poluicao());
				rodaBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isRodas_de_liga_leve());
			}else {
				panelPassageiro.setVisible(false);
				panelCarga.setVisible(true);
				cambioBox1.getSelectionModel().select(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getTipo_cambio());
				arcondBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isAr_condicionado());
				cameraBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isCamera_re());
				radioBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isRádio());
				direcaoBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDirecao_hidraulica());
				mp3Box1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isMp3());
				dvdBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDvd());
				potenciaMotField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getPotencia_do_motor());
				distEixosField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getDistância_eixos());
				volumeField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getVolume_combustivel());
				capacidadeField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getCapacidade_carga());
				desempenhoField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getDesempenho());
				embreagemBox.getSelectionModel().select(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getEmbreagem());
			}
			
			
//			categoriaBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//
//				@Override
//				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//					System.out.print(categoriaBox.getSelectionModel().getSelectedIndex());
//					
//				}
//				
//			});
			if(filiais.size()>0) {
				filiais.removeAll(filiais);
			}
			filiais = daoFilial.BuscaFilial("");
			filialBox.getItems().add("Nenhuma");
			for(Filial f: filiais) {
				filialBox.getItems().add(f.getNome());
			}
			
			filialBox.getSelectionModel().select(0);
			if(veiculo!=null) {
				preencher();
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@FXML
    void actionPeformed(ActionEvent e) {
		if(salvarButton==e.getSource()) {
			Veiculo v = new Veiculo();
			v.setModelo(modeloField.getText());
			v.setAno_fabricacao(Integer.parseInt(anoFabField.getText()));
			v.setAno_modelo(Integer.parseInt(anoModeloField.getText()));
			v.setCategoria(categoriaBox.getSelectionModel().getSelectedItem());
			v.setCat(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()));
			v.setCor(corField.getText());
			v.setFabricante(fabricanteField.getText());
			v.setFilial(filiais.get(filialBox.getSelectionModel().getSelectedIndex()-1));
			v.setNome_placa(placaField.getText());
			v.setNumero_chassi(nChassiField.getText());
			v.setNumero_de_portas(Integer.parseInt(nPortasField.getText()));
			v.setNumero_motor(nMotorField.getText());
			v.setNumero_passageiro(Integer.parseInt(nPassageiroField.getText()));
			v.setQuilometragem_antiga(Double.parseDouble(quilometragemAntigaField.getText()));
			v.setQuilometragem_atual(Double.parseDouble(quilometragemAtualField.getText()));
			v.setTamanho(tamanhoBox.getSelectionModel().getSelectedItem());
			v.setTipo_combustivel(combustivelField.getSelectionModel().getSelectedItem());
			v.setTorque_motor(torqueMotorField.getText());
			if(veiculo!=null) {
				UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
				v.setId(veiculo.getId());
				v.setDisponivel(veiculo.isDisponivel());
				daoVeiculo.updateVeiculo(v);
				ExibirMensagem.exibir("Veiculo atualizado com Sucesso!!");
				ControleHomeFuncionario.veiculoPanel.setCenter(ControleHomeFuncionario.consultaVeiculoPanel);
			}else {
				UsuariosTemporario usuariosTemporario = new UsuariosTemporario();
	    		usuariosTemporario.setUsuario(ControleLoginFrame.u);
	    		daoUsuariosTemporario.persistUsuarioTemporario(usuariosTemporario);
				v.setDisponivel(true);
				daoVeiculo.persistVeiculo(v);
				ExibirMensagem.exibir("Veiculo cadastrado com Sucesso!!");
			}
			modeloField.setText("");
			anoFabField.setText("");
			anoModeloField.setText("");
			categoriaBox.getSelectionModel().select(0);
			corField.setText("");
			fabricanteField.setText("");
			filialBox.getSelectionModel().select(0);
			placaField.setText("");
			nChassiField.setText("");
			nPortasField.setText("");
			nMotorField.setText("");
			nPassageiroField.setText("");
			quilometragemAntigaField.setText("");
			quilometragemAtualField.setText("");
			tamanhoBox.getSelectionModel().select(0);
			combustivelField.getSelectionModel().select(0);
			torqueMotorField.setText("");
			veiculo=null;
		}else if(categoriaBox==e.getSource()) {
			if(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro()!=null) {
				panelCarga.setVisible(false);
				panelPassageiro.setVisible(true);
				cambioBox.getSelectionModel().select(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getTipo_cambio());
				arcondBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isAr_condicionado());
				radioBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isRádio());
				dvdBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDvd());
				cameraBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isCamera_re());
				direcaoAbox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isDireção_assistida());
				direcaoBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDirecao_hidraulica());
				airBagBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isAir_bag());
				cintoBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isCinto_de_seguranca_trazeiro());
				mp3Box.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isMp3());
				controlePolBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isControle_poluicao());
				rodaBox.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_passageiro().isRodas_de_liga_leve());
			}else if(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga()!=null) {
				panelPassageiro.setVisible(false);
				panelCarga.setVisible(true);
				cambioBox1.getSelectionModel().select(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getTipo_cambio());
				arcondBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isAr_condicionado());
				cameraBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isCamera_re());
				radioBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isRádio());
				direcaoBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDirecao_hidraulica());
				mp3Box1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isMp3());
				dvdBox1.setSelected(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).isDvd());
				potenciaMotField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getPotencia_do_motor());
				distEixosField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getDistância_eixos());
				volumeField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getVolume_combustivel());
				capacidadeField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getCapacidade_carga());
				desempenhoField.setText(""+categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getDesempenho());
				embreagemBox.getSelectionModel().select(categorias.get(categoriaBox.getSelectionModel().getSelectedIndex()).getCategoria_carga().getEmbreagem());
			}
			
		}
		//falta colocar a restrição de campos vazios
		
    }
	
	public void preencher() {
		modeloField.setText(veiculo.getModelo());
		anoFabField.setText(""+veiculo.getAno_fabricacao());
		anoModeloField.setText(""+veiculo.getAno_modelo());
		categoriaBox.getSelectionModel().select(veiculo.getCat().getNome());
		corField.setText(veiculo.getCor());
		fabricanteField.setText(veiculo.getFabricante());
		filialBox.getSelectionModel().select(veiculo.getFilial().getNome());
		placaField.setText(veiculo.getNome_placa());
		nChassiField.setText(veiculo.getNumero_chassi());
		nPortasField.setText(""+veiculo.getNumero_de_portas());
		nMotorField.setText(veiculo.getNumero_motor());
		nPassageiroField.setText(""+veiculo.getNumero_passageiro());
		quilometragemAntigaField.setText(""+veiculo.getQuilometragem_antiga());
		quilometragemAtualField.setText(""+veiculo.getQuilometragem_atual());
		tamanhoBox.getSelectionModel().select(veiculo.getTamanho());
		combustivelField.getSelectionModel().select(veiculo.getTipo_combustivel());
		torqueMotorField.setText(veiculo.getTorque_motor());
	}
	
	
	public static Veiculo getVeiculo() {
		return veiculo;
	}
	public static void setVeiculo(Veiculo veiculo) {
		ControleCadastroVeiculoPanel.veiculo = veiculo;
	}

}
