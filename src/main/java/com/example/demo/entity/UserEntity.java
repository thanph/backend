package com.example.demo.entity;

import com.example.demo.entity.event.DemoEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

//    @Transient
//    private List<DemoEvent> demoEvents = new ArrayList<>();
//    // ...
//    public void domainOperation() {
//        // some domain operation
//        System.out.println("add new demo event");
//        demoEvents.add(new DemoEvent());
//    }
//    //4.4.7
//    @DomainEvents
//    public List<DemoEvent> events() {
//        System.out.println("public demo event");
//        return demoEvents;
//    }
//
//    @AfterDomainEventPublication
//    public void clearEvents() {
//        System.out.println("after demo envent publication");
//        demoEvents.clear();
//    }

}
