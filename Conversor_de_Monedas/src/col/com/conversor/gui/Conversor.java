package col.com.conversor.gui;
/**
 * @author Janier Yulder Gomez Galindez
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import col.com.conversor.function.ConversorMonedas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conversor extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;
	private ConversorMonedas conversorMonedas = new ConversorMonedas();
	//Siglas de las Monedas
	private String dolar = "USD";
	private String euro = "EUR";
	private String libra_Esterlina = "GBP";
	private String yen_Japones = "JPY";
	private String won_Sur_Coreano = "KRW";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
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
	public Conversor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor de Monedas");
		lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 15));
		lblNewLabel.setBounds(129, 11, 228, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona la conversión a realizar:");
		lblNewLabel_1.setBounds(27, 53, 308, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Convertir de: ");
		lblNewLabel_2.setBounds(37, 78, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("A: ");
		lblNewLabel_2_1.setBounds(37, 122, 67, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JComboBox cbxOrigen = new JComboBox();
		cbxOrigen.setModel(new DefaultComboBoxModel(new String[] {"Peso Colombiano", "Dolar","Euro", "Libra esterlina", "Yen Japonés", "Won Sur-Coreano"}));
		cbxOrigen.setBounds(143, 78, 136, 22);
		contentPane.add(cbxOrigen);
		
		JComboBox cbxDestino = new JComboBox();
		cbxDestino.setModel(new DefaultComboBoxModel(new String[] {"Peso Colombiano", "Dolar","Euro", "Libra esterlina", "Yen Japonés", "Won Sur-Coreano"}));
		cbxDestino.setBounds(143, 118, 136, 22);
		contentPane.add(cbxDestino);
		
		JLabel lblNewLabel_3 = new JLabel("Valor a convertir:");
		lblNewLabel_3.setBounds(35, 160, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		txtValor = new JTextField();
		txtValor.setBounds(145, 157, 155, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblResultado = new JLabel("-");
		lblResultado.setBounds(40, 205, 414, 14);
		contentPane.add(lblResultado);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText("-");
				if (txtValor.getText().equals("")) {
					JOptionPane.showMessageDialog(btnConvertir, "Por favor Ingresa un valor.");
					return;
				}
				try {
					String monedaOrigen = cbxOrigen.getSelectedItem().toString();
					String monedaDestino = cbxDestino.getSelectedItem().toString();
					double valor = conversorMonedas.string_double(txtValor.getText());
					
					//Caso de que la moneda origen sea el COP
					if (monedaOrigen.equals("Peso Colombiano")) {
						String origen = "COP";
						String resultado = "";
						switch (monedaDestino) {
						case "Dolar": {
							resultado = conversorMonedas.convertir(origen, dolar, valor);
							lblResultado.setText(resultado);
							break;
						}
						case "Euro": {
							resultado = conversorMonedas.convertir(origen, euro, valor);
							lblResultado.setText(resultado);
							break;
						}
						case "Libra esterlina": {
							resultado = conversorMonedas.convertir(origen, libra_Esterlina, valor);
							lblResultado.setText(resultado);
							break;
						}
						case "Yen Japonés": {
							resultado = conversorMonedas.convertir(origen, yen_Japones, valor);
							lblResultado.setText(resultado);
							break;
						}
						case "Won Sur-Coreano": {
							resultado = conversorMonedas.convertir(origen, won_Sur_Coreano, valor);
							lblResultado.setText(resultado);
							break;
						}
						}
					}
					//Caso de que la moneda destino sea el COP
					else if(monedaDestino.equals("Peso Colombiano")){
						String destino = "COP";
						String resultado = "";
						switch (monedaOrigen) {
						case "Dolar": {
							resultado = conversorMonedas.convertir(dolar, destino, valor);
							lblResultado.setText(resultado);
							break;
						}
						case "Euro": {
							resultado = conversorMonedas.convertir(euro, destino,valor);
							lblResultado.setText(resultado);
							break;
						}
						case "Libra esterlina": {
							resultado = conversorMonedas.convertir(libra_Esterlina, destino,valor);
							lblResultado.setText(resultado);
							break;
						}
						case "Yen Japonés": {
							resultado = conversorMonedas.convertir(yen_Japones, destino,valor);
							lblResultado.setText(resultado);
							break;
						}
						case "Won Sur-Coreano": {
							resultado = conversorMonedas.convertir(won_Sur_Coreano, destino,valor);
							lblResultado.setText(resultado);
							break;
						}
					}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnConvertir, "Por favor Ingresa un Valor Numérico");
				}
				
			}
		});
		btnConvertir.setBounds(347, 256, 89, 23);
		contentPane.add(btnConvertir);
	}}
