package MenuPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import iodata.IoData;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Finca extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxSucursal;
	private JComboBox comboBoxTipoProducto;
	private JTextField textCodigo;
	private JLabel lblCodigo;
	private JTextField textCosteVenta;
	private JTextField textMargenVenta;
	private JTextField textCosteAlquiler;
	private JTextField textMargenAlquiler;
	private JTextField textCP;
	private JTextField textPoblacion;
	private JTextField textProvincia;
	private JTextField textPoligono;
	private JComboBox comboBoxPropietario;
	private JTextField textParcela;
	private JTextField textM2;
	private JLabel lblCosteVenta;
	private JLabel lblMargenDeVenta;
	private JLabel lblCosteDeVenta;
	private JLabel lblMargenDeAlquiler;
	private JLabel lblCp;
	private JLabel lblPoblacion;
	private JLabel lblProvincia;
	private JLabel lblPoligono;
	private JLabel lblParcela;
	private JLabel lblM;
	private JComboBox comboBoxTipoFinca;
	private JLabel lblNewLabel;
	private JButton btnAnadir;
	private JButton btnVolver;
	private DefaultComboBoxModel modelo1;
	private DefaultComboBoxModel modelo2;
	private DefaultComboBoxModel modelo3;
	private DefaultComboBoxModel modelo4;
	private ArrayList<String> sucursal;
	private ArrayList<String> propietario;
	private JCalendar calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finca frame = new Finca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Finca() {
		sucursal= IoData.obtenerSucursal();
		propietario = IoData.obtenerPropietario();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxSucursal = new JComboBox();
		comboBoxSucursal.addActionListener(new ComboBoxSucursalActionListener());
		comboBoxSucursal.setBounds(76, 80, 160, 21);
		contentPane.add(comboBoxSucursal);
		modelo1 = new DefaultComboBoxModel();
		modelo1.addElement("Seleccione la sucursal");
		rellenarModelo();
		comboBoxSucursal.setModel(modelo1);
		
		comboBoxTipoProducto = new JComboBox();
		comboBoxTipoProducto.addActionListener(new ComboBoxTipoProductoActionListener());
		comboBoxTipoProducto.setBounds(259, 80, 170, 21);
		contentPane.add(comboBoxTipoProducto);
		DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
		modelo2.addElement("Escoger tipo de producto");
		modelo2.addElement("Venta");
		modelo2.addElement("Alquiler");
		modelo2.addElement("Ambos");
		comboBoxTipoProducto.setModel(modelo2);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(459, 81, 132, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(459, 58, 46, 13);
		contentPane.add(lblCodigo);
		
		textCosteVenta = new JTextField();
		textCosteVenta.addActionListener(new TextCosteVentaActionListener());
		textCosteVenta.setColumns(10);
		textCosteVenta.setBounds(76, 134, 132, 19);
		contentPane.add(textCosteVenta);
		textCosteVenta.setEnabled(false);
		
		textMargenVenta = new JTextField();
		textMargenVenta.addActionListener(new TextMargenVentaActionListener());
		textMargenVenta.setColumns(10);
		textMargenVenta.setBounds(259, 134, 132, 19);
		contentPane.add(textMargenVenta);
		textMargenVenta.setEnabled(false);
		
		textCosteAlquiler = new JTextField();
		textCosteAlquiler.addActionListener(new TextCosteAlquilerActionListener());
		textCosteAlquiler.setColumns(10);
		textCosteAlquiler.setBounds(76, 185, 132, 19);
		contentPane.add(textCosteAlquiler);
		textCosteAlquiler.setEnabled(false);
		
		textMargenAlquiler = new JTextField();
		textMargenAlquiler.addActionListener(new TextMargenAlquilerActionListener());
		textMargenAlquiler.setColumns(10);
		textMargenAlquiler.setBounds(259, 185, 132, 19);
		contentPane.add(textMargenAlquiler);
		textMargenAlquiler.setEnabled(false);
		
		textCP = new JTextField();
		textCP.addActionListener(new TextCPActionListener());
		textCP.setColumns(10);
		textCP.setBounds(76, 234, 132, 19);
		contentPane.add(textCP);
		
		textPoblacion = new JTextField();
		textPoblacion.addActionListener(new TextPoblacionActionListener());
		textPoblacion.setColumns(10);
		textPoblacion.setBounds(259, 234, 132, 19);
		contentPane.add(textPoblacion);
		
		textProvincia = new JTextField();
		textProvincia.addActionListener(new TextProvinciaActionListener());
		textProvincia.setColumns(10);
		textProvincia.setBounds(459, 234, 132, 19);
		contentPane.add(textProvincia);
		
		textPoligono = new JTextField();
		textPoligono.addActionListener(new TextPoligonoActionListener());
		textPoligono.setColumns(10);
		textPoligono.setBounds(76, 286, 132, 19);
		contentPane.add(textPoligono);
		
		comboBoxPropietario = new JComboBox();
		comboBoxPropietario.addActionListener(new ComboBoxPropietarioActionListener());
		comboBoxPropietario.setBounds(457, 184, 162, 21);
		contentPane.add(comboBoxPropietario);
		modelo3 = new DefaultComboBoxModel();
		modelo3.addElement("Seleccione el propietario");
		rellenarModelo2();
		comboBoxPropietario.setModel(modelo3);
		
		textParcela = new JTextField();
		textParcela.addActionListener(new TextParcelaActionListener());
		textParcela.setColumns(10);
		textParcela.setBounds(259, 286, 132, 19);
		contentPane.add(textParcela);
		
		textM2 = new JTextField();
		textM2.addActionListener(new TextM2ActionListener());
		textM2.setColumns(10);
		textM2.setBounds(459, 286, 132, 19);
		contentPane.add(textM2);
		
		lblCosteVenta = new JLabel("Coste venta");
		lblCosteVenta.setBounds(76, 111, 80, 13);
		contentPane.add(lblCosteVenta);
		
		lblMargenDeVenta = new JLabel("Margen de venta");
		lblMargenDeVenta.setBounds(259, 111, 120, 13);
		contentPane.add(lblMargenDeVenta);
		
		lblCosteDeVenta = new JLabel("Coste de alquiler");
		lblCosteDeVenta.setBounds(76, 163, 80, 13);
		contentPane.add(lblCosteDeVenta);
		
		lblMargenDeAlquiler = new JLabel("Margen de alquiler");
		lblMargenDeAlquiler.setBounds(259, 163, 120, 13);
		contentPane.add(lblMargenDeAlquiler);
		
		lblCp = new JLabel("CP");
		lblCp.setBounds(76, 214, 46, 13);
		contentPane.add(lblCp);
		
		lblPoblacion = new JLabel("Poblacion");
		lblPoblacion.setBounds(259, 214, 80, 13);
		contentPane.add(lblPoblacion);
		
		lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(459, 214, 74, 13);
		contentPane.add(lblProvincia);
		
		lblPoligono = new JLabel("Poligono");
		lblPoligono.setBounds(76, 263, 46, 13);
		contentPane.add(lblPoligono);
		
		lblParcela = new JLabel("Parcela");
		lblParcela.setBounds(259, 263, 46, 13);
		contentPane.add(lblParcela);
		
		lblM = new JLabel("m2");
		lblM.setBounds(459, 263, 46, 13);
		contentPane.add(lblM);
		
		comboBoxTipoFinca = new JComboBox();
		comboBoxTipoFinca.addActionListener(new ComboBoxTipoFincaActionListener());
		comboBoxTipoFinca.setBounds(459, 133, 160, 21);
		contentPane.add(comboBoxTipoFinca);
		modelo4 = new DefaultComboBoxModel();
		modelo4.addElement("Escoge tipo de finca");
		modelo4.addElement("Rústica");
		modelo4.addElement("Urbana");
		comboBoxTipoFinca.setModel(modelo4);
		
		lblNewLabel = new JLabel("Fecha del ultimo alquiler");
		lblNewLabel.setBounds(637, 137, 146, 13);
		contentPane.add(lblNewLabel);
		
		btnAnadir = new JButton("Anadir");
		btnAnadir.addMouseListener(new BtnAnadirMouseListener());
		btnAnadir.setBounds(197, 348, 85, 21);
		contentPane.add(btnAnadir);
		
		btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new BtnVolverMouseListener());
		btnVolver.setBounds(412, 348, 85, 21);
		contentPane.add(btnVolver);
		
		calendar = new JCalendar();
		calendar.setBounds(637, 163, 227, 152);
		contentPane.add(calendar);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	}
	private void rellenarModelo() {
		sucursal = IoData.obtenerSucursal();
		for (int i = 0; i < sucursal.size(); i++) {
			modelo1.addElement(sucursal.get(i));
		}
	}
	private void rellenarModelo2() {
		for (int i = 0; i < propietario.size(); i++) {
			if(propietario.get(i)!=null) {
				modelo3.addElement(propietario.get(i));
			}
		}
	}
	private class ComboBoxTipoProductoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String op  = (String) comboBoxTipoProducto.getSelectedItem();
			if(op.equalsIgnoreCase("Venta")) {
				textCosteVenta.setEnabled(true);
				textMargenVenta.setEnabled(true);
				textCosteAlquiler.setEnabled(false);
				textMargenAlquiler.setEnabled(false);
			}else if(op.equalsIgnoreCase("Alquiler")) {
				textCosteVenta.setEnabled(false);
				textMargenVenta.setEnabled(false);
				textCosteAlquiler.setEnabled(true);
				textMargenAlquiler.setEnabled(true);
			}else if(op.equalsIgnoreCase("Ambos")) {
				textCosteVenta.setEnabled(true);
				textMargenVenta.setEnabled(true);
				textCosteAlquiler.setEnabled(true);
				textMargenAlquiler.setEnabled(true);
			}else {
				textCosteVenta.setEnabled(false);
				textMargenVenta.setEnabled(false);
				textCosteAlquiler.setEnabled(false);
				textMargenAlquiler.setEnabled(false);
			}
			AnadirBotonEnabled();
		}
	}
	private class ComboBoxSucursalActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextCosteVentaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextMargenVentaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextCosteAlquilerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextMargenAlquilerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class ComboBoxTipoFincaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class ComboBoxPropietarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextCPActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextPoblacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextProvinciaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextPoligonoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class TextM2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class BtnVolverMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			menu m = new menu();
			m.setVisible(true);
			dispose();
		}
	}
	private class BtnAnadirMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e1) {
			if(btnAnadir.isEnabled()) {
				String a = textCodigo.getText();
				String b = (String) comboBoxPropietario.getSelectedItem();
				String c = (String) comboBoxSucursal.getSelectedItem();
				Double d = Double.parseDouble(textCosteVenta.getText());
				Double e = Double.parseDouble(textMargenAlquiler.getText());
				Double f = Double.parseDouble(textCosteAlquiler.getText());
				Double g = Double.parseDouble(textMargenAlquiler.getText());
				String h = (String) comboBoxTipoProducto.getSelectedItem();
				String i = textPoligono.getText();
				String j = textParcela.getText();
				Double k = Double.parseDouble(textM2.getText());
				String l = (String) comboBoxTipoFinca.getSelectedItem();
				String m = textCP.getText();
				String n = textPoblacion.getText();
				Date o = (Date) calendar.getDate();
				switch (h) {
				case "Venta":
					if(IoData.guardarFincaVenta(a, b, c, d, e, h, i, j, k, l, m, n, o)) {
						JOptionPane.showMessageDialog(null, "Finca de venta guardada");
					}else {
						JOptionPane.showMessageDialog(null, "Finca de venta no guardada");
					}
					break;
				case "Alquiler":
					if(IoData.guardarFincaAlquiler(a, b, c, f, g, h, i, j, k, l, m, n, o)) {
						JOptionPane.showMessageDialog(null, "Finca de alquiler guardada");
					}else {
						JOptionPane.showMessageDialog(null, "Finca de alquiler no guardada");
					}
					break;
				case "Ambos":
					if(IoData.guardarFincaAmbos(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o)) {
						JOptionPane.showMessageDialog(null, "Finca de alquiler y venta guardada");
					}else {
						JOptionPane.showMessageDialog(null, "Finca de alquiler y venta no guardada");
					}
					break;
				default:
					break;
				}
			}
		}
	}
	
	private void AnadirBotonEnabled() {
		String a = textCodigo.getText();
		String b = (String) comboBoxPropietario.getSelectedItem();
		String c = (String) comboBoxSucursal.getSelectedItem();
		String d = textCosteVenta.getText();
		String e = textMargenVenta.getText();
	    String f = textCosteAlquiler.getText();
		String g = textMargenAlquiler.getText();
		String h = (String) comboBoxTipoProducto.getSelectedItem();
		String i = textPoligono.getText();
		String j = textParcela.getText();
		String k = textM2.getText();
		String l = (String) comboBoxTipoFinca.getSelectedItem();
		String m = textCP.getText();
		String n = textPoblacion.getText();
		Date o = (Date) calendar.getDate();
		
		Pattern p = Pattern.compile("\\d+(.\\d+)?");
		Matcher m1 = p.matcher(textCosteVenta.getText());
		Matcher m2 = p.matcher(textMargenVenta.getText());
		Matcher m3 = p.matcher(textCosteAlquiler.getText());
		Matcher m4 = p.matcher(textMargenAlquiler.getText());
		Matcher m5 = p.matcher(textM2.getText());
		
		if(!a.equalsIgnoreCase("")&&!b.equalsIgnoreCase("Seleccione el propietario")&&!c.equalsIgnoreCase("Seleccione la sucursal")&&!h.equalsIgnoreCase("Escoger tipo de producto")
				&&!i.equalsIgnoreCase("")&&!j.equalsIgnoreCase("")&&!l.equalsIgnoreCase("Escoge tipo de finca")&&!m.equalsIgnoreCase("")&&!n.equalsIgnoreCase("")&&m5.matches()) {
			switch (h) {
			case "Venta":
				if(m1.matches() && m2.matches()) {
					btnAnadir.setEnabled(true);
				}
				break;
			case "Alquiler":
				if(m3.matches() && m4.matches()) {
					btnAnadir.setEnabled(true);
				}
				break;
			case "Ambos":
				if(m1.matches() && m2.matches() && m3.matches() && m4.matches()) {
					btnAnadir.setEnabled(true);
				}
				break;
			default:
				break;
			}
		}
	}
}
