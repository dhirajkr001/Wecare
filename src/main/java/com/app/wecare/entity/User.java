package com.app.wecare.entity;

import com.app.wecare.dto.request.Address;
import com.app.wecare.validation.GenderConstraint;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @TableGenerator(name = "user_id_generator", initialValue = 10000, allocationSize = 1)
    @GeneratedValue(generator = "user_id_generator")
    private Long userId;
    @NotEmpty
    @Column
    private String name;
    @Column
    @GenderConstraint
    private String gender;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private String mobileNumber;
    @Email
    @Column
    private String email;
    @Column
    private LocalDate dob;

    @Column(name = "address")
    @Type(type = "com.app.wecare.entity.CustomTypes.JsonType",
    parameters = {
            @Parameter(
                    name = "classType",
                    value = "com.app.wecare.dto.request.Address"
            )
    })
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    List<Booking> bookings;
}
