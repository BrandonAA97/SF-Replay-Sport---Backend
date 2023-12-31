package SFRS.SF_Replay_Sport.auth.User;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "\"users\"", uniqueConstraints = {@UniqueConstraint(columnNames = {"Username"})})
public class User implements UserDetails, GrantedAuthority{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(nullable = false)
    String username;
    String password;
    String email;
    @Enumerated(EnumType.STRING)
    Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority((role.name())));
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
    @Override
    public String getAuthority(){
        return role.name();
    }
}
