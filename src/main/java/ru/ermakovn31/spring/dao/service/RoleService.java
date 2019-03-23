package ru.ermakovn31.spring.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ermakovn31.spring.dao.repository.IRoleRepository;
import ru.ermakovn31.spring.model.Role;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role getDefault() {
        return roleRepository.getDefault();
    }
}
