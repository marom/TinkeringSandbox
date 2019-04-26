package behavioral.observer;

public class Fan implements Observer {

    private String schedule;
    private int fanId;

    public static int observerId = 0;
    private Subject fanPage = null;

    public Fan(Subject fanPage) {
        this.fanPage = fanPage;
        this.fanId = ++observerId;
        fanPage.addObserver(this);
    }

    @Override
    public void update(String schedule) {
        this.schedule = schedule;
        setOwnSchedule();
    }

    private void setOwnSchedule() {
        System.out.println("Fan with Id " + this.fanId + " sets Schedule: " + this.schedule);
    }

    public void unsubscribe() {
        this.fanPage.removeObserver(this);
    }
}
