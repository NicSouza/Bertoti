public class Personagem {
    private Estrategia estrategia;

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public void atacar() {
        if (estrategia != null) {
            estrategia.executarAtaque();
        } else {
            System.out.println("Nenhuma estratégia de ataque definida!");
        }
    }
}
