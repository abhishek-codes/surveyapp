package com.abhi.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.survey.config.JwtUtil;
import com.abhi.survey.dto.AuthenticationRequest;
import com.abhi.survey.dto.AuthenticationResponse;
import com.abhi.survey.model.User;
import com.abhi.survey.service.MyUserDetailService;
import com.abhi.survey.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    
    @PostMapping(value="/register")
    public ResponseEntity<Integer> postNewUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser.getUserId(),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmailId(), request.getPassword()));
        } 
        catch(UsernameNotFoundException e){
            throw new UsernameNotFoundException(e.getMessage());
        }
        catch (Exception e) {
            throw new RuntimeException("Invalid Credentials");
        }
        UserDetails userDetails = myUserDetailService.loadUserByUsername(request.getEmailId());
        String token = "Bearer "+ jwtUtil.createToken(userDetails);
        return new ResponseEntity<>(new AuthenticationResponse(token),HttpStatus.OK);
    }
    
}
