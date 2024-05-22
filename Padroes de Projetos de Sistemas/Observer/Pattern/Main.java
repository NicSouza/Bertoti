public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        TemperatureObserver smartphoneApp = new SmartphoneApp("WeatherApp");
        TemperatureObserver digitalDisplay = new DigitalDisplay("Display1");

        weatherStation.addObserver(smartphoneApp);
        weatherStation.addObserver(digitalDisplay);

        System.out.println("Mudando a temperatura para 25.0°C.");
        weatherStation.setTemperature(25.0f);

        System.out.println("Mudando a temperatura para 30.0°C.");
        weatherStation.setTemperature(30.0f);

        weatherStation.removeObserver(smartphoneApp);

        System.out.println("Mudando a temperatura para 22.5°C.");
        weatherStation.setTemperature(22.5f);
    }
}
