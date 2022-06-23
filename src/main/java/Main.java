import java.util.Vector;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Order.ClassicHam(Bread.White).toString());
        System.out.println(Order.LongBurger(Bread.Dark).toString());
        System.out.println(Order.VegieDelight(Bread.Italian).toString());
        Vector<Object> ings = new Vector<>();
        ings.add(Bread.White);
        ings.add(Meat.Beef);
        ings.add(Cheese.Cheese);
        ings.add(Additives.Cucumber);
        ings.add(Additives.Pickles);
        ings.add(Sauces.BBQ);
        Order order1 = new Order(ings);
        System.out.println(order1.isValid());
    }

}