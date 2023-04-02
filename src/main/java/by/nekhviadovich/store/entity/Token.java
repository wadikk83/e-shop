package by.nekhviadovich.store.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token extends BaseEntity {
    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public ETokenType tokenType = ETokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
}
