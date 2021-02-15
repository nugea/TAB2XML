package TAB2XML;

public class Notes {
	final static String[] noteBass1 = {"G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G"};
	final static String[] noteBass2 = {"D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D"};
	final static String[] noteBass3 = {"A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A"};
	final static String[] noteBass4 = {"E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E"};
	final static String[] noteBass5 = {"B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"};
	
	public static String bassNotes(String line, int pos) {
		if(line == "note1") {
			return noteBass1[pos];
		}
		else if(line == "note2") {
			return noteBass2[pos];
		}
		else if(line == "note3") {
			return noteBass3[pos];
		}
		else if(line == "note4") {
			return noteBass4[pos];
		}
		else {
			return noteBass5[pos];
			}
		}
}