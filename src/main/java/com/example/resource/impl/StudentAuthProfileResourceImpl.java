package com.example.resource.impl;

import com.example.resource.IStudentAuthProfileResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth/student")
public class StudentAuthProfileResourceImpl implements IStudentAuthProfileResource {
}
