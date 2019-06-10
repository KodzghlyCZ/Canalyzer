import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import static javax.swing.JOptionPane.*;

public class Canalyzer {

	Output_chart oc ;
	private JFrame frmCanalyzer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Canalyzer window = new Canalyzer();
					window.frmCanalyzer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Canalyzer() {
		initialize();
	}
	private void initialize() {
		frmCanalyzer = new JFrame();
		frmCanalyzer.setIconImage(Toolkit.getDefaultToolkit().getImage(Canalyzer.class.getResource("/images/Canalyzer_logo.png")));
		frmCanalyzer.setTitle("Canalyzer");
		frmCanalyzer.getContentPane().setBackground(new Color(51, 51, 51));
		frmCanalyzer.setBounds(100, 100, 493, 254);
		frmCanalyzer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCanalyzer.getContentPane().setLayout(null);
		
		JTextPane tf_init_freq = new JTextPane();
		tf_init_freq.setText("100");
		tf_init_freq.setBackground(new Color(204, 204, 204));
		tf_init_freq.setBounds(206, 11, 147, 20);
		frmCanalyzer.getContentPane().add(tf_init_freq);
		
		JLabel lblNewLabel = new JLabel("Initial frequency:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(51, 204, 102));
		lblNewLabel.setBounds(10, 11, 137, 20);
		frmCanalyzer.getContentPane().add(lblNewLabel);
		
		JLabel lblFinalFrequency = new JLabel("Final frequency:");
		lblFinalFrequency.setForeground(new Color(51, 204, 102));
		lblFinalFrequency.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFinalFrequency.setBounds(10, 42, 137, 20);
		frmCanalyzer.getContentPane().add(lblFinalFrequency);
		
		JTextPane tf_finl_freq = new JTextPane();
		tf_finl_freq.setText("200");
		tf_finl_freq.setBackground(new Color(204, 204, 204));
		tf_finl_freq.setBounds(206, 42, 147, 20);
		frmCanalyzer.getContentPane().add(tf_finl_freq);
		
		JLabel lblOverallResolution = new JLabel("Overall resolution");
		lblOverallResolution.setForeground(new Color(51, 204, 102));
		lblOverallResolution.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOverallResolution.setBounds(10, 73, 137, 20);
		frmCanalyzer.getContentPane().add(lblOverallResolution);
		
		JTextPane tf_ovrl_res = new JTextPane();
		tf_ovrl_res.setText("3");
		tf_ovrl_res.setBackground(new Color(204, 204, 204));
		tf_ovrl_res.setBounds(206, 73, 147, 20);
		frmCanalyzer.getContentPane().add(tf_ovrl_res);
		
		JLabel lblSingleMeasurementResolution = new JLabel("Single measurement");
		lblSingleMeasurementResolution.setForeground(new Color(51, 204, 102));
		lblSingleMeasurementResolution.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSingleMeasurementResolution.setBounds(10, 104, 186, 20);
		frmCanalyzer.getContentPane().add(lblSingleMeasurementResolution);
		
		JTextPane tf_sngl_res = new JTextPane();
		tf_sngl_res.setText("3");
		tf_sngl_res.setBackground(new Color(204, 204, 204));
		tf_sngl_res.setBounds(206, 104, 147, 20);
		frmCanalyzer.getContentPane().add(tf_sngl_res);
		
		JLabel lblHz = new JLabel("Hz");
		lblHz.setForeground(new Color(51, 204, 102));
		lblHz.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHz.setBounds(363, 11, 19, 20);
		frmCanalyzer.getContentPane().add(lblHz);
		
		JLabel label = new JLabel("Hz");
		label.setForeground(new Color(51, 204, 102));
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(363, 42, 19, 20);
		frmCanalyzer.getContentPane().add(label);
		
		JLabel lblMeasurements = new JLabel("measurements");
		lblMeasurements.setForeground(new Color(51, 204, 102));
		lblMeasurements.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMeasurements.setBounds(363, 73, 127, 20);
		frmCanalyzer.getContentPane().add(lblMeasurements);
		
		JLabel lblMeasurements_1 = new JLabel("measurements");
		lblMeasurements_1.setForeground(new Color(51, 204, 102));
		lblMeasurements_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMeasurements_1.setBounds(363, 104, 109, 20);
		frmCanalyzer.getContentPane().add(lblMeasurements_1);
		
		JLabel lblResolution = new JLabel("resolution:");
		lblResolution.setForeground(new Color(51, 204, 102));
		lblResolution.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResolution.setBounds(10, 122, 186, 20);
		frmCanalyzer.getContentPane().add(lblResolution);
		
		JTextPane tf_freq_time = new JTextPane();
		tf_freq_time.setText("1");
		tf_freq_time.setBackground(new Color(204, 204, 204));
		tf_freq_time.setBounds(206, 153, 147, 20);
		frmCanalyzer.getContentPane().add(tf_freq_time);
		
		JLabel label_1 = new JLabel("Frequency measure time:");
		label_1.setForeground(new Color(51, 204, 102));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(10, 153, 203, 20);
		frmCanalyzer.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("s");
		label_2.setForeground(new Color(51, 204, 102));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(363, 153, 19, 20);
		frmCanalyzer.getContentPane().add(label_2);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				oc = new Output_chart();
				try
				{
				oc.main(Integer.parseInt(tf_init_freq.getText()), Integer.parseInt(tf_finl_freq.getText()), Integer.parseInt(tf_freq_time.getText()), Integer.parseInt(tf_ovrl_res.getText()), Integer.parseInt(tf_sngl_res.getText()));
				}
				catch(java.util.NoSuchElementException e)
				{
					showMessageDialog(null, "Neplatný vstup", "Chyba", ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(10, 184, 186, 23);
		frmCanalyzer.getContentPane().add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oc.gc.save();
			}
		});
		btnSave.setBounds(206, 184, 147, 23);
		frmCanalyzer.getContentPane().add(btnSave);
		
		JButton btnNewButton_1 = new JButton("About");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_about.main(null);
			}
		});
		btnNewButton_1.setBounds(363, 184, 109, 23);
		frmCanalyzer.getContentPane().add(btnNewButton_1);
	}
}
