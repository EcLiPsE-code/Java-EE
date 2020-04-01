package by.gstu.View;

import by.gstu.Entity.ComputingStream;
import by.gstu.Entity.PrintThread;
import by.gstu.Entity.Resources;

public class Main {
    public static void main(String[] args) {
		Resources resources = Resources.getInstance();
		Thread operationSin = new Thread(new ComputingStream(0.0, 1, 0.1,"sinus", resources) {
			@Override
			public double Func(double x) {
				return Math.sin(x);
			}
		});

		Thread operationCos = new Thread(new ComputingStream(0.0, 1, 0.1, "cosinus", resources) {
			@Override
			public double Func(double x) {
				return Math.cos(x);
			}
		});
		Thread printResult = new Thread(new PrintThread(resources));
		operationSin.start();
		operationCos.start();
		printResult.start();
	}
}
