import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<TemperatureObserver> observers = new ArrayList<>();
    private float temperature;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyAllObservers();
    }

    public void addObserver(TemperatureObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TemperatureObserver observer) {
        observers.remove(observer);
    }

    private void notifyAllObservers() {
        for (TemperatureObserver observer : observers) {
            observer.updateTemperature(temperature);
        }
    }
}
