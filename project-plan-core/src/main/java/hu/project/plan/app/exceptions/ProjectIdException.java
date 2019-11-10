package hu.project.plan.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException{

	private static final long serialVersionUID = -3751225138256041556L;

	public ProjectIdException(String message) {
		super(message);
	}

	
}
