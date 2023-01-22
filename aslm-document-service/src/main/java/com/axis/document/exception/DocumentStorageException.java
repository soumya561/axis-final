package com.axis.document.exception;

public class DocumentStorageException extends RuntimeException {
    

	private static final long serialVersionUID = 2806913935594753704L;

	public DocumentStorageException(String message) {
        super(message);
    }

    public DocumentStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
