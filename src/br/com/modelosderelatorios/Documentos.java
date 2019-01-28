package br.com.modelosderelatorios;
import java.awt.Desktop;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.model.entidadesbeans.Clientes_juridicosview;
import br.com.view.ExibirMensagem;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Documentos {

	@SuppressWarnings("deprecation")
	public void gerarDocumento(List<? extends Object> list, String layout) throws JRException, FileNotFoundException {

		// gerando o jasper design
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(layout);

		System.out.println(inputStream);
		JasperDesign desenho = JRXmlLoader.load(inputStream);

		// compila o relatório
		JasperReport relatorio = JasperCompileManager.compileReport(desenho);

		/* Convert List to JRBeanCollectionDataSource */
		JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(list);

		/* Map to hold Jasper report Parameters */
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ItemDataSource", itemsJRBean);

		/* Using compiled version(.jasper) of Jasper report to generate PDF */
		JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parameters, itemsJRBean);
		JasperExportManager.exportReportToPdfFile(jasperPrint,"C://Users//DBÇ8//Desktop//relatorio.pdf");
//		JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
//		jasperViewer.setZoomRatio(1.20F);
//		jasperViewer.setLocationRelativeTo(null);
//		jasperViewer.show();
		// JasperViewer.viewReport(jasperPrint);
	
	}
	
	public  void visualizar() throws JRException, IOException {
		File arquivos[];
		File diretorio = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Relatorios\\Clientes_Fisicos\\");
		FileFilter filter = new FileFilter() {
		    public boolean accept(File file) {
		        return file.getName().endsWith(".pdf");
		    }
		};
		arquivos = diretorio.listFiles(filter);
		for(File f:arquivos) {
			System.out.println(f.getName());
//			if(f.getName().equals("relatorio.pdf")) {
//				Desktop.getDesktop().open(f);
//			}
			
		}
		//InputStream inputStream = new FileInputStream("C://Users//DBÇ8//Desktop//relatorio.pdf");
//		JRViewer viewer = new JRViewer(new FileInputStream("C://Users//DBÇ8//Desktop//relatorio.pdf"),false);
//		JFrame frameRelatorio = new JFrame();
//		 frameRelatorio.add( viewer, BorderLayout.CENTER );
//		 frameRelatorio.setSize( 500, 500 );
//		 frameRelatorio.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
//		 frameRelatorio.setVisible( true );
		//		InputStream inputStream = new FileInputStream(layout);
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		
//		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters);
//		JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
//		jasperViewer.setZoomRatio(1.20F);
//		jasperViewer.setLocationRelativeTo(null);
//		jasperViewer.show();
	}
	
	public static void main(String[] args) throws JRException, IOException {
//		List<Clientes_juridicosview> clientes = new ArrayList<>();
//		Clientes_juridicosview relatorioClientePJ = new Clientes_juridicosview();
//		relatorioClientePJ.setNome("Felipe");
//		relatorioClientePJ.setCnpj("012.234.123-00/1234");
//		relatorioClientePJ.setInscricao_estadual("asdfgh");
//		relatorioClientePJ.setCidade("Carnaiba");
//		relatorioClientePJ.setUf("PE");
//		clientes.add(relatorioClientePJ);
//		Clientes_juridicosview relatorioClientePJ2 = new Clientes_juridicosview();
//		relatorioClientePJ2.setNome("Francisco");
//		relatorioClientePJ2.setCnpj("012.234.123-00/1234");
//		relatorioClientePJ2.setInscricao_estadual("asdfgh");
//		relatorioClientePJ2.setCidade("Carnaiba");
//		relatorioClientePJ2.setUf("PE");
//		clientes.add(relatorioClientePJ2);
//		new Documentos().gerarDocumento(clientes, "br/com/modelosderelatorios/ClientesPJ.jrxml");
		new Documentos().visualizar();
		//		try {
//			List<DocumentoContratoAdapter> list = new ArrayList<>();
//			
//			Contrato contrato = new Contrato();
//			contrato.setArea(Area.CIVIL);
//			contrato.setDados_banco("BANCO DO BRASIL, AGÊNCIA 0000-0, CONTA CORRENTE 00.000-0, CPF 000.000.000-00");
//			contrato.setObjeto("Prestação de serviços advocatícios");
//			List<Parcela>parcelas = new ArrayList<>();
//			parcelas.add(new Parcela());
//			contrato.setParcelas(parcelas);
//			contrato.setTipo_pagamento(TipoPagamento.A_VISTA);
//			contrato.setValor_total(120000);
//			contrato.setObjeto("apresentar defesa");
//			contrato.setPartes(DaoCommun.getInstance().getPartes(7, Tabela.PROCESSO));
//			Consulta consulta = new Consulta();
//			Cliente cliente = Fachada.getInstance().buscarClientePorId(1);
//			Funcionario funcionario = Fachada.getInstance().buscarPorLogin("mael_santos7", "07080209");
//			consulta.setCliente(cliente);
//			consulta.setFuncionario(funcionario);
//			contrato.setConsulta(consulta);
//			contrato.setData_contrato(new Date());
//			
//			DocumentoContratoAdapter adapter = new DocumentoContratoAdapter();
//			adapter.setContrato(contrato);
//			adapter.setNumeroProcesso("900989998");
//			adapter.setTipo(Instancia.INSTANCIA_1);
//			adapter.setComarca("serra talhada/pe");
//			
//			list.add(adapter);
//						
//			new Documentos().gerarDocumento(list, "ContratoSem.jrxml");
//			
//		} catch (FileNotFoundException | JRException | BusinessException | DaoException e) {
//			e.printStackTrace();
//		}
		
	}
}
