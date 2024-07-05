package com.code.salesappbackend.services.impls;

import com.code.salesappbackend.models.User;
import com.code.salesappbackend.services.interfaces.BaseService;
import com.code.salesappbackend.services.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    public UserServiceImpl(BaseService<User, Long> repository) {
        super(repository, User.class);
    }
}
