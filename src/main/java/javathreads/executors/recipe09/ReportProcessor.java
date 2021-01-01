package javathreads.executors.recipe09;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class ReportProcessor implements Runnable {

	private final CompletionService<String> completionService;
	private volatile boolean end;

	public ReportProcessor(CompletionService<String> completionService) {
		this.completionService = completionService;
		this.end = false;
	}

	@Override
	public void run() {

		while (!end) {

			try {
				Future<String> result = completionService.poll(20, TimeUnit.SECONDS);

				if (result != null) {
					String report = result.get();
					System.out.printf("ReportReceiver: Report received: %s\n", report);
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		System.out.println("ReportReceiver: End");
	}

	public void stopProcessing() {

		this.end = true;
	}
}
