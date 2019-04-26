package behavioral.chainofresponsibility;

public class RegularDeveloper extends AbstractConsultant {

    public RegularDeveloper() {
        this.level = 2;
    }

    @Override
    protected void advise(int level) {
        System.out.println("RegularDeveloper helps to solve problem level " + level);
    }
}
