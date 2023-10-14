package com.university.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.auth.exception.UserNotAuthorizedException;
import com.university.auth.model.AuthRequest;
import com.university.auth.model.AuthResponse;
import com.university.auth.model.User;
import com.university.auth.model.UserRole;
import com.university.auth.service.JwtService;
import com.university.auth.service.UserInfoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private UserInfoService userInfoService;
 
    @Autowired
    private JwtService jwtService;
    
    String adminRole = UserRole.USER_ADMIN.name();
 
	@GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }
 
    @PostMapping("/addNewUser")
    public ResponseEntity<User> addNewUser(@RequestBody User userInfo) {
        return ResponseEntity.ok(userInfoService.addUser(userInfo));
    }
	
    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }
 
    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('USER_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }
    
    @PostMapping("/generateToken")
    public ResponseEntity<AuthResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(authRequest.getUserName());
            AuthResponse response = new AuthResponse(token);
            String userRole = userInfoService.getRole(authRequest.getUserName());
            response.setUserRole(userRole);
            return ResponseEntity.ok(response);
        } else {
            throw new UsernameNotFoundException("Invalid user request !");
        }
    }
	
	@ExceptionHandler(value = UserNotAuthorizedException.class)
    public ResponseEntity<String> handleBlogAlreadyExistsException(UserNotAuthorizedException userNotAuthorized) {
        return new ResponseEntity<>("User Not Authorized", HttpStatus.FORBIDDEN);
    }
	
	
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleAllException(Exception userNotAuthorized) {
        return new ResponseEntity<>("There is some issue with the request", HttpStatus.BAD_REQUEST);
    }
	
}
