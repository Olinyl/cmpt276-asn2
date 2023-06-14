package com.asn2.asn2.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asn2.asn2.models.Student;
import com.asn2.asn2.models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentsController {

    @Autowired
    private StudentRepository userRepo;

    // Show form to add a new user
    @GetMapping("/users/add")
    public String showAddUserForm() {
        return "users/add";
    }

    // Get all users and display
    @GetMapping("/users/view")
    public String getAllUsers(Model model) {
        System.out.println("Getting all students");
        // Get all users from the database
        List<Student> users = userRepo.findAll();

        // Sort the users by UID
        users.sort(Comparator.comparingInt(Student::getUid));

        // end of database call
        model.addAttribute("us", users);
        return "users/showAll";
    }

    // Add a new user
    @PostMapping("/users/add")
    public String addUserString(@RequestParam Map<String, String> newuser, HttpServletResponse response) {
        System.out.println("ADD student");

        // Retrieve the form data
        String newName = newuser.get("name");
        int newWeight = Integer.parseInt(newuser.get("weight"));
        int newHeight = Integer.parseInt(newuser.get("height"));
        String newHairColor = newuser.get("haircolour");
        double newGPA = Double.parseDouble(newuser.get("gpa"));
        int newAge = Integer.parseInt(newuser.get("age")); // Retrieve the age
        String newGender = newuser.get("gender"); // Retrieve the gender

        // Create a new User object with the retrieved data
        Student newUser = new Student(newName, newWeight, newHeight, newHairColor, newGPA, newAge, newGender);
        // Save the new User object to the repository
        userRepo.save(newUser);
        response.setStatus(201);
        return "redirect:/users/view";
    }

    // Show form to edit a user
    @GetMapping("/users/edit/{uid}")
    public String editUserForm(@PathVariable("uid") int uid, Model model) {
        Optional<Student> optionalUser = userRepo.findById(uid);
        if (optionalUser.isPresent()) {
            Student user = optionalUser.get();
            model.addAttribute("user", user);
            return "users/edit";
        } else {
            // Handle the case when the user with the provided UID is not found
            return "redirect:/users/view";
        }
    }

    // Update user details
    @PostMapping("/users/edit")
    public String editUser(@RequestParam Map<String, String> newuser, Model model) {
        int uid = Integer.parseInt(newuser.get("uid"));
        String name = newuser.get("name");
        int weight = Integer.parseInt(newuser.get("weight"));
        int height = Integer.parseInt(newuser.get("height"));
        String hairColor = newuser.get("hair_color");
        double gpa = Double.parseDouble(newuser.get("gpa"));
        int age = Integer.parseInt(newuser.get("age"));
        String gender = newuser.get("gender");

        Optional<Student> optionalUser = userRepo.findById(uid);
        if (optionalUser.isPresent()) {
            Student user = optionalUser.get();
            // Update the user details
            user.setName(name);
            user.setWeight(weight);
            user.setHeight(height);
            user.setHaircolour(hairColor);
            user.setGpa(gpa);
            user.setAge(age);
            user.setGender(gender);
            // Save Updated user details to repository
            userRepo.save(user);

            // Get all users from the database
            List<Student> users = userRepo.findAll();
            model.addAttribute("us", users);

            return "redirect:/users/view"; // Redirect to the "view" endpoint
        } else {
            // Handle the case when the user with the provided UID is not found
        }
        return "redirect:/users/view";
    }

    // Delete a user
    @PostMapping("/users/delete/{uid}")
    public String deleteUser(@PathVariable("uid") int uid) {
        Optional<Student> optionalUser = userRepo.findById(uid);
        if (optionalUser.isPresent()) {
            Student user = optionalUser.get();
            userRepo.delete(user); // Delete the user from repository
        } else {
            // Handle when the user is not found
        }
        return "redirect:/users/view";
    }

}
