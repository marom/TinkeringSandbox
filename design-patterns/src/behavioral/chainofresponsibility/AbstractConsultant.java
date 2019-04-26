package behavioral.chainofresponsibility;

public abstract class AbstractConsultant {

    protected int level;

    protected AbstractConsultant nextConsultant;

    public void setNextConsultant(AbstractConsultant nextConsultant) {
        this.nextConsultant = nextConsultant;
    }

    public void giveAdvice(int level) {

        if (this.level >= level) {
            advise(level);
        } else {
            nextConsultant.giveAdvice(level);
        }
    }

    abstract protected void advise(int level);
}
