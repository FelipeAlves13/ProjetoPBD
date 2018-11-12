package br.com.controller;

import br.com.view.TelaLogin;
import br.com.view.TelaPrincipal;

public class ControlerTelaLogin {
	
	public ControlerTelaLogin(TelaLogin tl,TelaPrincipal tp) {
		if(tl.getOp()== 0) {
			tp.setVisible();
		}
	}
}
