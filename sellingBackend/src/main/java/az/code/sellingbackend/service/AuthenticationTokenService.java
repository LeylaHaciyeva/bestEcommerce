package az.code.sellingbackend.service;

import az.code.sellingbackend.entity.Token;
import az.code.sellingbackend.entity.User;
import az.code.sellingbackend.repo.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthenticationTokenService  implements UserDetailsService {
    @Autowired
    TokenRepository tokenRepository;
    public void saveConfirmationToken(Token authenticationToken){
        tokenRepository.save(authenticationToken);
    }
    public Token getToken(User user){
     return   tokenRepository.findByUser(user);
    }

    public User getUser(String token ){
        final Optional<Token> authenticationToken=tokenRepository.findByToken(token);
        if(Objects.isNull(token)){
            return null;
        }
        return authenticationToken.get().getUser();
    }
    public void authentication(String token ) throws Exception {
        if(Objects.isNull(token)){
            throw new Exception("token not present");
        }
        if(Objects.isNull(getUser(token))){
            new Exception("token not present");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
