package MenuPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnRegistrarFinca;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Registrar persona");
		btnNewButton.addMouseListener(new BtnNewButtonMouseListener());
		btnNewButton.setBounds(90, 221, 121, 21);
		contentPane.add(btnNewButton);
		
		btnRegistrarFinca = new JButton("Registrar finca");
		btnRegistrarFinca.addMouseListener(new BtnRegistrarFincaMouseListener());
		btnRegistrarFinca.setBounds(372, 221, 114, 21);
		contentPane.add(btnRegistrarFinca);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\migue\\eclipse-workspace\\BBDDEmpresa\\src\\iconoEmpresa.jpg"));
		lblNewLabel.setBounds(189, 61, 200, 118);
		contentPane.add(lblNewLabel);
	}
	private class BtnNewButtonMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Persona p = new Persona();
			p.setVisible(true);
			dispose();
		}
	}
	private class BtnRegistrarFincaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Finca f = new Finca();
			f.setVisible(true);
			dispose();
		}
	}
}
