package iodata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IoData {
	
	private final static String URL = "jdbc:mysql://localhost:3306/baseDatosEmpresa?useSSL=false";
	private final static String USUARIO = "root";
	private final static String PASSWORD = "miguel1912*";
	
	
	private static Connection con;
	
	
	public IoData() {
		con = null;
	}
	
	private static void conectar() {
		try {
			con = DriverManager.getConnection(URL,USUARIO,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void desconectar() {
		try {
			con.close();
			con=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ArrayList<String> obtenerSucursal() {
		conectar();
		ArrayList<String> sucursal = new ArrayList<String>();
		PreparedStatement pt = null;
		ResultSet rs = null;
		String sql = "Select codSucursal, nombreSucursal from sucursal;";
		try {
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					sucursal.add(rs.getString(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		desconectar();
		return sucursal;
	}
	public static ArrayList<String> obtenerPropietario(){
		conectar();
		ArrayList<String> propietario = new ArrayList<String>();
		PreparedStatement pt = null;
		ResultSet rs = null;
		String sql = "Select dniPropietario from propietario;";
		try {
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					propietario.add(rs.getString(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		desconectar();
		return propietario;
	}
	public static boolean guardarCliente(String a, String b, String c, String d, String e, String f, String g, String h, String i,
			String j, String k, Date l, String m) {
		conectar();
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			pt = con.prepareStatement("SELECT COUNT(dniCliente) FROM cliente WHERE dniCliente = ? AND codCliente = ?;");
			pt.setString(1, b);
			pt.setString(2, a);
			rs = pt.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {

				pt = con.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
				pt.setString(1, b);
				pt.setString(2, a);
				pt.setString(3, m);
				pt.setString(4, c);
				pt.setDate(5, (Date) l);
				pt.setString(6, d);
				pt.setString(7, f);
				pt.setString(8, e);
				pt.setString(9, g);
				pt.setString(10, h);
				pt.setString(11, i);
				pt.setString(12, j);
				pt.setString(13, k);

				pt.executeUpdate();

				return true;
			} else {
				desconectar();
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		desconectar();
		return false;
	}
	public static boolean guardarPropietario(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, java.util.Date l, String m) {
		conectar();
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			pt = con.prepareStatement("SELECT COUNT(dniPropietario) FROM propietario WHERE dniPropietario = ? AND codPropietario = ?;");
			pt.setString(1, b);
			pt.setString(2, a);
			rs = pt.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {

				pt = con.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
				pt.setString(1, b);
				pt.setString(2, a);
				pt.setString(3, m);
				pt.setString(4, c);
				pt.setDate(5, (Date) l);
				pt.setString(6, d);
				pt.setString(7, f);
				pt.setString(8, e);
				pt.setString(9, g);
				pt.setString(10, h);
				pt.setString(11, i);
				pt.setString(12, j);
				pt.setString(13, k);

				pt.executeUpdate();

				return true;
			} else {
				desconectar();
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		desconectar();
		return false;
	}
	public static boolean guardarFincaVenta(String a, String b, String c, Double d, Double e, String h, String i, String j, Double k, String l, String m, String n, Date o) {
		return false;
	}
	public static boolean guardarFincaAlquiler(String a, String b, String c, Double f, Double g, String h, String i, String j, Double k, String l, String m, String n, Date o) {
		return false;
	}
	public static boolean guardarFincaAmbos(String a, String b, String c, Double d, Double e, Double f, Double g, String h, String i, String j, Double k, String l, String m, String n, Date o) {
		return false;
	}
}


