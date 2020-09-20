package saeut.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	
	// 존재하지 않은 회원을 호출한 경우
	@ExceptionHandler(MemberNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleMemberNotFoundException(MemberNotFoundException e) {
        log.error("handleHemberNotFoundException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.MEMBER_NOTFOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	// ID 또는 Password가 유효하지 않은 경우
	@ExceptionHandler(LoginInvalidException.class)
    protected ResponseEntity<ErrorResponse> handleLoginInvalidException(LoginInvalidException e) {
        log.error("handleLoginInvalidException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.LOGIN_INPUT_INVALID);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
	
	// 공통 에러처리
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleCommonException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}