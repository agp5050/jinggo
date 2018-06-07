package ml.jinggo.proxy;

public class ForumServiceImpl implements ForumService {

	public void removeTopic(int topicId) {
	//	PerformanceMonitor.begin("ml.jinggo.proxy.ForumServiceImpl.removeTopic");
		System.out.println("模拟删除Topic记录:"+topicId);
		try {
			Thread.currentThread().sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	//	PerformanceMonitor.end();
	}

	public void removeForum(int forumId) {
	//	PerformanceMonitor.begin("ml.jinggo.proxy.ForumServiceImpl.removeForum");
		System.out.println("模拟删除Forum记录:"+forumId);
		try {
			Thread.currentThread().sleep(40);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	//	PerformanceMonitor.end();
	}
}
