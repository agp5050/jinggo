package ml.jinggo.aspectj.basic;
import ml.jinggo.Seller;
import ml.jinggo.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;



@Aspect
public class EnableSellerAspect {
   @DeclareParents(value="ml.jinggo.NaiveWaiter",
		   defaultImpl=SmartSeller.class)
   public Seller seller;
}
