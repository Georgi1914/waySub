import java.util.Arrays;
import java.util.Vector;

enum Bread{White, Dark, Italian}
enum Meat{Chicken, Pork, Beef}
enum Additions{Tomato, Pepper, Olives, Onion, Cucumber, Iceberg, Pickles}
enum Sauces{Ketchup, Mayo, BBQ, Ranch}

public class Order {
    static int id_count = 0;
    int id;
    private Vector<String> ingredients;
    Vector<String> requirements;

    public Order() {
        ingredients = new Vector<>();
        requirements = new Vector<>();
        id_count++;
        id = id_count;
    }

    boolean isValid(){
        for(int i = 0; i < ingredients.size(); i++){
            boolean vegan = false;
            switch (i){
                case 0:
                    if(ingredients.get(i).equals(Bread.White.toString()) ||
                        ingredients.get(i).equals(Bread.Dark.toString()) ||
                        ingredients.get(i).equals(Bread.Italian.toString())){
                        break;
                    }else{
                        return false;
                    }
                case 1:
                        if(ingredients.get(i).equals(Meat.Beef.toString()) ||
                                ingredients.get(i).equals(Meat.Pork.toString()) ||
                                ingredients.get(i).equals(Meat.Chicken.toString())
                                ){
                            if(ingredients.get(i + 1).equals("Cheese") ||
                                    ingredients.get(i + 1).equals("Processed Cheese")) {
                                i++;
                                break;
                            }
                        }else if(ingredients.get(i).equals("Cheese") ||
                                ingredients.get(i).equals("Processed Cheese")){
                            vegan = true;
                            i += 2;
                            break;
                        }else{
                            return false;
                        }
                case 3:
                    for(int j = i; j)
                    }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ingredients=" + ingredients +
                '}';
    }

    public static Order ClassicHam(Bread bread) throws InterruptedException {
        return PreDoneSand(new String[]{bread.toString(), "Ham", "Cheese", "Tomato", "Onion", "Cucumber", "Mayo"});
    }

    public static Order LongBurger(Bread bread) throws InterruptedException {
        return PreDoneSand(new String[]{bread.toString(), "Beef", "Processed Cheese", "Iceberg", "Pickles", "Cucumber", "BBQ"});
    }

    public static Order VegieDelight(Bread bread) throws InterruptedException {
        return PreDoneSand(new String[]{bread.toString(), "Cheese", "Iceberg", "Olives", "Tomato", "Ranch"});
    }

    private static Order PreDoneSand(String []ings) throws InterruptedException {
        Order order = new Order();

        Thread.sleep(1500);
        order.ingredients.add(ings[0]);

        Arrays.stream(ings)
                .skip(1)
                .forEach((i) -> {
                    try {
                        Thread.sleep(1200);
                        if (i.equals("Cheese"))
                            Thread.sleep(2500);
                        order.ingredients.add(i);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        return order;
    }
}
