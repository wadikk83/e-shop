package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.UserDTO;
import by.nekhviadovich.store.entity.Role;
import by.nekhviadovich.store.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mapping(source = "authorities", target = "authorities", qualifiedByName = "stringToRole")
    public abstract User toEntity(UserDTO userDTO);

    @Mapping(source = "authorities", target = "authorities", qualifiedByName = "roleToString")
    public abstract UserDTO toDto(User user);

    @Named("stringToRole")
    protected Set<Role> stringToRole(Set<String> authorities) {
        if (authorities != null) {
            return authorities.stream()
                    .map(Role::new)
                    .collect(toSet());
        }
        return new HashSet<>();
    }

    @Named("roleToString")
    protected Set<String> roleToString(Set<Role> authorities) {
        if (authorities != null) {
            return authorities.stream()
                    .map(Object::toString)
                    .collect(toSet());
        }
        return new HashSet<>();
    }
}
