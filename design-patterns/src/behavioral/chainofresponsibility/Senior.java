package behavioral.chainofresponsibility;

public class Senior extends AbstractConsultant {

    public Senior() {
        this.level = 5;
    }

    @Override
    protected void advise(int level) {
        System.out.println("Senior helps to solve problem level " + level);
    }
}
