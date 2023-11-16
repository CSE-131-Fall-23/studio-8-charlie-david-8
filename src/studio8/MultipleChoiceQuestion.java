package studio8;

public class MultipleChoiceQuestion extends Question {
	
	private String[] choices;
	
	public MultipleChoiceQuestion(String prompt, String answer, int points, String[] choices) {
		super(prompt,answer,points);
		this.choices=choices;
	}
	
	public char select(int index)
	{
		switch(index)
		{
			case 0: return 'A';
			case 1: return 'B';
			case 2: return 'C';
			case 3: return 'D';
			case 4: return 'E';
			case 5: return 'F';
		}
		return 'G';
	}
	
	public void displayPrompt() {
		super.displayPrompt();
		for (int i=0; i<choices.length; i++)
		{
			System.out.println(select(i)+". "+choices[i]);
		}
	}
	
	public static void main(String[] args) {
		String[] choices = {"seven", "nine", "eight", "six"};
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "C", 1, choices);
		multipleChoice.displayPrompt();
		System.out.println(multipleChoice.checkAnswer("hi"));//wrong
		System.out.println(multipleChoice.checkAnswer("A"));//wrong
		System.out.println(multipleChoice.checkAnswer("C"));//right
	}

}
