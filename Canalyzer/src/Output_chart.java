import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.demo.charts.ExampleChart;
import static javax.swing.JOptionPane.*;

public class Output_chart implements ExampleChart<XYChart> {

	public static double initial_frequency;
	public static double final_frequency;
	public static int time_of_each_freq;
	public static int overall_resolution;
	public static int frequency_resolution;
	public GUI_chart gc;

	public void main(double iinitial_frequency, double ifinal_frequency, int itime_of_each_freq,
			int ioverall_resolution, int ifrequency_resolution) {

		if(iinitial_frequency>=ifinal_frequency || itime_of_each_freq <= 0 || ioverall_resolution<=0 || ifrequency_resolution<=0)
		{
			showMessageDialog(null, "Neplatný vstup", "Chyba", ERROR_MESSAGE);
			
		}
		else
		{
			initial_frequency = iinitial_frequency;
			final_frequency = ifinal_frequency;
			time_of_each_freq = itime_of_each_freq;
			overall_resolution = ioverall_resolution;
			frequency_resolution = ifrequency_resolution;

			gc = new GUI_chart(getChart());
		}
		
	}

	public XYChart getChart() {

		List<Double> yData = new ArrayList<Double>();
		List<Double> xData = Meter.measure(initial_frequency, final_frequency, time_of_each_freq, overall_resolution,
				frequency_resolution);
		for (Double d : xData) {
			d = d - Collections.min(xData);
		}
		System.out.println(xData);
		yData = (Meter.output_frequencies);
		XYChart chart = new XYChartBuilder().width((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth())))
				.height((int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()) * 0.9)).title("")
				.xAxisTitle("Frequency [Hz]").yAxisTitle("Signal Strength [dB]").build();
		chart.getStyler().setXAxisLogarithmic(true);
		chart.getStyler().setLegendVisible(false);
		chart.addSeries("Output", yData, xData);
		return chart;
	}
}