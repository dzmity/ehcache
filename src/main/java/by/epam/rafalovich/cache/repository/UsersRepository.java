package by.epam.rafalovich.cache.repository;

import by.epam.rafalovich.cache.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>
{
    Users findByName(String name);
}
