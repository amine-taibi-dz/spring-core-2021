package dz.acs.spring.mail;

public class BasicSpellChecker implements SpellChecker {

	@Override
	public String suggest(String content) {
		
		return String.format("!####### Basic \n %s\n ######! ", content);
	}

}
