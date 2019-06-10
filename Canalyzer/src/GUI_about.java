import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Label;

public class GUI_about {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_about window = new GUI_about();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_about() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_about.class.getResource("/images/Canalyzer_logo.png")));
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.getContentPane().setLayout(null);
		
		JLabel lblCanalyzer = new JLabel("Canalyzer");
		lblCanalyzer.setForeground(new Color(0, 204, 102));
		lblCanalyzer.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCanalyzer.setBounds(10, 11, 157, 33);
		frame.getContentPane().add(lblCanalyzer);
		
		JLabel lblByJustBucket = new JLabel("by Just Bucket");
		lblByJustBucket.setForeground(new Color(51, 204, 153));
		lblByJustBucket.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblByJustBucket.setBounds(10, 55, 157, 14);
		frame.getContentPane().add(lblByJustBucket);
		
		Label label = new Label("Licensed under GNU GPL V3 license");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 10));
		label.setBounds(10, 75, 200, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("ver. 1.0");
		label_1.setForeground(new Color(0, 255, 153));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(173, 22, 51, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("2019 - Just Bucket Software");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setAlignment(Label.RIGHT);
		label_2.setBounds(10, 129, 230, 22);
		frame.getContentPane().add(label_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUI_about.class.getResource("/images/Just Bucket Logo.png")));
		lblNewLabel.setBounds(230, 11, 140, 140);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 389, 208);
	}
}
