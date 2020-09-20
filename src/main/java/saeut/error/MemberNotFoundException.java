package saeut.error;

public class MemberNotFoundException extends BusinessException {
	
	public MemberNotFoundException(String message) {
		super(message, ErrorCode.MEMBER_NOTFOUND);
	}

}
