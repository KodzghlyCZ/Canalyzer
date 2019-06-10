import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Meter {
	public static double current_frequency;
	static double initial_frequency_point;
	static double final_frequency_point;
	static double vol_measurements;
	static int output_values_index;
	public static ArrayList<Double> output_values;
	public static ArrayList<Double> output_frequencies;

	public static ArrayList<Double> measure(double initial_frequency, double final_frequency, int time_of_each_freq,
			int overall_resolution, int frequency_resolution) {
		output_values = new ArrayList<Double>();
		output_frequencies = new ArrayList<Double>();
		initial_frequency_point = Math.log10(initial_frequency);
		final_frequency_point = Math.log10(final_frequency);

		
		for (double i = initial_frequency_point; i <= final_frequency_point; i += ((final_frequency_point
				- initial_frequency_point) / (overall_resolution - 1))) {
			current_frequency = Math.pow(10, i);

			new Thread() {
				public void run() {
					try {
						TimeUnit.MILLISECONDS.sleep(
								(long) (((double) time_of_each_freq / ((double) frequency_resolution + 1)) * 1000));
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					vol_measurements = 0;
					for (int y = 0; y < frequency_resolution; y++) {

						vol_measurements += main.m.vol();

						try {
							TimeUnit.MILLISECONDS.sleep(
									(long) (((double) time_of_each_freq / ((double) frequency_resolution + 1)) * 1000));
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					}
					output_values.add((double) vol_measurements / (double) frequency_resolution);
					output_frequencies.add(current_frequency);

				}
			}.start();
			new Thread() {
				public void run() {
					Tone.sound(current_frequency, time_of_each_freq);
				}

			}.run();
		}
		return (output_values);
	}
}
