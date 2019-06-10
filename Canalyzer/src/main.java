public class main {
	static VolumeMeter m;

	public static void main(String[] args) {
		init();
		Canalyzer.main(args);
		// Output_chart.main(10, 100, 1, 5, 5);
	}

	private static void init() {
		m = new VolumeMeter();
		main.m.startListening();
	}

}