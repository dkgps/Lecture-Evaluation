package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("tlsdkgps","dkgus^^7");
		// 관리자의 구글 아이디, 비밀번호
	}
}
