import java.util.List;

public class AddNumberThread extends Thread {
    private List<Integer> list;

    public AddNumberThread(List<Integer> list){
        this.list = list;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            addNumber(list, i);
            System.out.println("add number: " + list.get(i));
        }
    }

     public synchronized void addNumber(List<Integer> list, int number){
        list.add(number);
    }
}
