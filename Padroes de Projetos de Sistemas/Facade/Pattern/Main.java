public class Main {
    public static void main(String[] args) {
        CafeteriaFacade cafeteriaFacade = new CafeteriaFacade();
        
        // Realizar um pedido de 2 cafés por R$10,00 cada
        cafeteriaFacade.realizarPedido("Café", 2, 20.00);
        
        // Tentar realizar um pedido de 6 bolos por R$15,00 cada (deve falhar por falta de estoque)
        cafeteriaFacade.realizarPedido("Bolo", 6, 90.00);
        
        // Realizar um pedido de 1 bolo por R$15,00
        cafeteriaFacade.realizarPedido("Bolo", 1, 15.00);
    }
}
