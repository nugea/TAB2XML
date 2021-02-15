package TAB2XML;

public class Bass extends StringInstrument
{
	//private char type; //number of strings
	//private String this.getStr1(), this.getStr2(), this.getStr3(), this.getStr4(), this.getStr5();
	private Bass()
	{
		super();
	}
	
	private Bass(String s1, String s2, String s3, String s4)
	{	
		super(s1, s2, s3, s4);
	//	this.type = '4';
	//	this.this.getStr1() = this.getStr1();
	//	this.this.getStr2() = this.getStr2();
	//	this.this.getStr3() = this.getStr3();
	//	this.this.getStr4() = this.getStr4();
	}
	
	private Bass(String s1, String s2, String s3, String s4, String s5)
	{
		super(s1, s2, s3, s4, s5);	
	//	this.this.getStr1() = this.getStr1();
	//	this.this.getStr2() = this.getStr2();
	//	this.this.getStr3() = this.getStr3();
	//	this.this.getStr4() = this.getStr4();
	//	this.this.getStr5() = this.getStr5();
	//	this.type = '5';
	}
	
	public static Bass getInstance(String s1, String s2, String s3, String s4)
	{
		return new Bass(s1, s2, s3, s4);
	}
	
	public static Bass getInstance(String s1, String s2, String s3, String s4, String s5)
	{
		return new Bass(s1, s2, s3, s4, s5);	
	}
	
	public void printTab()
	{		         
		for (int i = 2 ; this.getStr1().charAt(i) != '|' ; i++)
		{
			if (Character.isDigit(this.getStr1().charAt(i)))
				System.out.println("String = 1 Fret = " + this.getStr1().charAt(i) + " Note: " + Notes.bassNotes("note1",Character.getNumericValue(this.getStr1().charAt(i))));
			
			if (Character.isDigit(this.getStr2().charAt(i)))
				System.out.println("String = 2 Fret = " + this.getStr2().charAt(i) + " Note: " + Notes.bassNotes("note2",Character.getNumericValue(this.getStr2().charAt(i))));
			
			if (Character.isDigit(this.getStr3().charAt(i)))
				System.out.println("String = 3 Fret = " + this.getStr3().charAt(i) + " Note: " + Notes.bassNotes("note3",Character.getNumericValue(this.getStr3().charAt(i))));
			
			if (Character.isDigit(this.getStr4().charAt(i)))
				System.out.println("String = 4 Fret = " + this.getStr4().charAt(i) + " Note: " + Notes.bassNotes("note4",Character.getNumericValue(this.getStr4().charAt(i))));
			
			if (this.getStr5() != null && Character.isDigit(this.getStr5().charAt(i)))
				System.out.println("String = 4 Fret = " + this.getStr5().charAt(i) + " Note: " + Notes.bassNotes("note5",Character.getNumericValue(this.getStr5().charAt(i))));
		}
	}
		
}