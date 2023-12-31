package com.in28minutes.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

  private UserDaoService userDaoService;

  public UserResource(UserDaoService userDaoService) {
    this.userDaoService = userDaoService;
  }

  @GetMapping("/users")
  public List<User> retrieveAllUsers() {
    return userDaoService.findAll();
  }

  @GetMapping("/users/{id}")
  public User retrieveUser(@PathVariable int id) {
    User user = userDaoService.findOne(id);

    if (user == null) {
      throw new UserNotFoundException("id: " + id);
    }

    return user;
  }

  @PostMapping("/users")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    User savedUser = userDaoService.save(user);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userDaoService.deleteById(id);
  }
}
