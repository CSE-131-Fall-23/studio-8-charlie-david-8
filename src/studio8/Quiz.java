package studio8;

import java.util.Scanner;

public class Quiz {

	private Question[] questions;
	
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	private String getUserAnswer() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	public int getTotalPoints() {
		int sum = 0;
		for(Question q : questions) {
			sum += q.getPoints();
		}
		return sum;
	}
	
	public void takeQuiz() {
		int credit=0;
		for (int i=0; i<questions.length; i++)
		{
			questions[i].displayPrompt();
			int point=questions[i].checkAnswer(getUserAnswer());
			System.out.println("Your point: "+point);
			credit+=point;
			System.out.println();
		}
		int totalCredit=this.getTotalPoints();
		System.out.println("Total credit available: "+totalCredit);
		System.out.println("Credit earned: "+credit);
		int score = (int)(credit*1.0/totalCredit*100);
		System.out.println("Your score: " + score);
		if (score>90) System.out.println("Good!");
		else System.out.println("You suck ;)");
	}
	
	public static void main(String[] args) {
		Question q = new Question("What number studio is this?", "8", 2);

		String[] choices = {"seven", "nine", "eight", "six"};
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "C", 1, choices);

		choices = new String[] {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "AC", choices);

		Question[] questions = {q, multipleChoice, selectAll}; //create and add more questions!
		
		Quiz studio8quiz = new Quiz(questions);
		studio8quiz.takeQuiz();
	}
}
