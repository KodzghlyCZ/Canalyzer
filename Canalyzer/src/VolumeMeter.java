import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.LineUnavailableException;

public class VolumeMeter {

	protected TargetDataLine line = null;

	public void startListening() {
		AudioFormat format = new AudioFormat(42000.0f, 16, 1, true, true);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		if (!AudioSystem.isLineSupported(info)) { // If no default line
			System.out.println("The TargetDataLine is unavailable");
		}
		try {
			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);
			line.start();
		} catch (LineUnavailableException ex) {
			System.out.println("The TargetDataLine is Unavailable.");
		}
	}

	protected double calculateRMSLevel(byte[] audioData) {
		long lSum = 0;
		for (int i = 0; i < audioData.length; i++)
			lSum = lSum + audioData[i];
		double dAvg = lSum / audioData.length;
		double sumMeanSquare = 0d;
		for (int j = 0; j < audioData.length; j++)
			sumMeanSquare = sumMeanSquare + Math.pow(audioData[j] - dAvg, 2d);
		double averageMeanSquare = sumMeanSquare / audioData.length;
		return (Math.pow(averageMeanSquare, 0.5d) + 0.5) - 50;
	}

	public double vol() {
		double level;
		byte tempBuffer[] = new byte[6000];
		try {

			if (line.read(tempBuffer, 0, tempBuffer.length) > 0) {
				level = calculateRMSLevel(tempBuffer);
				return level;
			}
		} catch (Exception e) {
			System.err.println(e);
			System.exit(0);
		}
		return (Integer) null;
	}

	public void close() {
		line.close();
	}

}