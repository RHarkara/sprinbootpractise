package com.springboot.practice.error;

public class DepartmentNotFountException extends Exception {
	
		public DepartmentNotFountException() {
			super();
		}
		
		public DepartmentNotFountException(String message) {
			super(message);
		}
		
		public DepartmentNotFountException(Throwable cause) {
			super(cause);
		}
		
		public DepartmentNotFountException(String message, Throwable cause) {
			super(message,cause);
		}
		

}
