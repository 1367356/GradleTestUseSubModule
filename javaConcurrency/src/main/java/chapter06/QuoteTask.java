package chapter06;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.Executor;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-15 22:35
 * 旅游报价
 **/
public class QuoteTask implements Callable<TravelQuote>{
    private final TravelCompany travelCompany;
    private final TravelInfo travelInfo;

    public QuoteTask(TravelCompany travelCompany, TravelInfo travelInfo) {
        this.travelCompany = travelCompany;
        this.travelInfo = travelInfo;
    }

    @Override
    public TravelQuote call() throws Exception {
        return travelCompany.solicitQuote(travelInfo);
    }

    ExecutorService executor;

    public List<TravelQuote> getRankTravelQuotes(TravelInfo travelInfo, Set<TravelCompany> companies, Comparator<TravelQuote> ranking, long time, TimeUnit unit) throws InterruptedException {
        List<QuoteTask> tasks = new ArrayList<>();
        for (TravelCompany company : companies) {
            tasks.add(new QuoteTask(company, travelInfo));
        }
        List<Future<TravelQuote>> futures = executor.invokeAll(tasks, time, unit);
        List<TravelQuote> quotes=new ArrayList<TravelQuote>(tasks.size());
        Iterator<QuoteTask> taskIterator=tasks.iterator();
        for (Future<TravelQuote> f : futures) {
            QuoteTask task=taskIterator.next();
            try {
                quotes.add(f.get());
            }catch (Exception e){
//                quotes.add(task.getRankTravelQuotes(null,null,null,10,TimeUnit.SECONDS));
            }
        }
        Collections.sort(quotes, ranking);
        return quotes;
    }
}
class TravelInfo{

}
class TravelCompany{

    public TravelQuote solicitQuote(TravelInfo travelInfo) {
        return null;
    }
}

class TravelQuote{

}
