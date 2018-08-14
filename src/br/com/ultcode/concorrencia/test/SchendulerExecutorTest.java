package br.com.ultcode.concorrencia.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchendulerExecutorTest {
	public static void main(String[] args) {
		
		beep();

	}
	
	public static void beep() {
		final Runnable beeper = new Runnable() {

			@Override
			public void run() {
				System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " beep");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}
			
		};
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
		//scheduledExecutor.scheduleAtFixedRate(beeper, 1, 5, TimeUnit.SECONDS);	
		ScheduledFuture<?> sf = scheduledExecutor.scheduleWithFixedDelay(beeper, 1, 5, TimeUnit.SECONDS);	
		scheduledExecutor.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("Terminando execução");
				sf.cancel(false);
				scheduledExecutor.shutdown();
			}
			
		}, 25, TimeUnit.SECONDS);
		
	}
}
