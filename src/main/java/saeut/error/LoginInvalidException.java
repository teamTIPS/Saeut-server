package saeut.error;

public class LoginInvalidException extends BusinessException {
	
	public LoginInvalidException(String message) {
		super(message, ErrorCode.LOGIN_INPUT_INVALID);
	}

}