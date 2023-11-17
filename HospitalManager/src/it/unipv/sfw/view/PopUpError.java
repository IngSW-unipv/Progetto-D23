package it.unipv.sfw.view;

import javax.swing.JOptionPane;

public class PopUpError {
	
		public static void infoBox(String infoMessage, String titleBar)
	    {
			JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE); 
	    }
	
}
