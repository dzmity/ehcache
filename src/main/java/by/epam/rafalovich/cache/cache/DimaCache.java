package by.epam.rafalovich.cache.cache;

import by.epam.rafalovich.cache.model.Users;
import by.epam.rafalovich.cache.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class DimaCache
{
    @Autowired
    UsersRepository usersRepository;

    @Cacheable(value = "dimaCache", key = "#name")
    public Users getUser(String name)
    {
        System.out.println("Retrieving from Database for name: " + name);
        return usersRepository.findByName(name);
    }
}
