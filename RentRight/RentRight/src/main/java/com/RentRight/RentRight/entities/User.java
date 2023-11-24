package com.RentRight.RentRight.entities;

import java.util.Collection;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class User implements UserDetails{
    public User(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.CPF = user.getCPF();
        this.password = user.getPassword();

    }

    @Id @GeneratedValue( strategy = GenerationType.AUTO)
    
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @CPF
    private String CPF;

    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
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
    
}
