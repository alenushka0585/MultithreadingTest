import java.util.List;

public class SetNewNumberRunnable implements Runnable {
    private List<Integer> list;

    public SetNewNumberRunnable(List<Integer> list){
        this.list = list;
    }

    @Override
    public  void run() {
        synchronized (list) {
            try {
                list.wait(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int newNumber = 10;
            for (int i = 0; i < 10; i++) {
                setNewNumber(list, i, newNumber);
                newNumber++;
                System.out.println("set number: " + list.get(i));
            }
        }
    }

     public synchronized void setNewNumber(List<Integer> list, int index, int number){
        list.set(index, number);
    }
}
