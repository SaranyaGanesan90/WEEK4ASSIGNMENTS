package assignment.week4;

public interface AlertWindow {
	void accept();
	void dismiss();
	String getText();
	void sendKeys(String keysToSend);

}

