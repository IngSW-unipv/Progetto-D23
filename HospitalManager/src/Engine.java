
import it.unipv.sfw.controller.loginController.LoginController;
import it.unipv.sfw.jdbc.FacadeSingletonDB;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class Engine {
	public static void main(String[] args) {
		FacadeSingletonDB db = FacadeSingletonDB.getIstanzaFacade();
		StrutturaSanitaria model =db.getStruttura1();
		ViewController view = new ViewController();
		LoginController controllerLogin = new LoginController(model, view);
		
		
	}
}
