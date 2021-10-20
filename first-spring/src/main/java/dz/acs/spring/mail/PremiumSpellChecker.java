package dz.acs.spring.mail;

public class PremiumSpellChecker implements SpellChecker {
	@Override
	public String suggest(String content) {
		
		return String.format("!####### Premium \n %s\n ######! ", content);
	}

}
