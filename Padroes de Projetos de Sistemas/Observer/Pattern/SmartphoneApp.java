public class SmartphoneApp implements TemperatureObserver {
    private String appName;

    public SmartphoneApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void updateTemperature(float temperature) {
        System.out.println(appName + " recebeu uma notificação de temperatura: " + temperature + "°C");
    }
}
