package behavioral.chainofresponsibility;

public class Expert extends AbstractConsultant {

    public Expert() {
        this.level = 7;
    }

    @Override
    protected void advise(int level) {
        System.out.println("Expert helps to solve problem level " + level);
    }
}
