public class Cooker implements Runnable{
    String name;
    Order CurrentOrder;

    public Cooker(String name) {
        this.name = name;
        this.CurrentOrder = new Order();
    }

    public Cooker(Order currentOrder) {
        CurrentOrder = currentOrder;
    }

    void log(String msg){
        System.out.println("[Cook" + name + "]" + msg );
    }

    @Override
    public void run() {
        
    }
}
