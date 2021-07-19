package com.example.securitydemo.service;

import com.example.securitydemo.dto.AddAdminRequest;
import com.example.securitydemo.dto.AdminDetails;
import com.example.securitydemo.entities.Admin;
import com.example.securitydemo.entities.AppUser;
import com.example.securitydemo.exceptions.AdminNotFoundException;
import com.example.securitydemo.repository.IAdminRepository;
import com.example.securitydemo.repository.IUserRepository;
import com.example.securitydemo.util.AdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class AdminServiceImpl implements IAdminService{

    @Autowired
    private IAdminRepository adminRepo;

    @Autowired
    private IUserRepository userRepo;

    @Autowired
    private AdminUtil adminUtil;

    @Override
    public AdminDetails add(AddAdminRequest request) {
        AppUser user=new AppUser();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        Set<String> roles=new HashSet<>();
        roles.add("ADMIN");
        user.setRoles(roles);
        user=userRepo.save(user);
        Admin admin=new Admin();
        admin.setUser(user);
        admin=adminRepo.save(admin);
        AdminDetails desired=adminUtil.toDetails(admin);
        return desired;
    }

    @Override
    public AdminDetails findAdminDetailsById(Long id) {
       Optional<Admin> optional=adminRepo.findById(id);
        if(!optional.isPresent()){
            throw new AdminNotFoundException("admin not found for id="+id);
        }
        Admin admin=optional.get();
        return adminUtil.toDetails(admin);
    }
}
