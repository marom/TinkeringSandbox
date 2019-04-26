package behavioral.observer;

import java.util.ArrayList;

public class FanPage implements Subject {

    private ArrayList<Observer> observers;
    private String schedule;

    public FanPage() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);

    }

    @Override
    public void notifyObserver() {
        observers.forEach(o -> o.update(schedule));
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
        notifyObserver();
    }
}
