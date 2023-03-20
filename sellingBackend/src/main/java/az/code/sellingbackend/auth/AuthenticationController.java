package az.code.sellingbackend.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping(value = "/register",consumes = MediaType.ALL_VALUE)
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        System.out.println(request);
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping(value="/authenticate",consumes = MediaType.ALL_VALUE)
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        System.out.println("auth"+request);

        return ResponseEntity.ok(service.authenticate(request));
    }


}
