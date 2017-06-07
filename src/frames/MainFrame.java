package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableCellRenderer;

import sql.SQLUtility;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.SpringLayout;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4655806278604526919L;
	private static JPanel cnpn_main;
	private static JTable tbl_main;
	private static SpringLayout sl_cnpn_main;
	private static JScrollPane scrollPane;

	public MainFrame() {
		setTitle("ReMobile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 551);
		
		JMenuBar mnbr_main = new JMenuBar();
		setJMenuBar(mnbr_main);
		
		JMenu mntmFile = new JMenu("File");
		mntmFile.setMaximumSize(new Dimension(100, 100));
		mnbr_main.add(mntmFile);
		
		JMenuItem mntm_add = new JMenuItem("Hinzufügen");
		mntm_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFrame af = new AddFrame();
			}
		});
		mntmFile.add(mntm_add);

		

		
		JMenu mntm_view = new JMenu("View");
		mntm_view.setMaximumSize(new Dimension(100, 100));
		mnbr_main.add(mntm_view);
		
		JMenuItem mntm_objects = new JMenuItem("Objekte");
		mntm_objects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadTable("objekte");
			}
		});
		mntm_view.add(mntm_objects);
		
		JMenuItem mntm_info = new JMenuItem("Objektinfo");
		mntm_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadTable("objektinfo");
			}
		});
		mntm_view.add(mntm_info);
		
		JMenuItem mntm_price = new JMenuItem("Preise");
		mntm_price.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadTable("preise");
			}
		});
		mntm_view.add(mntm_price);
		
		cnpn_main = new JPanel();
		cnpn_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cnpn_main);
		sl_cnpn_main = new SpringLayout();
		cnpn_main.setLayout(sl_cnpn_main);
		
		tbl_main = SQLUtility.getFilledTable("objekte");
		tbl_main.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Color color = UIManager.getColor("Table.gridColor");
		//MatteBorder border = new MatteBorder(1, 1, 0, 0, color);
		//tbl_main.setBorder(border);
		
		tbl_main.setGridColor(Color.gray);
		tbl_main.setShowGrid(true);
		tbl_main.setEnabled(false);
		
		scrollPane = new JScrollPane(tbl_main);
		sl_cnpn_main.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.NORTH, cnpn_main);
		sl_cnpn_main.putConstraint(SpringLayout.WEST, scrollPane, 20, SpringLayout.WEST, cnpn_main);
		sl_cnpn_main.putConstraint(SpringLayout.SOUTH, scrollPane, -20, SpringLayout.SOUTH, cnpn_main);
		sl_cnpn_main.putConstraint(SpringLayout.EAST, scrollPane, -20, SpringLayout.EAST, cnpn_main);
		cnpn_main.add(scrollPane);
	}
	
	public static void reloadTable(String tbl) {
		tbl_main.setModel(SQLUtility.getFilledTable(tbl).getModel());
		SQLUtility.resizeColumnWidth(tbl_main);
		tbl_main.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbl_main.revalidate();
	}
}
