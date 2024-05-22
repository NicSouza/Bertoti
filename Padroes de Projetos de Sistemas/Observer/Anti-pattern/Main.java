public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        SmartphoneApp smartphoneApp = new SmartphoneApp("WeatherApp");
        DigitalDisplay digitalDisplay = new DigitalDisplay("Display1");

        weatherStation.addSmartphoneApp(smartphoneApp);
        weatherStation.addDigitalDisplay(digitalDisplay);

        System.out.println("Mudando a temperatura para 25.0°C.");
        weatherStation.setTemperature(25.0f);

        System.out.println("Mudando a temperatura para 30.0°C.");
        weatherStation.setTemperature(30.0f);

        weatherStation.removeSmartphoneApp(smartphoneApp);

        System.out.println("Mudando a temperatura para 22.5°C.");
        weatherStation.setTemperature(22.5f);
    }
}

