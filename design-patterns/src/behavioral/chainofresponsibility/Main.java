package behavioral.chainofresponsibility;

public class Main {


    public static void main(String[] args) {

        AbstractConsultant developer = new RegularDeveloper();
        AbstractConsultant senior = new Senior();
        AbstractConsultant expert = new Expert();

        developer.setNextConsultant(senior);
        senior.setNextConsultant(expert);

        System.out.println("--- ProblemLevel = NORMAL ---");
        ProblemLevel difficultLevel = ProblemLevel.NORMAL;
        developer.giveAdvice(difficultLevel.value());

        System.out.println("--- ProblemLevel = DIFFICULT ---");
        difficultLevel = ProblemLevel.DIFFICULT;
        developer.giveAdvice(difficultLevel.value());

        System.out.println("--- ProblemLevel = INSANE ---");
        difficultLevel = ProblemLevel.INSANE;
        developer.giveAdvice(difficultLevel.value());
    }
}
