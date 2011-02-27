package se.asplund;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import se.asplund.user.User;
import se.asplund.user.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:data-config.xml")
public class UserRepositoryIntegrationTest {

    @Autowired
    UserRepository repository;

    @Test
    public void sampleTestCase() {
        User dave = new User(1, "Dave", "Matthews");
        repository.save(dave);

        User carter = new User(2, "Carter", "Beauford");
        repository.save(carter);

        List<User> result = repository.findByLastname("Matthews");
        assertThat(result.size(), is(1));
        assertEquals(dave.getLastname(), result.get(0).getLastname());
    }
}
