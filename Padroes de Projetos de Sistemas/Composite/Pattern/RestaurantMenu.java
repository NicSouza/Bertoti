public class RestaurantMenu {
    public static void main(String[] args) {
 
        MenuComponent salad = new MenuItem("Salad", 5.99);
        MenuComponent soup = new MenuItem("Soup", 4.99);
        MenuComponent steak = new MenuItem("Steak", 19.99);
        MenuComponent iceCream = new MenuItem("Ice Cream", 3.99);
        MenuComponent cake = new MenuItem("Cake", 4.49);

      
        MenuComponent appetizers = new Menu("Appetizers");
        MenuComponent mainCourse = new Menu("Main Course");
        MenuComponent desserts = new Menu("Desserts");

   
        ((Menu) appetizers).add(salad);
        ((Menu) appetizers).add(soup);

        ((Menu) mainCourse).add(steak);

        ((Menu) desserts).add(iceCream);
        ((Menu) desserts).add(cake);

   
        MenuComponent mainMenu = new Menu("Restaurant Menu");
        ((Menu) mainMenu).add(appetizers);
        ((Menu) mainMenu).add(mainCourse);
        ((Menu) mainMenu).add(desserts);

     
        mainMenu.print();
    }
}
