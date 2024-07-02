package com.code.salesappbackend.services.impls;

import com.code.salesappbackend.exceptions.DataExistsException;
import com.code.salesappbackend.models.Size;
import com.code.salesappbackend.models.User;
import com.code.salesappbackend.repositories.SizeRepository;
import com.code.salesappbackend.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    public UserServiceImpl(JpaRepository<User, Long> repository) {
        super(repository);
    }
}
