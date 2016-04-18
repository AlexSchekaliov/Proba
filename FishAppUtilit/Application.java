package FishAppUtilit;
import javax.swing.SwingUtilities;

import fishAppDBUtilit_demo_1_Controllers.CheckDBFrameController;
import fishAppDBUtilit_demo_1_Models.CheckDBFrameModel;
import fishAppUtilitMVC_demo_1_Viewes.CheckDBFrameView;

public class Application {

	private static CheckDBFrameController controller;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				runApp();
			}
		});
		
		

	}

	public static void runApp() {
	
		CheckDBFrameModel model = new CheckDBFrameModel();
		
		CheckDBFrameView view= new CheckDBFrameView(model);
		
		controller = new CheckDBFrameController(view, model);
		
	}

}
