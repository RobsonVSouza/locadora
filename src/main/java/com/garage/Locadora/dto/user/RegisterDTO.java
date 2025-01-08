package com.garage.Locadora.dto.user;

import com.garage.Locadora.entity.user.UserRole;

public record RegisterDTO (String login, String password, UserRole role) {
}
