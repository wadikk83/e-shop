package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.UserDTO;
import by.nekhviadovich.store.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T22:44:02+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.authorities( stringToRole( userDTO.getAuthorities() ) );
        user.username( userDTO.getUsername() );
        user.password( userDTO.getPassword() );
        user.firstName( userDTO.getFirstName() );
        user.lastName( userDTO.getLastName() );
        user.email( userDTO.getEmail() );

        return user.build();
    }

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setAuthorities( roleToString( user.getAuthorities() ) );
        userDTO.setId( user.getId() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setEmail( user.getEmail() );

        return userDTO;
    }
}
