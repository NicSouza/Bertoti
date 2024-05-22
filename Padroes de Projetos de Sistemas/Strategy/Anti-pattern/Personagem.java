public class Personagem {
    public static final int CORPO_A_CORPO = 1;
    public static final int DISTANCIA = 2;
    public static final int MAGICO = 3;

    private int tipoAtaque;

    public void setTipoAtaque(int tipoAtaque) {
        this.tipoAtaque = tipoAtaque;
    }

    public void atacar() {
        switch (tipoAtaque) {
            case CORPO_A_CORPO:
                System.out.println("Executando ataque corpo a corpo!");
                break;
            case DISTANCIA:
                System.out.println("Executando ataque à distância!");
                break;
            case MAGICO:
                System.out.println("Executando ataque mágico!");
                break;
            default:
                System.out.println("Nenhum tipo de ataque definido!");
        }
    }
}
