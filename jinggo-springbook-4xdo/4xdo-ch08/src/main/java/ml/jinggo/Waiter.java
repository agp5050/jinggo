package ml.jinggo;

import ml.jinggo.anno.NeedTest;

public interface Waiter {
	@NeedTest
	public void greetTo(String clientName);	
	public void serveTo(String clientName);
}
