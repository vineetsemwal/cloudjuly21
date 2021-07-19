package com.example.securitydemo.service;

import com.example.securitydemo.dto.AddAdminRequest;
import com.example.securitydemo.dto.AdminDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface IAdminService {

    AdminDetails add(@Valid @NotNull AddAdminRequest request);

    AdminDetails findAdminDetailsById(@NotNull Long id);

}
