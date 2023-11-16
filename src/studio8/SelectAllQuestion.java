package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {

	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		super(prompt,answer,choices.length,choices);
	}
	
	public int checkAnswer(String givenAnswer) {
		int shouldChoose=super.getAnswer().length(), shouldNotChoose=super.getPoints()-shouldChoose, chosen=0, chosenWrong=0;
		for (int i=0; i<givenAnswer.length(); i++)
		{
			if (super.getAnswer().contains(givenAnswer.charAt(i)+"")) chosen++;
			else chosenWrong++;
		}
		int credit = super.getPoints()-(shouldChoose-chosen)-chosenWrong;
		if (credit<0) return 0;
		return credit;
	}
	
	public static void main(String[] args) {
		String[] choices = {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "AC", choices);
		selectAll.displayPrompt();
		System.out.println(selectAll.checkAnswer("hi")); //no credit
		System.out.println(selectAll.checkAnswer("AC")); //full credit
		System.out.println(selectAll.checkAnswer("CA")); //full credit
		System.out.println(selectAll.checkAnswer("A")); //3 points
		System.out.println(selectAll.checkAnswer("C")); //3 points
		System.out.println(selectAll.checkAnswer("BC")); //2 points
		System.out.println(selectAll.checkAnswer("CD")); //2 points
		System.out.println(selectAll.checkAnswer("D")); //1 point
		System.out.println(selectAll.checkAnswer("ABD")); //1 point
		System.out.println(selectAll.checkAnswer("BD")); //0 points
		
	}
}
