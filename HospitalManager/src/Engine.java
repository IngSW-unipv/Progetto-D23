
import it.unipv.sfw.controller.facadecontroller.FacadeController;
import it.unipv.sfw.jdbc.FacadeSingletonDB;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class Engine {
	public static void main(String[] args) {
		FacadeSingletonDB db = FacadeSingletonDB.getIstanzaFacade();
		IStrutturaSanitaria model = db.getStruttura1();
		ViewController view = new ViewController();
		FacadeController facadeController = new FacadeController(model, view);
		
	}
}
