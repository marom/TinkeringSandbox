package behavioral.observer;

public class Main {

    public static void main(String[] args) {

        FanPage fanPage = new FanPage();

        Fan fan1 = new Fan(fanPage);
        Fan fan2 = new Fan(fanPage);

        System.out.println("FanPage sets their new schedule");
        fanPage.setSchedule("End of February");

        fanPage.removeObserver(fan1);

        System.out.println("FanPage sets their new schedule");
        fanPage.setSchedule("Beginning of March");

        fan2.unsubscribe();

        System.out.println("FanPage sets their new schedule");
        fanPage.setSchedule("End of March");
    }
}
