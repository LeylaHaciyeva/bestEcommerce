package az.code.sellingbackend.service;

import az.code.sellingbackend.dto.SignupDto;
import az.code.sellingbackend.entity.User;
import az.code.sellingbackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void signup(SignupDto signupDto) throws Exception {

    }


}
