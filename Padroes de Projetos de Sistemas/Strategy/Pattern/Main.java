public class Main {
    public static void main(String[] args) {
        Personagem personagem = new Personagem();

        // Definindo a estratégia como Ataque Corpo a Corpo
        personagem.setEstrategia(new AtaqueCorpoACorpo());
        personagem.atacar();

        // Mudando a estratégia para Ataque à Distância
        personagem.setEstrategia(new AtaqueADistancia());
        personagem.atacar();

        // Mudando a estratégia para Ataque Mágico
        personagem.setEstrategia(new AtaqueMagico());
        personagem.atacar();
    }
}
