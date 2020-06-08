package MenuPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import com.toedter.calendar.JDayChooser;

import iodata.IoData;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Persona extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblDni;
	private JLabel lblCcc;
	private JTextField textCodigo;
	private JTextField textDNI;
	private JTextField textCCC;
	private JLabel lblDireccin;
	private JLabel lblCp;
	private JLabel lblPoblacion;
	private JLabel lblProvincia;
	private JLabel lblTelefono;
	private JTextField textDireccion;
	private JTextField textCP;
	private JTextField textPoblacion;
	private JTextField textProvincia;
	private JTextField textTelefono;
	private JRadioButton rdbtnCliente;
	private JRadioButton rdbtnPropietario;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textObservaciones;
	private JLabel lblNewLabel_1;
	private JDayChooser dayChooser;
	private JRadioButton rdbtnActivo;
	private JRadioButton rdbtnNoActivo;
	private JComboBox comboBox;
	private ArrayList<String> sucursal = new ArrayList<String>();
	private DefaultComboBoxModel modelo;
	private JButton btnAnadir;
	private JButton btnVolver;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private DateFormat df;
	private JTextField textNombreApellidos;
	private JLabel lblNewLabel_2;
	private JCalendar calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persona frame = new Persona();
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
	public Persona() {
		df = new SimpleDateFormat("dd-MM-yyyy");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(52, 43, 46, 13);
		contentPane.add(lblNewLabel);

		lblDni = new JLabel("DNI");
		lblDni.setBounds(158, 43, 46, 13);
		contentPane.add(lblDni);

		lblCcc = new JLabel("CCC");
		lblCcc.setBounds(52, 95, 46, 13);
		contentPane.add(lblCcc);

		textCodigo = new JTextField();
		textCodigo.addKeyListener(new TextCodigoKeyListener());
		textCodigo.setBounds(52, 66, 96, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		textDNI = new JTextField();
		textDNI.addKeyListener(new TextDNIKeyListener());
		textDNI.setColumns(10);
		textDNI.setBounds(158, 66, 96, 19);
		contentPane.add(textDNI);

		textCCC = new JTextField();
		textCCC.addKeyListener(new TextCCCKeyListener());
		textCCC.setColumns(10);
		textCCC.setBounds(52, 114, 96, 19);
		contentPane.add(textCCC);

		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(165, 95, 46, 13);
		contentPane.add(lblDireccin);

		lblCp = new JLabel("CP");
		lblCp.setBounds(279, 95, 46, 13);
		contentPane.add(lblCp);

		lblPoblacion = new JLabel("Poblacion");
		lblPoblacion.setBounds(52, 143, 46, 13);
		contentPane.add(lblPoblacion);

		lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(165, 143, 46, 13);
		contentPane.add(lblProvincia);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(279, 143, 46, 13);
		contentPane.add(lblTelefono);

		textDireccion = new JTextField();
		textDireccion.addKeyListener(new TextDireccionKeyListener());
		textDireccion.setColumns(10);
		textDireccion.setBounds(165, 114, 96, 19);
		contentPane.add(textDireccion);

		textCP = new JTextField();
		textCP.addKeyListener(new TextCPKeyListener());
		textCP.setColumns(10);
		textCP.setBounds(279, 114, 96, 19);
		contentPane.add(textCP);

		textPoblacion = new JTextField();
		textPoblacion.addKeyListener(new TextPoblacionKeyListener());
		textPoblacion.setColumns(10);
		textPoblacion.setBounds(52, 166, 96, 19);
		contentPane.add(textPoblacion);

		textProvincia = new JTextField();
		textProvincia.addKeyListener(new TextProvinciaKeyListener());
		textProvincia.setColumns(10);
		textProvincia.setBounds(165, 166, 96, 19);
		contentPane.add(textProvincia);

		textTelefono = new JTextField();
		textTelefono.addKeyListener(new TextTelefonoKeyListener());
		textTelefono.setColumns(10);
		textTelefono.setBounds(279, 166, 96, 19);
		contentPane.add(textTelefono);

		rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.addActionListener(new RdbtnClienteActionListener());
		buttonGroup.add(rdbtnCliente);
		rdbtnCliente.setBounds(416, 65, 105, 21);
		contentPane.add(rdbtnCliente);

		rdbtnPropietario = new JRadioButton("Propietario");
		rdbtnPropietario.addActionListener(new RdbtnPropietarioActionListener());
		buttonGroup.add(rdbtnPropietario);
		rdbtnPropietario.setBounds(416, 91, 105, 21);
		contentPane.add(rdbtnPropietario);

		textObservaciones = new JTextArea();
		textObservaciones.addKeyListener(new TextObservacionesKeyListener());
		textObservaciones.setBounds(416, 216, 276, 116);
		contentPane.add(textObservaciones);

		lblNewLabel_1 = new JLabel("Observaciones");
		lblNewLabel_1.setBounds(416, 195, 68, 13);
		contentPane.add(lblNewLabel_1);

		rdbtnActivo = new JRadioButton("Activo");
		rdbtnActivo.addActionListener(new RdbtnActivoActionListener());
		buttonGroup_1.add(rdbtnActivo);
		rdbtnActivo.setBounds(533, 65, 105, 21);
		contentPane.add(rdbtnActivo);

		rdbtnNoActivo = new JRadioButton("No activo");
		rdbtnNoActivo.addActionListener(new RdbtnNoActivoActionListener());
		buttonGroup_1.add(rdbtnNoActivo);
		rdbtnNoActivo.setBounds(533, 91, 105, 21);
		contentPane.add(rdbtnNoActivo);

		comboBox = new JComboBox();
		comboBox.setBounds(425, 149, 164, 21);
		contentPane.add(comboBox);
		modelo = new DefaultComboBoxModel();
		modelo.addElement("Seleccione la sucursal");
		rellenarModelo();
		comboBox.setModel(modelo);

		btnAnadir = new JButton("Anadir");
		btnAnadir.addMouseListener(new BtnAnadirMouseListener());
		btnAnadir.setBounds(63, 354, 85, 21);
		contentPane.add(btnAnadir);
		btnAnadir.setEnabled(false);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(607, 354, 85, 21);
		contentPane.add(btnVolver);
		
		textNombreApellidos = new JTextField();
		textNombreApellidos.setColumns(10);
		textNombreApellidos.setBounds(279, 66, 96, 19);
		contentPane.add(textNombreApellidos);
		
		lblNewLabel_2 = new JLabel("Nombre y apellidos");
		lblNewLabel_2.setBounds(279, 43, 96, 13);
		contentPane.add(lblNewLabel_2);
		
		calendar = new JCalendar();
		calendar.setBounds(54, 216, 200, 116);
		contentPane.add(calendar);

		System.getProperty("com.toedter.calendar.JCalendar");
	}

	private void rellenarModelo() {
		sucursal = IoData.obtenerSucursal();
		for (int i = 0; i < sucursal.size(); i++) {
			modelo.addElement(sucursal.get(i));
		}
	}

	private void AnadirBotonEnabled() {
		String a = textCodigo.getText();
		String c = textCCC.getText();
		String d = textDireccion.getText();
		String f = textPoblacion.getText();
		String g = textProvincia.getText();
		String h = textTelefono.getText();
		String i = "";
		if (rdbtnActivo.isSelected()) {
			i = "Activo";
		} else if (rdbtnNoActivo.isSelected()) {
			i = "No activo";
		}
		String j = textObservaciones.getText();
		String k = (String) comboBox.getSelectedItem();
		java.util.Date l = calendar.getDate();
		String m = textNombreApellidos.getText();
		if(!a.equalsIgnoreCase("")&&patternMatcher()&&!c.equalsIgnoreCase("")&&!d.equalsIgnoreCase("")
				&&!f.equalsIgnoreCase("")&&!g.equalsIgnoreCase("")&&!h.equalsIgnoreCase("")&&!i.equalsIgnoreCase("")
				&&!k.equalsIgnoreCase("Seleccione la sucursal") && (rdbtnCliente.isSelected() || rdbtnPropietario.isSelected())) {
			btnAnadir.setEnabled(true);
		}else {
			btnAnadir.setEnabled(false);
		}
	}
	
	private class RdbtnClienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class RdbtnActivoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class TextObservacionesKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class TextCodigoKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class TextDNIKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class TextCCCKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class TextDireccionKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class TextCPKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class TextPoblacionKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class TextProvinciaKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class TextTelefonoKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class RdbtnPropietarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class RdbtnNoActivoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AnadirBotonEnabled();
		}
	}
	private class BtnAnadirMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e1) {
			String a = textCodigo.getText();
			String b = textDNI.getText();
			String c = textCCC.getText();
			String d = textDireccion.getText();
			String e = textCP.getText();
			String f = textPoblacion.getText();
			String g = textProvincia.getText();
			String h = textTelefono.getText();
			String i = "";
			if (rdbtnActivo.isSelected()) {
				i = "Activo";
			} else if (rdbtnNoActivo.isSelected()) {
				i = "No activo";
			}
			String j = textObservaciones.getText();
			String k = (String) comboBox.getSelectedItem();
			Date l = (Date) calendar.getDate();
			String m = textNombreApellidos.getText();
			if(btnAnadir.isEnabled()) {
				if(rdbtnCliente.isSelected()) {
					if(IoData.guardarCliente(a, b, c, d, e, f, g, h, i, j, k, l, m)) {
						JOptionPane.showMessageDialog(null, "Cliente añadido");
					}else {
						JOptionPane.showMessageDialog(null, "Cliente no añadido");
					}
				}
				if(rdbtnPropietario.isSelected()) {
					if(IoData.guardarPropietario(a, b, c, d, e, f, g, h, i, j, k, l, m)) {
						JOptionPane.showMessageDialog(null, "Propietario añadido");
					}else {
						JOptionPane.showMessageDialog(null, "Propietario no añadido");
					}
				}
			}
		}
	}
	private boolean patternMatcher() {
		Pattern pDni = Pattern.compile("[0-9]{8}[A-Z]");
		Pattern pCp = Pattern.compile("[0-9]{5}");
		Matcher m1 = pDni.matcher(textDNI.getText());
		Matcher m2 = pCp.matcher(textCP.getText());
		if(m1.matches()&&m2.matches()) {
			return true;
		}
		return false;
	}
}
