package com.example.immolocation.Service;

import com.example.immolocation.Dao.RoleRepository;
import com.example.immolocation.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void definirRoleBd() {

        List<Role> roleList=roleRepository.findAll();
        if(roleList.isEmpty()) {
            Role role = new Role();
            role.setRole("Locataire");
            role.setDescription("Locataire");
            roleRepository.save(role);
            role.setRole("Bailleur");
            role.setDescription("Bailleur");
            roleRepository.save(role);
        }
        else if(roleList.size()==1){
            roleRepository.deleteAll();
            definirRoleBd();
        }
    }

}
