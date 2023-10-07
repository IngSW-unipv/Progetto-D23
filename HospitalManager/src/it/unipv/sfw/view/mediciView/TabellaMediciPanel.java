package it.unipv.sfw.view.mediciView;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import it.unipv.sfw.view.TableModel;


public class TabellaMediciPanel {

	private JTable table; // ATTENZIONE QUI SE NO PUNTA NULLO

	public TabellaMediciPanel(JScrollPane scrollPane) {

		table = new JTable();
		
		scrollPane.setViewportView(table);

		TableModel modello1 = new TableModel(new Object[][] {}, new String[] { "Nome", "Cognome", "CF", "Sesso",
				"Email", "Cellulare", "LuogoNascita", "Indirizzo", "Cap", "Paese", "DataNascita",
				"codiceRegionale", "specializzazione", "dataAssunzione" });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}

}
