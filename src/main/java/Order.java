import java.util.Arrays;
import java.util.Vector;

enum Bread{White, Dark, Italian}
enum Meat{Chicken, Pork, Beef}
enum Cheese{Cheese, Processed_Cheese}
enum Additives{Tomato, Pepper, Olives, Onion, Cucumber, Iceberg, Pickles}
enum Sauces{Ketchup, Mayo, BBQ, Ranch}

public class Order {
    static int id_count = 0;
    int id;
    private Vector<Object> ingredients;
    Vector<String> requirements;

    public Order() {
        ingredients = new Vector<>();
        requirements = new Vector<>();
        id_count++;
        id = id_count;
    }

    public Order(Vector<Object> ingredients) {
        this.ingredients = ingredients;
        id_count++;
        id = id_count;
    }

    public Order(Vector<Object> ingredients, Vector<String> requirements) {
        this.ingredients = ingredients;
        this.requirements = requirements;
        id_count++;
        id = id_count;
    }

    boolean isValid(){
        if(ingredients.get(0).getClass() != Bread.class){
            return false;
        }

        boolean vegan = false;

        if(ingredients.get(1).getClass() != Meat.class && ingredients.get(1).getClass() != Cheese.class){
            return false;
        }
        if(ingredients.get(1).getClass() == Cheese.class){
            vegan = true;
        }else if(ingredients.get(1).getClass() == Meat.class && ingredients.get(2).getClass() != Cheese.class){
            return false;
        }

        int i = 2;
        if(!vegan)
            i++;
        
        int countCorrIngs = 0;
        for(int j = i; j < i + 3; j++){
            if(ingredients.get(j).getClass() == Additives.class){
                countCorrIngs++;
            }
        }
        if(countCorrIngs == 0){
            return false;
        }
        for(int j = i + countCorrIngs; j < ingredients.size(); j++){
            if(ingredients.get(j).getClass() != Sauces.class){
                return false;
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
        order.ingredients.add(ings[0]);

        Arrays.stream(ings)
                .skip(1)
                .forEach((i) -> {
                        order.ingredients.add(i);
                });
        return order;
    }
}
