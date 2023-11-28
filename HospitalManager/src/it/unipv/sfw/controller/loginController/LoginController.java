package it.unipv.sfw.controller.loginController;

//import it.unipv.sfw.jdbc.bean.DbControllerSingleton;  // controller del db
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController; // MainView

public class LoginController {
	private ViewController view;
	private static StrutturaSanitaria model = StrutturaSanitaria.getIstanzaStruttura();
	private GoBtnActionListener go;
	
	public LoginController(StrutturaSanitaria model, ViewController view) {

		this.view = view; 
		this.model = model;

		go = new GoBtnActionListener(model, view);
		view.getLoginPanel().getBtnLogin().addActionListener(go);

		addEsciActionListener();
	}

	public GoBtnActionListener getGo() {
		return go;
	}

	private void addEsciActionListener() {

		EsciAccountActionListener esci = new EsciAccountActionListener(model, view);
		view.getMedicoPanel().getLogoutBtn().addActionListener(esci);
		view.getPazientePanel().getLogoutBtn().addActionListener(esci);
		view.getOperatoreSanitarioPanel().getLogoutBtn().addActionListener(esci);
		view.getOperatoreUfficioPanel().getLogoutBtn().addActionListener(esci);

	}
}
