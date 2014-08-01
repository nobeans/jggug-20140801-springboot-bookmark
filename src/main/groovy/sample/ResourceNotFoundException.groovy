package sample

import groovy.transform.InheritConstructors
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@InheritConstructors
public class ResourceNotFoundException extends RuntimeException {
}
