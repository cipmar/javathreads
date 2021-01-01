package javathreads.executors.recipe09;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CompletionService - Separating the launching of tasks and the processing of their results in an executor
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

		ReportRequest faceRequest = new ReportRequest("Face", completionService);
		ReportRequest onlineRequest = new ReportRequest("Online", completionService);

		Thread faceThread = new Thread(faceRequest);
		Thread onlineThread = new Thread(onlineRequest);

		ReportProcessor reportProcessor = new ReportProcessor(completionService);
		Thread senderThread = new Thread(reportProcessor);

		System.out.println("Main: Starting the threads");
		faceThread.start();
		onlineThread.start();
		senderThread.start();

		System.out.println("Main: Waiting the report generators");
		try {
			faceThread.join();
			onlineThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main: Shutting down the executor");
		executorService.shutdown();

		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		reportProcessor.stopProcessing();
		System.out.println("Main: Ends");
	}
}
