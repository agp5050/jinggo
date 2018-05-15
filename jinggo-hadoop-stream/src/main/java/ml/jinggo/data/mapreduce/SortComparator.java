package ml.jinggo.data.mapreduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
/**
 * ClassName: SortComparator
 * @Description: 排序类，通过receiveTime来对时间进行排序。
 * @author 王宏
 * @date 2017年11月20日
 */
public class SortComparator extends WritableComparator{
	protected SortComparator() {
			super(Text.class, true); 
		}
		@Override
		public int compare(@SuppressWarnings("rawtypes") WritableComparable w1, @SuppressWarnings("rawtypes") WritableComparable w2) {
			
			String[] comp1 = w1.toString().split("&");
			String[] comp2 = w2.toString().split("&");
			
			long result = 1;
			
			if(comp1 != null && comp2 != null){
				//sessionId
				result = comp1[0].compareTo(comp2[0]);
				//sessionId和receiveTime
				if(result == 0 && comp1.length > 1 && comp2.length > 1){
					
					long receiveTime1 = 0;
					long receiveTime2 = 0;
					
					try {
						///receiveTime
						receiveTime1 = Long.parseLong(comp1[1]);
						receiveTime2 = Long.parseLong(comp2[1]);
						result = receiveTime1 - receiveTime2;
						
						if(result == 0){
							//receiveTime
							return 0;
						}else{
							//receiveTime
							return result > 0 ? 1 : -1;
						}
						
					} catch (Exception e) {
						return 1;
					}
				}
				return result > 0 ? 1 : -1;
			}
			return 1;
		}
	}