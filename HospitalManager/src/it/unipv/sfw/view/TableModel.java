package it.unipv.sfw.view;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public TableModel(Object[][] data, String[] col) {
		super(data, col);
		}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
