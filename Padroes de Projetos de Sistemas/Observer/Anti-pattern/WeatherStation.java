import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<SmartphoneApp> smartphoneApps = new ArrayList<>();
    private List<DigitalDisplay> digitalDisplays = new ArrayList<>();
    private float temperature;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyAllObservers();
    }

    public void addSmartphoneApp(SmartphoneApp app) {
        smartphoneApps.add(app);
    }

    public void removeSmartphoneApp(SmartphoneApp app) {
        smartphoneApps.remove(app);
    }

    public void addDigitalDisplay(DigitalDisplay display) {
        digitalDisplays.add(display);
    }

    public void removeDigitalDisplay(DigitalDisplay display) {
        digitalDisplays.remove(display);
    }

    private void notifyAllObservers() {
        for (SmartphoneApp app : smartphoneApps) {
            app.updateTemperature(temperature);
        }
        for (DigitalDisplay display : digitalDisplays) {
            display.updateTemperature(temperature);
        }
    }
}
