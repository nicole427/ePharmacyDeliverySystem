package com.digital.epharmacy.controller.user;
//Nicole Hawthorne - UserProfile Controller to expose the service of the userprofile
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import com.digital.epharmacy.service.User.UserProfileService;
import com.digital.epharmacy.service.User.impl.UserProfileServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping ("/user")
public class UserProfileController {
    @Autowired
    private UserProfileServiceImpl userProfileService;

@PostMapping ("/create")
public UserProfile create (@RequestBody UserProfile userProfile){
    UserProfile newUserProfile = UserProfileFactory.createUserProfile(userProfile.getUserName(),userProfile.getUserSurname(),userProfile.getGender());
      return userProfileService.create(newUserProfile);
    }
    @GetMapping ("/read/{userId}")
    public UserProfile read (@PathVariable String userId){
    return userProfileService.read(userId);
    }
    @PostMapping ("/update")
    public UserProfile update (@RequestBody UserProfile userProfile){
    return userProfileService.update(userProfile);
    }

    @GetMapping("/all")
    public Set<UserProfile>getall(){
    return userProfileService.getAll();
    }
    @DeleteMapping ("/delete/{userId}")
    public boolean delete(@PathVariable String userId){
    return userProfileService.delete(userId);
    }
}
