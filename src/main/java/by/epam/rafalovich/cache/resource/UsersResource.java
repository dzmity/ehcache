package by.epam.rafalovich.cache.resource;

import by.epam.rafalovich.cache.cache.NotDetermindedCache;
import by.epam.rafalovich.cache.cache.UsersCache;
import by.epam.rafalovich.cache.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource
{
    @Autowired
    UsersCache usersCache;

    @Autowired
    NotDetermindedCache notDetermindedCache;

    @GetMapping(value = "/{name}")
    public Users getUser(@PathVariable final String name)
    {
        return usersCache.getUser(name);
    }

    @GetMapping(value = "/notdeterminded/{name}")
    public Users getSomething(@PathVariable final String name)
    {
        return notDetermindedCache.getSomething(name);
    }
}
