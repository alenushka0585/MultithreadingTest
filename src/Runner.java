import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Runner {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new Vector<>();

        Thread addNumber = new AddNumberThread(list);
        Thread setNewNumber = new Thread(new SetNewNumberRunnable(list));
        Callable<String> callable = new ReadNumberCallable(list);
        FutureTask futureTask = new FutureTask(callable);

        addNumber.start();
        Thread readNumber = new Thread(futureTask);
        readNumber.start();
        setNewNumber.start();
    }
}
