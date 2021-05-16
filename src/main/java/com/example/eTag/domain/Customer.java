package com.example.eTag.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


/**
 * @author Khairul Islam Azam
 * @since 1.0
 */

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private String notificationMessage;
    private Double balance;

}
