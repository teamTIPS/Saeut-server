package saeut.error;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // Common
	BAD_REQUEST(400, "C001", "Bad Request"),
    INVALID_INPUT_VALUE(400, "C002", " Invalid Input Value"),
    HANDLE_ACCESS_DENIED(403, "C003", "Access is Denied"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    
    // Member Login
    MEMBER_NOTFOUND(404, "M001", "Member does not exist"),
    LOGIN_INPUT_INVALID(400, "M002", "Id or password do not match")

    ;
    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
    
    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}