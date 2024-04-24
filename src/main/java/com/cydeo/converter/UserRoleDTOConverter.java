package com.cydeo.converter;

import com.cydeo.dto.UserRoleDTO;
import com.cydeo.service.UserRoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserRoleDTOConverter implements Converter<String, UserRoleDTO> {

    UserRoleService userRoleService;

    public UserRoleDTOConverter(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
        public UserRoleDTO convert(String source) {
            return userRoleService.findBy(Long.parseLong(source));
        }
    }
