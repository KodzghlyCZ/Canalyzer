import javax.sound.sampled.*;

public class Tone {
	public static void sound(double input_frequency, int time_in_seconds) {
		int seconds = time_in_seconds;
		int sampleRate = 48000;
		double frequency = input_frequency;
		double RAD = 2.0 * Math.PI;
		try {
			AudioFormat af = new AudioFormat((float) sampleRate, 8, 1, true, true);
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
			SourceDataLine source = (SourceDataLine) AudioSystem.getLine(info);
			source.open(af);
			source.start();
			byte[] buf = new byte[sampleRate * seconds];
			for (int i = 0; i < buf.length; i++) {
				buf[i] = (byte) (Math.sin(RAD * frequency / sampleRate * i) * 127.0);
			}
			source.write(buf, 0, buf.length);
			source.drain();
			source.stop();
			source.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}