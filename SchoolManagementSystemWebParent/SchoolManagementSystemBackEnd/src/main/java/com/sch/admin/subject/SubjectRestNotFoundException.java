package com.sch.admin.subject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//specify http response error message in case brand not found
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Subject not found")
public class SubjectRestNotFoundException extends Exception {

}
