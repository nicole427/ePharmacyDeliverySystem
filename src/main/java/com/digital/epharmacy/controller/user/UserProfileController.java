package com.digital.epharmacy.controller.user;
//Nicole Hawthorne - UserProfile Controller to expose the service of the userprofile
//on 27/10/2020 Nicole made changes to controller to include read method by userName and added validation service
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import com.digital.epharmacy.service.User.impl.UserProfileServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping ("/user")
public class UserProfileController {
    @Autowired
    private UserProfileServiceImpl userProfileService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create/")
    public ResponseEntity<UserProfile> create(@Valid @RequestBody UserProfile userProfile, BindingResult bindingResult) {
        ResponseEntity<UserProfile> errorMap = (ResponseEntity<UserProfile>) validationService.MapValidationService(bindingResult);
        if (errorMap != null) {
            return errorMap;
        }

        UserProfile newUserProfile = UserProfileFactory.createUserProfile(userProfile.getUserName(), userProfile.getUserSurname(), userProfile.getGender());
        userProfileService.create(newUserProfile);

        return new ResponseEntity<UserProfile>(userProfile, HttpStatus.CREATED);
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<?> readByUserProfileId(@PathVariable String userId) {
        UserProfile userProfile = userProfileService.read(userId);
        return  new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
    }

    @GetMapping("/name/{userProfileName}")
    public ResponseEntity<?> readByUserProfileName(@PathVariable String userName){
        UserProfile userProfile = userProfileService.readByUserProfileName(userName);

        return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
    }

    @PostMapping ("/update/")
    public UserProfile update (@Valid @RequestBody UserProfile userProfile){
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
