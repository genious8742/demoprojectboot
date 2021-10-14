package springboot.springbootproject.RestController;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import antlr.collections.List;


@RestController
@RequestMapping("/api/av1")
public class UserController<User, user> {
	
	@Autowired
private CrudRepository userRepository;

@GetMapping("users")
	
	public List getAllUsers(){
		
		return (List) userRepository.findAll();
		
	}

@SuppressWarnings("unchecked")
@GetMapping("/users/{id}")
public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
    throws Throwable {
  User user =  (User) userRepository.findById(userId).orElseThrow(() -> new AttributeNotFoundException("User not found on :: " + userId));
  return ResponseEntity.ok().body(user);
}
@GetMapping("/users")
public User createuser(@Validated @RequestBody User user) { 
return (User) userRepository.save(user);
}

/*
 * @PutMapping("/users/{id}") public ResponseEntity<User> updateUser(
 * 
 * @PathVariable(value = "id") Long userId, @Validated @RequestBody User
 * userDetails) throws AttributeNotFoundException {
 * 
 * User user = (User) userRepository .findById(userId).orElseThrow(() -> new
 * AttributeNotFoundException("User not found on :: " + userId));
 * 
 * user.setEmail(userDetails.getEmail());
 * user.setLastName(userDetails.getLastName());
 * user.setFirstName(userDetails.getFirstName()); user.setUpdatedAt(new Date());
 * final User updatedUser = (User) userRepository.save(user); return
 * ResponseEntity.ok(updatedUser);
 * 
 * }
 */
 @DeleteMapping("/user/{id}")
public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Throwable {
  User user =
      (User) userRepository
      .findById(userId)
      .orElseThrow(() -> new AttributeNotFoundException("User not found on :: " + userId));

  userRepository.delete(user);
  Map<String, Boolean> response = new HashMap<>();
  response.put("deleted", Boolean.TRUE);
  return response;
}
}