package sql;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class SQLUtility {

	public static JTable getFilledTable(String tbl) {
		ArrayList columnNames = new ArrayList<>();
		ArrayList data = new ArrayList();
		
		String url = "jdbc:mysql://localhost:3306/reimmo?autoReconnect=true&useSSL=false";
		String userid = "root";
		String password = "Sandwurm357";
		String sql = "SELECT * FROM "+ tbl;
		
		try (Connection conn = DriverManager.getConnection(url, userid, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) 
		{
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				columnNames.add(md.getColumnName(i));
			}
			
			while (rs.next()) {
				ArrayList row = new ArrayList(columns);
				
				for (int i = 1; i<= columns; i++) {
					row.add(rs.getObject(i));
				}
				
				data.add(row);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		Vector columnNamesVector = new Vector<>();
		Vector dataVector = new Vector();
		
		for (int i = 0; i < data.size(); i++) {
			ArrayList subArray = (ArrayList)data.get(i);
			Vector subVector = new Vector();
			for (int j = 0; j < subArray.size(); j++) {
				subVector.add(subArray.get(j));
			}
			dataVector.add(subVector);
		}
		
		for (int i = 0; i < columnNames.size(); i++) { 
			columnNamesVector.add(columnNames.get(i));
		}
		
		JTable table  = new JTable(dataVector, columnNamesVector) {
			public Class getColumnClass (int column) {
				for (int row = 0; row < getRowCount(); row++) {
					Object o = getValueAt(row, column);
					
					if (o != null) {
						return o.getClass();
					}
				}
				
				return Object.class;
			}
		};
		
		resizeColumnWidth(table);
		return table;
	}
	
	public static void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 15;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1,  width);
			}
			if (width > 900)
				width = 900;
			if (width < 50)
				width = 50;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
}
