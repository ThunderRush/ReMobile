package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddFrame extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel cnpn_add;
	private JTextField text_status;
	private JTextField text_status_date;
	private JTextField text_status_from;
	private JTextField text_status_to;
	private JTextField text_worker;
	private JTextField text_titel;
	private JTextField text_type;
	private JTextField text_subtype;
	private JTextField text_country;
	private JTextField text_county;
	private JTextField text_zip;
	private JTextField text_city;
	private JTextField text_street;
	private JTextField text_number;
	private JTextField text_stairs;
	private JTextField text_floor;
	private JTextField text_door;
	private JTextField text_closeby;
	private JTextField text_key;
	private JTextField text_handover;
	private JTextField text_contract_type;
	private JTextField text_agreement;
	private JTextField text_agreement_from;
	private JTextField text_agreement_to;
	private JTextField text_movein;
	
	private JTextField text_bearing;
	private JTextField text_size;
	private JTextField text_living_space;
	private JTextField text_split_from;
	private JTextField text_useable_space;
	private JTextField text_garden;
	private JTextField text_cellar;
	private JTextField text_building_space;
	private JTextField text_total_space;
	private JTextField text_rooms;
	private JTextField text_balconies;
	private JTextField text_balcony_space;
	private JTextField text_terrace;
	private JTextField text_terrace_space;
	private JTextField text_loggias;
	private JTextField text_loggias_space;
	private JTextField text_height;
	private JTextField text_toilets;
	private JTextField text_baths;
	private JTextField text_garages;
	private JTextField text_storingrooms;
	private JTextField text_created_date;
	private JTextField text_energy_hwb;
	private JTextField text_energy_hwb_class;
	private JTextField text_energy_fgee;
	private JTextField text_energy_fgee_class;
	private JTextField text_energy_valid;
	
	private JTextField text_buying_price;
	private JTextField text_total_rent;
	private JTextField text_rent_gross;
	private JTextField text_furniture_rent_gross;
	private JTextField text_parkingspace_gross;
	private JTextField text_garage_gross;
	private JTextField text_operation_cost_gross;
	private JTextField text_heating_cost_gross;
	private JTextField text_warm_water_gross;
	private JTextField text_cooling_gross;
	private JTextField text_repair_layback_gross;
	private JTextField text_other_gross;
	private JTextField text_elevator_gross;
	private JTextField text_rent_msquared_from;
	private JTextField text_rent_msquared;
	private JTextField text_provision;
	private JTextField text_objectnumber;

	public AddFrame() {
		super();
		create();
		this.setVisible(true);
	}
	
	private void create() {
		setTitle("Grundstück hinzufügen");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1020, 500);
		cnpn_add = new JPanel();
		cnpn_add.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cnpn_add);
		SpringLayout sl_cnpn_add = new SpringLayout();
		cnpn_add.setLayout(sl_cnpn_add);
		
		JTabbedPane tbpn_add = new JTabbedPane(JTabbedPane.TOP);
		sl_cnpn_add.putConstraint(SpringLayout.NORTH, tbpn_add, 10, SpringLayout.NORTH, cnpn_add);
		sl_cnpn_add.putConstraint(SpringLayout.WEST, tbpn_add, 10, SpringLayout.WEST, cnpn_add);
		sl_cnpn_add.putConstraint(SpringLayout.SOUTH, tbpn_add, -10, SpringLayout.SOUTH, cnpn_add);
		sl_cnpn_add.putConstraint(SpringLayout.EAST, tbpn_add, -10, SpringLayout.EAST, cnpn_add);
		cnpn_add.add(tbpn_add);
		
		JPanel panl_object = new JPanel();
		tbpn_add.addTab("Objekte", null, panl_object, null);
		SpringLayout sl_panl_object = new SpringLayout();
		panl_object.setLayout(sl_panl_object);
		
		JLabel lbel_status = DefaultComponentFactory.getInstance().createLabel("Status");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_status, 20, SpringLayout.NORTH, panl_object);
		sl_panl_object.putConstraint(SpringLayout.EAST, lbel_status, 60, SpringLayout.WEST, panl_object);
		panl_object.add(lbel_status);
		
		text_status = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_status, -5, SpringLayout.NORTH, lbel_status);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_status, 6, SpringLayout.EAST, lbel_status);
		panl_object.add(text_status);
		text_status.setColumns(10);
		
		JLabel lbel_status_date = DefaultComponentFactory.getInstance().createLabel("Status Datum");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_status_date, 20, SpringLayout.SOUTH, lbel_status);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_status_date, 0, SpringLayout.WEST, lbel_status);
		panl_object.add(lbel_status_date);
		
		text_status_date = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_status_date, -5, SpringLayout.NORTH, lbel_status_date);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_status_date, 6, SpringLayout.EAST, lbel_status_date);
		panl_object.add(text_status_date);
		text_status_date.setColumns(10);
		
		JLabel lbel_status_from = DefaultComponentFactory.getInstance().createLabel("Status an");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_status_from, 20, SpringLayout.SOUTH, lbel_status_date);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_status_from, 0, SpringLayout.WEST, lbel_status);
		panl_object.add(lbel_status_from);
		
		text_status_from = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_status_from, -5, SpringLayout.NORTH, lbel_status_from);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_status_from, 6, SpringLayout.EAST, lbel_status_from);
		panl_object.add(text_status_from);
		text_status_from.setColumns(10);
		
		JLabel lbel_status_to = DefaultComponentFactory.getInstance().createLabel("Status Bis");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_status_to, 20, SpringLayout.SOUTH, lbel_status_from);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_status_to, 0, SpringLayout.WEST, lbel_status);
		panl_object.add(lbel_status_to);
		
		text_status_to = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_status_to, -5, SpringLayout.NORTH, lbel_status_to);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_status_to, 6, SpringLayout.EAST, lbel_status_to);
		panl_object.add(text_status_to);
		text_status_to.setColumns(10);
		
		JLabel lbel_worker = DefaultComponentFactory.getInstance().createLabel("Mitarbeiter");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_worker, 20, SpringLayout.SOUTH, lbel_status_to);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_worker, 0, SpringLayout.WEST, lbel_status);
		panl_object.add(lbel_worker);
		
		text_worker = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_worker, -5, SpringLayout.NORTH, lbel_worker);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_worker, 6, SpringLayout.EAST, lbel_worker);
		panl_object.add(text_worker);
		text_worker.setColumns(10);
		
		JLabel lbel_titel = DefaultComponentFactory.getInstance().createLabel("Titel");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_titel, 20, SpringLayout.SOUTH, lbel_worker);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_titel, 0, SpringLayout.WEST, lbel_status);
		panl_object.add(lbel_titel);
		
		text_titel = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_titel, -5, SpringLayout.NORTH, lbel_titel);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_titel, 6, SpringLayout.EAST, lbel_titel);
		sl_panl_object.putConstraint(SpringLayout.EAST, text_titel, 264, SpringLayout.EAST, text_status_from);
		panl_object.add(text_titel);
		text_titel.setColumns(10);
		
		JLabel lbel_type = DefaultComponentFactory.getInstance().createLabel("Objektart");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_type, 20, SpringLayout.SOUTH, lbel_titel);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_type, 0, SpringLayout.WEST, lbel_status);
		panl_object.add(lbel_type);
		
		text_type = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_type, -5, SpringLayout.NORTH, lbel_type);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_type, 6, SpringLayout.EAST, lbel_type);
		panl_object.add(text_type);
		text_type.setColumns(10);
		
		JLabel lbel_subtype = DefaultComponentFactory.getInstance().createLabel("Unterobjektart");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_subtype, 20, SpringLayout.SOUTH, lbel_type);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_subtype, 0, SpringLayout.WEST, lbel_status);
		panl_object.add(lbel_subtype);
		
		text_subtype = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_subtype, -5, SpringLayout.NORTH, lbel_subtype);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_subtype, 6, SpringLayout.EAST, lbel_subtype);
		panl_object.add(text_subtype);
		text_subtype.setColumns(10);
		
		JLabel lbel_country = DefaultComponentFactory.getInstance().createLabel("Land");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_country, 20, SpringLayout.SOUTH, lbel_subtype);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_country, 0, SpringLayout.WEST, lbel_status);
		panl_object.add(lbel_country);
		
		text_country = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_country, -4, SpringLayout.NORTH, lbel_country);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_country, 6, SpringLayout.EAST, lbel_country);
		sl_panl_object.putConstraint(SpringLayout.EAST, text_country, 0, SpringLayout.EAST, text_status);
		panl_object.add(text_country);
		
		JLabel lbel_county = DefaultComponentFactory.getInstance().createLabel("Bundesland");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_county, 20, SpringLayout.SOUTH, lbel_country);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_county, 0, SpringLayout.WEST, lbel_status);
		panl_object.add(lbel_county);
		
		text_county = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_county, -5, SpringLayout.NORTH, lbel_county);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_county, 6, SpringLayout.EAST, lbel_county);
		panl_object.add(text_county);
		text_county.setColumns(10);
		
		JLabel lbel_zip = DefaultComponentFactory.getInstance().createLabel("PLZ");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_zip, 250, SpringLayout.EAST, lbel_status);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_zip, 0, SpringLayout.SOUTH, lbel_status);
		panl_object.add(lbel_zip);
		
		text_zip = new JTextField();
		text_zip.setText("0000");
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_zip, -5, SpringLayout.NORTH, lbel_status);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_zip, 6, SpringLayout.EAST, lbel_zip);
		panl_object.add(text_zip);
		text_zip.setColumns(10);
		
		JLabel lbel_city = DefaultComponentFactory.getInstance().createLabel("Ort");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_city, 0, SpringLayout.WEST, lbel_zip);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_city, 0, SpringLayout.SOUTH, lbel_status_date);
		panl_object.add(lbel_city);
		
		text_city = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_city, -5, SpringLayout.NORTH, lbel_status_date);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_city, 6, SpringLayout.EAST, lbel_city);
		panl_object.add(text_city);
		text_city.setColumns(10);
		
		JLabel lbel_street = DefaultComponentFactory.getInstance().createLabel("Straße");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_street, 0, SpringLayout.WEST, lbel_zip);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_street, 0, SpringLayout.SOUTH, lbel_status_from);
		panl_object.add(lbel_street);
		
		text_street = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_street, -5, SpringLayout.NORTH, lbel_status_from);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_street, 6, SpringLayout.EAST, lbel_street);
		panl_object.add(text_street);
		text_street.setColumns(10);
		
		JLabel lbel_number = DefaultComponentFactory.getInstance().createLabel("Hausnummer");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_number, 0, SpringLayout.NORTH, lbel_status_to);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_number, 0, SpringLayout.WEST, lbel_zip);
		panl_object.add(lbel_number);
		
		text_number = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_number, -5, SpringLayout.NORTH, lbel_status_to);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_number, 6, SpringLayout.EAST, lbel_number);
		panl_object.add(text_number);
		text_number.setColumns(10);
		
		JLabel lbel_stair = DefaultComponentFactory.getInstance().createLabel("Stiege");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_stair, 0, SpringLayout.WEST, lbel_zip);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_stair, 0, SpringLayout.SOUTH, lbel_worker);
		panl_object.add(lbel_stair);
		
		text_stairs = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_stairs, -5, SpringLayout.NORTH, lbel_worker);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_stairs, 6, SpringLayout.EAST, lbel_stair);
		panl_object.add(text_stairs);
		text_stairs.setColumns(10);
		
		JLabel lbel_floor = DefaultComponentFactory.getInstance().createLabel("Etage");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_floor, 0, SpringLayout.WEST, lbel_zip);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_floor, 0, SpringLayout.SOUTH, lbel_type);
		panl_object.add(lbel_floor);
		
		text_floor = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_floor, -5, SpringLayout.NORTH, lbel_type);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_floor, 6, SpringLayout.EAST, lbel_floor);
		panl_object.add(text_floor);
		text_floor.setColumns(10);
		
		JLabel lbel_door = DefaultComponentFactory.getInstance().createLabel("Tür");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_door, 0, SpringLayout.NORTH, lbel_subtype);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_door, 0, SpringLayout.WEST, lbel_zip);
		panl_object.add(lbel_door);
		
		text_door = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_door, -5, SpringLayout.NORTH, lbel_subtype);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_door, 6, SpringLayout.EAST, lbel_door);
		panl_object.add(text_door);
		text_door.setColumns(10);
		
		JLabel lbel_closeby = DefaultComponentFactory.getInstance().createLabel("Nähe");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_closeby, 0, SpringLayout.WEST, lbel_zip);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_closeby, 0, SpringLayout.SOUTH, lbel_country);
		panl_object.add(lbel_closeby);
		
		text_closeby = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_closeby, 13, SpringLayout.SOUTH, text_door);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_closeby, 6, SpringLayout.EAST, lbel_closeby);
		sl_panl_object.putConstraint(SpringLayout.EAST, text_closeby, 419, SpringLayout.EAST, lbel_closeby);
		panl_object.add(text_closeby);
		text_closeby.setColumns(10);
		
		JLabel lbel_key = DefaultComponentFactory.getInstance().createLabel("Schlüssel Info");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_key, 0, SpringLayout.WEST, lbel_zip);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_key, 0, SpringLayout.SOUTH, lbel_county);
		panl_object.add(lbel_key);
		
		text_key = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_key, -5, SpringLayout.NORTH, lbel_county);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_key, 6, SpringLayout.EAST, lbel_key);
		panl_object.add(text_key);
		text_key.setColumns(10);
		
		JLabel lbel_handover = DefaultComponentFactory.getInstance().createLabel("Objektabgeber");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_handover, 250, SpringLayout.EAST, lbel_zip);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_handover, 0, SpringLayout.SOUTH, lbel_status);
		panl_object.add(lbel_handover);
		
		text_handover = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_handover, -5, SpringLayout.NORTH, lbel_status);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_handover, 6, SpringLayout.EAST, lbel_handover);
		panl_object.add(text_handover);
		text_handover.setColumns(10);
		
		JLabel lbel_contract_type = DefaultComponentFactory.getInstance().createLabel("Vermittlungsauftrag Typ");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_contract_type, 0, SpringLayout.WEST, lbel_handover);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_contract_type, 0, SpringLayout.SOUTH, lbel_status_date);
		panl_object.add(lbel_contract_type);
		
		text_contract_type = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_contract_type, -5, SpringLayout.NORTH, lbel_status_date);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_contract_type, 6, SpringLayout.EAST, lbel_contract_type);
		panl_object.add(text_contract_type);
		text_contract_type.setColumns(10);
		
		JLabel lbel_agreement = new JLabel("Vereinbarung");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_agreement, 0, SpringLayout.WEST, lbel_handover);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_agreement, 0, SpringLayout.SOUTH, lbel_status_from);
		panl_object.add(lbel_agreement);
		
		text_agreement = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_agreement, -5, SpringLayout.NORTH, lbel_status_from);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_agreement, 6, SpringLayout.EAST, lbel_agreement);
		panl_object.add(text_agreement);
		text_agreement.setColumns(10);
		
		JLabel lbel_agreement_from = DefaultComponentFactory.getInstance().createLabel("Gültig von");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_agreement_from, 0, SpringLayout.WEST, lbel_handover);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_agreement_from, 0, SpringLayout.SOUTH, lbel_status_to);
		panl_object.add(lbel_agreement_from);
		
		text_agreement_from = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_agreement_from, -5, SpringLayout.NORTH, lbel_status_to);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_agreement_from, 6, SpringLayout.EAST, lbel_agreement_from);
		panl_object.add(text_agreement_from);
		text_agreement_from.setColumns(10);
		
		JLabel lbel_agreement_to = DefaultComponentFactory.getInstance().createLabel("Gültig bis");
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_agreement_to, 0, SpringLayout.WEST, lbel_handover);
		sl_panl_object.putConstraint(SpringLayout.SOUTH, lbel_agreement_to, 0, SpringLayout.SOUTH, lbel_worker);
		panl_object.add(lbel_agreement_to);
		
		text_agreement_to = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_agreement_to, -5, SpringLayout.NORTH, lbel_worker);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_agreement_to, 6, SpringLayout.EAST, lbel_agreement_to);
		panl_object.add(text_agreement_to);
		text_agreement_to.setColumns(10);
		
		JLabel lbel_movein = DefaultComponentFactory.getInstance().createLabel("Beziehbar");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_movein, 0, SpringLayout.NORTH, lbel_titel);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_movein, 0, SpringLayout.WEST, lbel_handover);
		panl_object.add(lbel_movein);
		
		text_movein = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_movein, -5, SpringLayout.NORTH, lbel_titel);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_movein, 6, SpringLayout.EAST, lbel_movein);
		panl_object.add(text_movein);
		text_movein.setColumns(10);
		
		JPanel panl_info = new JPanel();
		tbpn_add.addTab("Info", null, panl_info, null);
		SpringLayout sl_panl_info = new SpringLayout();
		panl_info.setLayout(sl_panl_info);
		
		JLabel lbel_bearing = DefaultComponentFactory.getInstance().createLabel("Ausrichtung");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_bearing, 20, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.EAST, lbel_bearing, 80, SpringLayout.WEST, panl_info);
		panl_info.add(lbel_bearing);
		
		text_bearing = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_bearing, -5, SpringLayout.NORTH, lbel_bearing);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_bearing, 6, SpringLayout.EAST, lbel_bearing);
		panl_info.add(text_bearing);
		text_bearing.setColumns(10);
		
		JLabel lbel_size = DefaultComponentFactory.getInstance().createLabel("Grundstücksfläche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_size, 10, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_size, 241, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_size, 20, SpringLayout.SOUTH, lbel_bearing);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_size, 0, SpringLayout.WEST, lbel_bearing);
		panl_info.add(lbel_size);
		
		text_size = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_size, 5, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_size, 364, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_size, -5, SpringLayout.NORTH, lbel_size);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_size, 6, SpringLayout.EAST, lbel_size);
		panl_info.add(text_size);
		text_size.setColumns(10);
		
		JLabel lbel_living_space = DefaultComponentFactory.getInstance().createLabel("Wohnfläche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_living_space, 10, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_living_space, 499, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_living_space, 20, SpringLayout.SOUTH, lbel_size);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_living_space, 0, SpringLayout.WEST, lbel_size);
		panl_info.add(lbel_living_space);
		
		text_living_space = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_living_space, 5, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_living_space, 577, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_living_space, -5, SpringLayout.NORTH, lbel_living_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_living_space, 6, SpringLayout.EAST, lbel_living_space);
		panl_info.add(text_living_space);
		text_living_space.setColumns(10);
		
		JLabel lbel_split_from = DefaultComponentFactory.getInstance().createLabel("Teilbar ab");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_split_from, 10, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_split_from, 712, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_split_from, 20, SpringLayout.SOUTH, lbel_living_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_split_from, 0, SpringLayout.WEST, lbel_living_space);
		panl_info.add(lbel_split_from);
		
		text_split_from = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_split_from, 5, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_split_from, 779, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_split_from, -5, SpringLayout.NORTH, lbel_split_from);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_split_from, 6, SpringLayout.EAST, lbel_split_from);
		panl_info.add(text_split_from);
		text_split_from.setColumns(10);
		
		JLabel lbel_useable_space = DefaultComponentFactory.getInstance().createLabel("Nutzfäche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_useable_space, 41, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_useable_space, 24, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_useable_space, 20, SpringLayout.SOUTH, lbel_split_from);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_useable_space, 0, SpringLayout.WEST, lbel_split_from);
		panl_info.add(lbel_useable_space);
		
		text_useable_space = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_useable_space, 36, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_useable_space, 93, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_useable_space, -5, SpringLayout.NORTH, lbel_useable_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_useable_space, 6, SpringLayout.EAST, lbel_useable_space);
		panl_info.add(text_useable_space);
		text_useable_space.setColumns(10);
		
		JLabel lbel_garden = DefaultComponentFactory.getInstance().createLabel("Gartenfläche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_garden, 41, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_garden, 228, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_garden, 20, SpringLayout.SOUTH, lbel_useable_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_garden, 0, SpringLayout.WEST, lbel_useable_space);
		panl_info.add(lbel_garden);
		
		text_garden = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_garden, 36, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_garden, 312, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.EAST, text_garden, 158, SpringLayout.EAST, text_status_from);
		
		JButton butn_save = new JButton("Speichern");
		sl_panl_object.putConstraint(SpringLayout.SOUTH, butn_save, -10, SpringLayout.SOUTH, panl_object);
		sl_panl_object.putConstraint(SpringLayout.EAST, butn_save, -10, SpringLayout.EAST, panl_object);
		butn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		butn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/reimmo?autoReconnect=true&useSSL=false";
				String userid = "root";
				String password = "Sandwurm357";
				ArrayList<Integer> intArray = new ArrayList<Integer>(0);
				
				
				String sql = "SELECT Objektnummer FROM objekte";
				try (Connection conn = DriverManager.getConnection(url, userid, password);
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(sql)) 
					{
						while (rs.next()){
							intArray.add(rs.getInt(1));
						}
					} catch (Exception ex) {
						System.err.println(ex.getMessage());
					}
				
				for (Integer number : intArray) {
					if (number.toString().equals(text_objectnumber.getText())) {
						System.out.println("This number already exists");
						return;
					}
				}
				
				try {
						Connection conn = DriverManager.getConnection(url, userid, password);
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("INSERT INTO objekte "
						+ "VALUES ('"+ text_objectnumber.getText() +"', '"+ text_status.getText() +"', '"+ text_status_date.getText() +"', '"+ text_status_from.getText() +"', '"+ text_status_to.getText()
						+ "', '"+ text_worker.getText() +"', '"+ text_titel.getText() +"', '"+ text_type.getText() +"', '"+ text_subtype.getText() +"', '"+ text_country.getText()
						+ "', '"+ text_county.getText() +"', '"+ text_zip.getText() +"', '"+ text_city.getText() +"', '"+ text_street.getText() +"', '"+ text_number.getText()
						+ "', '"+ text_stairs.getText() +"', '"+ text_floor.getText() +"', '"+ text_door.getText() +"', '"+ text_closeby.getText() +"', '"+ text_key.getText()
						+ "', '"+ text_handover.getText() +"', '"+ text_contract_type.getText() +"', '"+ text_agreement.getText() +"', '"+ text_agreement_from.getText()
						+ "', '"+ text_agreement_to.getText() +"', '"+ text_movein.getText() +"')");
						
						stmt.executeUpdate("INSERT INTO objektinfo (objektnummer, Ausrichtung, Grundstücksfläche, Wohnfläche, Teilbar_ab, Nutzfläche, Gartenfläche, Kellerfläche, Verbaubare_Fläche, Gesamtfläche, Zimmer,"
								+ " Anzahl_Balkons, Balkonfläche, Anzahl_Terrassen, Terrassenfläche, Anzahl_Loggias, Loggiafläche, Anzahl_WC, Raumhöhe, Anzahl_Bäder, Anzahl_Garagen, Anzahl_Abstellräume, Erstellungsdatum,"
								+ " Energieausweis_HWB, Energieausweis_HWB_Klasse, Energieausweis_fGEE, Energieausweis_fGEE_Klasse, Energieausweis_Gültig_bis) "
						+ "VALUES ('" + text_objectnumber.getText() + "', '"+ text_bearing.getText() +"', '"+ text_size.getText() +"', '"+ text_living_space.getText() +"', '"+ text_split_from.getText() +"', '"+ text_useable_space.getText()
						+ "', '"+ text_garden.getText() +"', '"+ text_cellar.getText() +"', '"+ text_building_space.getText() +"', '"+ text_total_space.getText() +"', '"+ text_rooms.getText()
						+ "', '"+ text_balconies.getText() +"', '"+ text_balcony_space.getText() +"', '"+ text_terrace.getText() +"', '"+ text_terrace_space.getText() +"', '"+ text_loggias.getText() +"', '"+ text_loggias_space.getText() +"', '"+ text_height.getText()
						+ "', '"+ text_toilets.getText() +"', '"+ text_baths.getText() +"', '"+ text_garages.getText() +"', '"+ text_storingrooms.getText() +"', '"+ text_created_date.getText()
						+ "', '"+ text_energy_hwb.getText() +"', '"+ text_energy_hwb_class.getText() +"', '"+ text_energy_fgee.getText() +"', '"+ text_energy_fgee_class.getText()
						+ "', '"+ text_energy_valid.getText() +"')");
						
						stmt.executeUpdate("INSERT INTO preise (objektnummer, Kaufpreis, Gesamtmiete, Miete, Möbelmiete, Parkplatz, Garage, Betriebskosten, Heizkosten,"
								+ " Warmwasser, Kühlung, Reparaturrücklage, Sonstiges, Liftkosten, Mietepreis_m2_ab, Mietepreis_m2, Provision) "
						+ "VALUES ('"+ text_objectnumber.getText() +"', '"+ text_buying_price.getText() +"', '"+ text_total_rent.getText() +"', '"+ text_rent_gross.getText() +"', '"+ text_furniture_rent_gross.getText()
						+ "', '"+ text_parkingspace_gross.getText() +"', '"+ text_garage_gross.getText() +"', '"+ text_operation_cost_gross.getText() +"', '"+ text_heating_cost_gross.getText() +"', '"+ text_warm_water_gross.getText()
						+ "', '"+ text_cooling_gross.getText() +"', '"+ text_repair_layback_gross.getText() +"', '"+ text_other_gross.getText() +"', '"+ text_elevator_gross.getText() +"', '"+ text_rent_msquared_from.getText()
						+ "', '"+ text_rent_msquared.getText() +"', '"+ text_provision.getText() +"')");
						conn.close();
						closeFrame();
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		});
		panl_object.add(butn_save);
		
		JLabel lbel_objectnumber = DefaultComponentFactory.getInstance().createLabel("Objektnummer");
		sl_panl_object.putConstraint(SpringLayout.NORTH, lbel_objectnumber, 0, SpringLayout.NORTH, lbel_county);
		sl_panl_object.putConstraint(SpringLayout.WEST, lbel_objectnumber, 86, SpringLayout.EAST, text_key);
		panl_object.add(lbel_objectnumber);
		
		text_objectnumber = new JTextField();
		sl_panl_object.putConstraint(SpringLayout.NORTH, text_objectnumber, -5, SpringLayout.NORTH, lbel_county);
		sl_panl_object.putConstraint(SpringLayout.WEST, text_objectnumber, 6, SpringLayout.EAST, lbel_objectnumber);
		panl_object.add(text_objectnumber);
		text_objectnumber.setColumns(10);
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_garden, -5, SpringLayout.NORTH, lbel_garden);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_garden, 6, SpringLayout.EAST, lbel_garden);
		panl_info.add(text_garden);
		text_garden.setColumns(10);
		
		JLabel lbel_cellar = DefaultComponentFactory.getInstance().createLabel("Kellerfläche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_cellar, 41, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_cellar, 447, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_cellar, 20, SpringLayout.SOUTH, lbel_garden);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_cellar, 0, SpringLayout.WEST, lbel_garden);
		panl_info.add(lbel_cellar);
		
		text_cellar = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_cellar, 36, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_cellar, 525, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_cellar, -5, SpringLayout.NORTH, lbel_cellar);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_cellar, 6, SpringLayout.EAST, lbel_cellar);
		panl_info.add(text_cellar);
		text_cellar.setColumns(10);
		
		JLabel lbel_building_space = DefaultComponentFactory.getInstance().createLabel("Verbaubare Fläche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_building_space, 41, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_building_space, 660, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_building_space, 20, SpringLayout.SOUTH, lbel_cellar);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_building_space, 0, SpringLayout.WEST, lbel_cellar);
		panl_info.add(lbel_building_space);
		
		text_building_space = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_building_space, 36, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_building_space, 779, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_building_space, -5, SpringLayout.NORTH, lbel_building_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_building_space, 6, SpringLayout.EAST, lbel_building_space);
		panl_info.add(text_building_space);
		text_building_space.setColumns(10);
		
		JLabel lbel_total_space = DefaultComponentFactory.getInstance().createLabel("Gesamtfläche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_total_space, 72, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_total_space, 36, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_total_space, 20, SpringLayout.SOUTH, lbel_building_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_total_space, 0, SpringLayout.WEST, lbel_building_space);
		panl_info.add(lbel_total_space);
		
		text_total_space = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_total_space, 67, SpringLayout.NORTH, panl_info);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_total_space, 126, SpringLayout.WEST, panl_info);
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_total_space, -4, SpringLayout.NORTH, lbel_total_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_total_space, 6, SpringLayout.EAST, lbel_total_space);
		panl_info.add(text_total_space);
		
		JLabel lbel_rooms = DefaultComponentFactory.getInstance().createLabel("Zimmer");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_rooms, 20, SpringLayout.SOUTH, lbel_total_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_rooms, 0, SpringLayout.WEST, lbel_total_space);
		panl_info.add(lbel_rooms);
		
		text_rooms = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.EAST, text_total_space, 25, SpringLayout.EAST, text_rooms);
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_rooms, -5, SpringLayout.NORTH, lbel_rooms);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_rooms, 6, SpringLayout.EAST, lbel_rooms);
		panl_info.add(text_rooms);
		text_rooms.setColumns(10);
		
		JLabel lbel_balconies = DefaultComponentFactory.getInstance().createLabel("Anzahl Balkonen");
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_balconies, 250, SpringLayout.EAST, lbel_bearing);
		sl_panl_info.putConstraint(SpringLayout.SOUTH, lbel_balconies, 0, SpringLayout.SOUTH, lbel_bearing);
		panl_info.add(lbel_balconies);
		
		text_balconies = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_balconies, -5, SpringLayout.NORTH, lbel_balconies);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_balconies, 6, SpringLayout.EAST, lbel_balconies);
		panl_info.add(text_balconies);
		text_balconies.setColumns(10);
		
		JLabel lbel_balcony_space = DefaultComponentFactory.getInstance().createLabel("Balkonfläche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_balcony_space, 20, SpringLayout.SOUTH, lbel_balconies);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_balcony_space, 0, SpringLayout.WEST, lbel_balconies);
		panl_info.add(lbel_balcony_space);
		
		text_balcony_space = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_balcony_space, -5, SpringLayout.NORTH, lbel_balcony_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_balcony_space, 6, SpringLayout.EAST, lbel_balcony_space);
		panl_info.add(text_balcony_space);
		text_balcony_space.setColumns(10);
		
		JLabel lbel_terrace = DefaultComponentFactory.getInstance().createLabel("Anzahl Terrassen");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_terrace, 20, SpringLayout.SOUTH, lbel_balcony_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_terrace, 0, SpringLayout.WEST, lbel_balcony_space);
		panl_info.add(lbel_terrace);
		
		text_terrace = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_terrace, -5, SpringLayout.NORTH, lbel_terrace);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_terrace, 6, SpringLayout.EAST, lbel_terrace);
		panl_info.add(text_terrace);
		text_terrace.setColumns(10);
		
		JLabel lbel_terrace_space = DefaultComponentFactory.getInstance().createLabel("Terrassenfläche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_terrace_space, 20, SpringLayout.SOUTH, lbel_terrace);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_terrace_space, 0, SpringLayout.WEST, lbel_terrace);
		panl_info.add(lbel_terrace_space);
		
		text_terrace_space = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_terrace_space, -5, SpringLayout.NORTH, lbel_terrace_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_terrace_space, 6, SpringLayout.EAST, lbel_terrace_space);
		panl_info.add(text_terrace_space);
		text_terrace_space.setColumns(10);
		
		JLabel lbel_loggias = DefaultComponentFactory.getInstance().createLabel("Loggias");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_loggias, 20, SpringLayout.SOUTH, lbel_terrace_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_loggias, 0, SpringLayout.WEST, lbel_terrace_space);
		panl_info.add(lbel_loggias);
		
		text_loggias = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_loggias, -5, SpringLayout.NORTH, lbel_loggias);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_loggias, 6, SpringLayout.EAST, lbel_loggias);
		panl_info.add(text_loggias);
		text_loggias.setColumns(10);
		
		JLabel lbel_loggias_space = DefaultComponentFactory.getInstance().createLabel("Loggiasfläche");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_loggias_space, 20, SpringLayout.SOUTH, lbel_loggias);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_loggias_space, 0, SpringLayout.WEST, lbel_loggias);
		panl_info.add(lbel_loggias_space);
		
		text_loggias_space = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_loggias_space, -5, SpringLayout.NORTH, lbel_loggias_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_loggias_space, 6, SpringLayout.EAST, lbel_loggias_space);
		panl_info.add(text_loggias_space);
		text_loggias_space.setColumns(10);
		
		JLabel lbel_height = DefaultComponentFactory.getInstance().createLabel("Raumhöhe");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_height, 20, SpringLayout.SOUTH, lbel_loggias_space);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_height, 0, SpringLayout.WEST, lbel_loggias_space);
		panl_info.add(lbel_height);
		
		text_height = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_height, -5, SpringLayout.NORTH, lbel_height);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_height, 6, SpringLayout.EAST, lbel_height);
		panl_info.add(text_height);
		text_height.setColumns(10);
		
		JLabel lbel_toilets = DefaultComponentFactory.getInstance().createLabel("Anzahl WC");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_toilets, 20, SpringLayout.SOUTH, lbel_height);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_toilets, 0, SpringLayout.WEST, lbel_height);
		panl_info.add(lbel_toilets);
		
		text_toilets = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_toilets, -5, SpringLayout.NORTH, lbel_toilets);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_toilets, 6, SpringLayout.EAST, lbel_toilets);
		panl_info.add(text_toilets);
		text_toilets.setColumns(10);
		
		JLabel lbel_baths = DefaultComponentFactory.getInstance().createLabel("Anzahl Bäder");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_baths, 20, SpringLayout.SOUTH, lbel_toilets);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_baths, 0, SpringLayout.WEST, lbel_toilets);
		panl_info.add(lbel_baths);
		
		text_baths = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_baths, -5, SpringLayout.NORTH, lbel_baths);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_baths, 6, SpringLayout.EAST, lbel_baths);
		panl_info.add(text_baths);
		text_baths.setColumns(10);
		
		JLabel lbel_garages = DefaultComponentFactory.getInstance().createLabel("Anzahl Garage");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_garages, 20, SpringLayout.SOUTH, lbel_baths);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_garages, 0, SpringLayout.WEST, lbel_baths);
		panl_info.add(lbel_garages);
		
		text_garages = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_garages, -5, SpringLayout.NORTH, lbel_garages);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_garages, 6, SpringLayout.EAST, lbel_garages);
		panl_info.add(text_garages);
		text_garages.setColumns(10);
		
		JLabel lbel_storingrooms = DefaultComponentFactory.getInstance().createLabel("Anzahl Abstellräume");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_storingrooms, 20, SpringLayout.SOUTH, lbel_garages);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_storingrooms, 0, SpringLayout.WEST, lbel_garages);
		panl_info.add(lbel_storingrooms);
		
		text_storingrooms = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_storingrooms, -5, SpringLayout.NORTH, lbel_storingrooms);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_storingrooms, 6, SpringLayout.EAST, lbel_storingrooms);
		panl_info.add(text_storingrooms);
		text_storingrooms.setColumns(10);
		
		JLabel lbel_created_date = DefaultComponentFactory.getInstance().createLabel("Erstellungsdatum");
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_created_date, 200, SpringLayout.EAST, lbel_balconies);
		sl_panl_info.putConstraint(SpringLayout.SOUTH, lbel_created_date, 0, SpringLayout.SOUTH, lbel_bearing);
		panl_info.add(lbel_created_date);
		
		text_created_date = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_created_date, -5, SpringLayout.NORTH, lbel_created_date);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_created_date, 6, SpringLayout.EAST, lbel_created_date);
		panl_info.add(text_created_date);
		text_created_date.setColumns(10);
		
		JLabel lbel_energy_hwb = DefaultComponentFactory.getInstance().createLabel("Energieausweis HWB");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_energy_hwb, 20, SpringLayout.SOUTH, lbel_created_date);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_energy_hwb, 0, SpringLayout.WEST, lbel_created_date);
		panl_info.add(lbel_energy_hwb);
		
		text_energy_hwb = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_energy_hwb, -5, SpringLayout.NORTH, lbel_energy_hwb);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_energy_hwb, 6, SpringLayout.EAST, lbel_energy_hwb);
		panl_info.add(text_energy_hwb);
		text_energy_hwb.setColumns(10);
		
		JLabel lbel_energy_hwb_class = DefaultComponentFactory.getInstance().createLabel("Energieausweis HWB Klasse");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_energy_hwb_class, 20, SpringLayout.SOUTH, lbel_energy_hwb);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_energy_hwb_class, 0, SpringLayout.WEST, lbel_energy_hwb);
		panl_info.add(lbel_energy_hwb_class);
		
		text_energy_hwb_class = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_energy_hwb_class, -5, SpringLayout.NORTH, lbel_energy_hwb_class);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_energy_hwb_class, 6, SpringLayout.EAST, lbel_energy_hwb_class);
		panl_info.add(text_energy_hwb_class);
		text_energy_hwb_class.setColumns(10);
		
		JLabel lbel_energy_fgee = new JLabel("Energieausweis fGEE");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_energy_fgee, 20, SpringLayout.SOUTH, lbel_energy_hwb_class);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_energy_fgee, 0, SpringLayout.WEST, lbel_energy_hwb_class);
		panl_info.add(lbel_energy_fgee);
		
		text_energy_fgee = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_energy_fgee, -5, SpringLayout.NORTH, lbel_energy_fgee);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_energy_fgee, 6, SpringLayout.EAST, lbel_energy_fgee);
		panl_info.add(text_energy_fgee);
		text_energy_fgee.setColumns(10);
		
		JLabel lbel_energy_fgee_class = DefaultComponentFactory.getInstance().createLabel("Energieausweis fGEE Klasse");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_energy_fgee_class, 20, SpringLayout.SOUTH, lbel_energy_fgee);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_energy_fgee_class, 0, SpringLayout.WEST, lbel_energy_fgee);
		panl_info.add(lbel_energy_fgee_class);
		
		text_energy_fgee_class = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_energy_fgee_class, -5, SpringLayout.NORTH, lbel_energy_fgee_class);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_energy_fgee_class, 6, SpringLayout.EAST, lbel_energy_fgee_class);
		panl_info.add(text_energy_fgee_class);
		text_energy_fgee_class.setColumns(10);
		
		JLabel lbel_energy_valid = DefaultComponentFactory.getInstance().createLabel("Energieausweis Gültig bis");
		sl_panl_info.putConstraint(SpringLayout.NORTH, lbel_energy_valid, 20, SpringLayout.SOUTH, lbel_energy_fgee_class);
		sl_panl_info.putConstraint(SpringLayout.WEST, lbel_energy_valid, 0, SpringLayout.WEST, lbel_energy_fgee_class);
		panl_info.add(lbel_energy_valid);
		
		text_energy_valid = new JTextField();
		sl_panl_info.putConstraint(SpringLayout.NORTH, text_energy_valid, -5, SpringLayout.NORTH, lbel_energy_valid);
		sl_panl_info.putConstraint(SpringLayout.WEST, text_energy_valid, 6, SpringLayout.EAST, lbel_energy_valid);
		panl_info.add(text_energy_valid);
		text_energy_valid.setColumns(10);
		
		JPanel panl_price = new JPanel();
		tbpn_add.addTab("Preise", null, panl_price, null);
		SpringLayout sl_panl_price = new SpringLayout();
		panl_price.setLayout(sl_panl_price);
		
		
		JLabel lbel_buying_price = DefaultComponentFactory.getInstance().createLabel("Kaufpreis");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_buying_price, 20, SpringLayout.NORTH, panl_price);
		sl_panl_price.putConstraint(SpringLayout.EAST, lbel_buying_price, 80, SpringLayout.WEST, panl_price);
		panl_price.add(lbel_buying_price);
		
		text_buying_price = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_buying_price, -5, SpringLayout.NORTH, lbel_buying_price);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_buying_price, 6, SpringLayout.EAST, lbel_buying_price);
		panl_price.add(text_buying_price);
		text_buying_price.setColumns(10);
		
		JLabel lbel_total_rent = DefaultComponentFactory.getInstance().createLabel("Gesamtmiete");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_total_rent, 20, SpringLayout.SOUTH, lbel_buying_price);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_total_rent, 0, SpringLayout.WEST, lbel_buying_price);
		panl_price.add(lbel_total_rent);
		
		text_total_rent = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_total_rent, -5, SpringLayout.NORTH, lbel_total_rent);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_total_rent, 6, SpringLayout.EAST, lbel_total_rent);
		panl_price.add(text_total_rent);
		text_total_rent.setColumns(10);
		
		JLabel lbel_rent_gross = DefaultComponentFactory.getInstance().createLabel("Miete (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_rent_gross, 20, SpringLayout.SOUTH, lbel_total_rent);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_rent_gross, 0, SpringLayout.WEST, lbel_total_rent);
		panl_price.add(lbel_rent_gross);
		
		text_rent_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_rent_gross, -5, SpringLayout.NORTH, lbel_rent_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_rent_gross, 6, SpringLayout.EAST, lbel_rent_gross);
		panl_price.add(text_rent_gross);
		text_rent_gross.setColumns(10);
		
		JLabel lbel_furniture_rent_gross = DefaultComponentFactory.getInstance().createLabel("Möbelmiete (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_furniture_rent_gross, 20, SpringLayout.SOUTH, lbel_rent_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_furniture_rent_gross, 0, SpringLayout.WEST, lbel_rent_gross);
		panl_price.add(lbel_furniture_rent_gross);
		
		text_furniture_rent_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_furniture_rent_gross, -5, SpringLayout.NORTH, lbel_furniture_rent_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_furniture_rent_gross, 6, SpringLayout.EAST, lbel_furniture_rent_gross);
		panl_price.add(text_furniture_rent_gross);
		text_furniture_rent_gross.setColumns(10);
		
		JLabel lbel_parkingspace_gross = DefaultComponentFactory.getInstance().createLabel("Parkplatz (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_parkingspace_gross, 20, SpringLayout.SOUTH, lbel_furniture_rent_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_parkingspace_gross, 0, SpringLayout.WEST, lbel_furniture_rent_gross);
		panl_price.add(lbel_parkingspace_gross);
		
		text_parkingspace_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_parkingspace_gross, -5, SpringLayout.NORTH, lbel_parkingspace_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_parkingspace_gross, 6, SpringLayout.EAST, lbel_parkingspace_gross);
		panl_price.add(text_parkingspace_gross);
		text_parkingspace_gross.setColumns(10);
		
		JLabel lbel_garage_gross = DefaultComponentFactory.getInstance().createLabel("Garage (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_garage_gross, 20, SpringLayout.SOUTH, lbel_parkingspace_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_garage_gross, 0, SpringLayout.WEST, lbel_parkingspace_gross);
		panl_price.add(lbel_garage_gross);
		
		text_garage_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_garage_gross, -5, SpringLayout.NORTH, lbel_garage_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_garage_gross, 6, SpringLayout.EAST, lbel_garage_gross);
		panl_price.add(text_garage_gross);
		text_garage_gross.setColumns(10);
		
		JLabel lbel_operation_cost_gross = DefaultComponentFactory.getInstance().createLabel("Betriebskosten (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_operation_cost_gross, 20, SpringLayout.SOUTH, lbel_garage_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_operation_cost_gross, 0, SpringLayout.WEST, lbel_garage_gross);
		panl_price.add(lbel_operation_cost_gross);
		
		text_operation_cost_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_operation_cost_gross, -5, SpringLayout.NORTH, lbel_operation_cost_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_operation_cost_gross, 6, SpringLayout.EAST, lbel_operation_cost_gross);
		panl_price.add(text_operation_cost_gross);
		text_operation_cost_gross.setColumns(10);
		
		JLabel lbel_heating_cost_gross = DefaultComponentFactory.getInstance().createLabel("Heizkosten (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_heating_cost_gross, 20, SpringLayout.SOUTH, lbel_operation_cost_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_heating_cost_gross, 0, SpringLayout.WEST, lbel_operation_cost_gross);
		panl_price.add(lbel_heating_cost_gross);
		
		text_heating_cost_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_heating_cost_gross, -5, SpringLayout.NORTH, lbel_heating_cost_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_heating_cost_gross, 6, SpringLayout.EAST, lbel_heating_cost_gross);
		panl_price.add(text_heating_cost_gross);
		text_heating_cost_gross.setColumns(10);
		
		JLabel lbel_warm_water_gross = DefaultComponentFactory.getInstance().createLabel("Warmwasser (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_warm_water_gross, 20, SpringLayout.SOUTH, lbel_heating_cost_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_warm_water_gross, 0, SpringLayout.WEST, lbel_heating_cost_gross);
		panl_price.add(lbel_warm_water_gross);
		
		text_warm_water_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_warm_water_gross, -5, SpringLayout.NORTH, lbel_warm_water_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_warm_water_gross, 6, SpringLayout.EAST, lbel_warm_water_gross);
		panl_price.add(text_warm_water_gross);
		text_warm_water_gross.setColumns(10);
		
		JLabel lbel_cooling_gross = DefaultComponentFactory.getInstance().createLabel("Kühlung (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_cooling_gross, 20, SpringLayout.SOUTH, lbel_warm_water_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_cooling_gross, 0, SpringLayout.WEST, lbel_warm_water_gross);
		panl_price.add(lbel_cooling_gross);
		
		text_cooling_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_cooling_gross, -5, SpringLayout.NORTH, lbel_cooling_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_cooling_gross, 6, SpringLayout.EAST, lbel_cooling_gross);
		panl_price.add(text_cooling_gross);
		text_cooling_gross.setColumns(10);
		
		JLabel lbel_repair_layback_gross = DefaultComponentFactory.getInstance().createLabel("Reparaturrücklage (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_repair_layback_gross, 250, SpringLayout.EAST, lbel_buying_price);
		sl_panl_price.putConstraint(SpringLayout.SOUTH, lbel_repair_layback_gross, 0, SpringLayout.SOUTH, lbel_buying_price);
		panl_price.add(lbel_repair_layback_gross);
		
		text_repair_layback_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_repair_layback_gross, -5, SpringLayout.NORTH, lbel_repair_layback_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_repair_layback_gross, 6, SpringLayout.EAST, lbel_repair_layback_gross);
		panl_price.add(text_repair_layback_gross);
		text_repair_layback_gross.setColumns(10);
		
		JLabel lbel_other_gross = DefaultComponentFactory.getInstance().createLabel("Kühlung (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_other_gross, 20, SpringLayout.SOUTH, lbel_repair_layback_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_other_gross, 0, SpringLayout.WEST, lbel_repair_layback_gross);
		panl_price.add(lbel_other_gross);
		
		text_other_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_other_gross, -5, SpringLayout.NORTH, lbel_other_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_other_gross, 6, SpringLayout.EAST, lbel_other_gross);
		panl_price.add(text_other_gross);
		text_other_gross.setColumns(10);
		
		JLabel lbel_elevator_gross = DefaultComponentFactory.getInstance().createLabel("Kühlung (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_elevator_gross, 20, SpringLayout.SOUTH, lbel_other_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_elevator_gross, 0, SpringLayout.WEST, lbel_other_gross);
		panl_price.add(lbel_elevator_gross);
		
		text_elevator_gross = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_elevator_gross, -5, SpringLayout.NORTH, lbel_elevator_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_elevator_gross, 6, SpringLayout.EAST, lbel_elevator_gross);
		panl_price.add(text_elevator_gross);
		text_elevator_gross.setColumns(10);
		
		JLabel lbel_rent_msquared_from = DefaultComponentFactory.getInstance().createLabel("Kühlung (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_rent_msquared_from, 20, SpringLayout.SOUTH, lbel_elevator_gross);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_rent_msquared_from, 0, SpringLayout.WEST, lbel_elevator_gross);
		panl_price.add(lbel_rent_msquared_from);
		
		text_rent_msquared_from = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_rent_msquared_from, -5, SpringLayout.NORTH, lbel_rent_msquared_from);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_rent_msquared_from, 6, SpringLayout.EAST, lbel_rent_msquared_from);
		panl_price.add(text_rent_msquared_from);
		text_rent_msquared_from.setColumns(10);
		
		JLabel lbel_rent_msquared = DefaultComponentFactory.getInstance().createLabel("Kühlung (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_rent_msquared, 20, SpringLayout.SOUTH, lbel_rent_msquared_from);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_rent_msquared, 0, SpringLayout.WEST, lbel_rent_msquared_from);
		panl_price.add(lbel_rent_msquared);
		
		text_rent_msquared = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_rent_msquared, -5, SpringLayout.NORTH, lbel_rent_msquared);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_rent_msquared, 6, SpringLayout.EAST, lbel_rent_msquared);
		panl_price.add(text_rent_msquared);
		text_rent_msquared.setColumns(10);
		
		JLabel lbel_provision = DefaultComponentFactory.getInstance().createLabel("Kühlung (Brutto)");
		sl_panl_price.putConstraint(SpringLayout.NORTH, lbel_provision, 20, SpringLayout.SOUTH, lbel_rent_msquared);
		sl_panl_price.putConstraint(SpringLayout.WEST, lbel_provision, 0, SpringLayout.WEST, lbel_rent_msquared);
		panl_price.add(lbel_provision);
		
		text_provision = new JTextField();
		sl_panl_price.putConstraint(SpringLayout.NORTH, text_provision, -5, SpringLayout.NORTH, lbel_provision);
		sl_panl_price.putConstraint(SpringLayout.WEST, text_provision, 6, SpringLayout.EAST, lbel_provision);
		panl_price.add(text_provision);
		text_provision.setColumns(10);
		
		JPanel panl_ads = new JPanel();
		tbpn_add.addTab("Ads", null, panl_ads, null);
	}
	
	private void closeFrame() {
		this.dispose();
	}
}
