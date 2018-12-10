package br.com.view;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CategoriaPasasageiroPanel extends JPanel{
	private JCheckBox controleCheckBox,rodasCheckBox,airBargCheckBox,direcaoAssistidaCheckBox,cintoCheckBox;
	
	public CategoriaPasasageiroPanel() {
		setSize(100,50);
		rodasCheckBox = new JCheckBox("Rodas de liga leve");
		rodasCheckBox.setBounds(6, 7, 133, 23);
		add(rodasCheckBox);
		
		airBargCheckBox = new JCheckBox("Air bag");
		airBargCheckBox.setBounds(189, 33, 85, 23);
		add(airBargCheckBox);
		
		direcaoAssistidaCheckBox = new JCheckBox("Dire\u00E7\u00E3o assistida");
		direcaoAssistidaCheckBox.setBounds(189, 7, 133, 23);
		add(direcaoAssistidaCheckBox);
		
		cintoCheckBox = new JCheckBox("Cinto de seguran\u00E7a trazeiro");
		cintoCheckBox.setBounds(346, 7, 184, 23);
		add(cintoCheckBox);
		
		controleCheckBox = new JCheckBox("Controle de polui\u00E7\u00E3o");
		controleCheckBox.setBounds(6, 33, 146, 23);
		add(controleCheckBox);
	}

	public JCheckBox getControleCheckBox() {
		return controleCheckBox;
	}

	public JCheckBox getRodasCheckBox() {
		return rodasCheckBox;
	}

	public JCheckBox getAirBargCheckBox() {
		return airBargCheckBox;
	}

	public JCheckBox getDirecaoAssistidaCheckBox() {
		return direcaoAssistidaCheckBox;
	}

	public JCheckBox getCintoCheckBox() {
		return cintoCheckBox;
	}
	
	
	
}
