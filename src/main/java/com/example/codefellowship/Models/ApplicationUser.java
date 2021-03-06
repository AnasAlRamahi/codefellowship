package com.example.codefellowship.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique= true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String bio;
    @OneToMany(mappedBy = "applicationUser")
    private List<Post> posts;

    public ApplicationUser() {

    }

    @ManyToMany
    @JoinTable(name = "follow",
            joinColumns = {@JoinColumn(name = "followingUserId")},
            inverseJoinColumns = {@JoinColumn(name = "followedUserId")}
    )
    private Set<ApplicationUser> followingUser;

    @ManyToMany(mappedBy = "followingUser")
    private Set<ApplicationUser> followedUser;

    public ApplicationUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    public Set<ApplicationUser> getFollowingUser() {
        return followingUser;
    }

    public Set<ApplicationUser> getFollowedUser() {
        return followedUser;
    }

    public Integer getId() {
        return id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void addFollower(ApplicationUser applicationUser){
        followingUser.add(applicationUser);
    }

}
