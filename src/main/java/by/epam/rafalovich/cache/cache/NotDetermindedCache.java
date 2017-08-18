package by.epam.rafalovich.cache.cache;

import by.epam.rafalovich.cache.repository.UsersRepository;
import by.epam.rafalovich.cache.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class NotDetermindedCache
{
    @Autowired
    UsersRepository usersRepository;

    @Cacheable(value = "noCache", key = "#name")
    public Users getSomething(String name)
    {
        System.out.println("Retrieving from Database for name: " + name);
        return usersRepository.findByName(name);
    }
}
