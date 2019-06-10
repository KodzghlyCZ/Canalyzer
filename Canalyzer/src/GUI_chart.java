import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

public class GUI_chart {
	BufferedImage image;
	JFrame frame;
	JPanel char_pan;

	public GUI_chart(XYChart ichart) {
		char_pan = new XChartPanel(ichart);
		frame = new JFrame("Canalyzer output");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.add(char_pan);
		frame.pack();
		frame.setVisible(true);
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Canalyzer.class.getResource("/images/Canalyzer_logo.png")));

	}

	public void save() {
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(char_pan.bounds());
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		Graphics2D graphics2D = image.createGraphics();
		char_pan.paint(graphics2D);

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setSelectedFile(new File("Canalyzer_output.png"));

		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();

			try {
				ImageIO.write(image, "png", file);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
	}
}
