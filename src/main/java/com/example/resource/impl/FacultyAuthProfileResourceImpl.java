package com.example.resource.impl;

import com.example.resource.IFacultyAuthProfileResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth/faculty")
public class FacultyAuthProfileResourceImpl implements IFacultyAuthProfileResource {
}
