package com.example.resource.impl;

import com.example.resource.IAdminAuthProfileResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth/admin")
public class AdminAuthProfileResourceImpl implements IAdminAuthProfileResource {
}
