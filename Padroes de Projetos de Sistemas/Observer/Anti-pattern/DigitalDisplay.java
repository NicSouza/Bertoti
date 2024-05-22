public class DigitalDisplay implements TemperatureObserver {
    private String displayId;

    public DigitalDisplay(String displayId) {
        this.displayId = displayId;
    }

    @Override
    public void updateTemperature(float temperature) {
        System.out.println("Display " + displayId + " atualizado: Temperatura atual é " + temperature + "°C");
    }
}
