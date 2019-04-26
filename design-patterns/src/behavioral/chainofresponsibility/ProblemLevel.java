package behavioral.chainofresponsibility;

public enum ProblemLevel {

    EASY(1), NORMAL(2), COMPLEX(3), DIFFICULT(4), HARD(5), VERYHARD(6), INSANE(7);
    private int value;

    ProblemLevel(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
