package javathreads.executors.recipe09;

import java.util.concurrent.CompletionService;

/**
 * @author mropotica
 */
public class ReportRequest implements Runnable {

	private final String name;
	private final CompletionService<String> completionService;

	public ReportRequest(String name, CompletionService<String> completionService) {
		this.name = name;
		this.completionService = completionService;
	}

	@Override
	public void run() {

		ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
		completionService.submit(reportGenerator);
	}
}
