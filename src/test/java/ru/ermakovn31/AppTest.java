package ru.ermakovn31;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import ru.ermakovn31.spring.config.AppConfig;
import ru.ermakovn31.spring.dao.service.IAccountService;
import ru.ermakovn31.spring.dao.service.IRoleService;
import ru.ermakovn31.spring.model.Account;

public class AppTest {

    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Before
    public void before() {
        final IAccountService accountService = context.getBean(IAccountService.class);
        final IRoleService roleService = context.getBean(IRoleService.class);
        final Account account = new Account();
        account.setRole(roleService.getDefault());
        account.setId(228);
        account.setLogin("testLogin");
        account.setPassword("testPassword");
        account.setEmail("testEmail");
        accountService.save(account);
    }

    @Test
    public void findByLogin() {
        final IAccountService accountService = context.getBean(IAccountService.class);
        final Account account = accountService.findByLogin("testLogin");
        Assert.assertEquals("testLogin", account.getLogin());
        Assert.assertEquals("testEmail", account.getEmail());
    }

    @Test
    public void findByEmail() {
        final IAccountService accountService = context.getBean(IAccountService.class);
        final Account account = accountService.findByEmail("testEmail");
        Assert.assertEquals("testLogin", account.getLogin());
        Assert.assertEquals("testEmail", account.getEmail());
    }

    @Test(expected = IncorrectResultSizeDataAccessException.class)
    public void insertDuplicate() {
        final IAccountService accountService = context.getBean(IAccountService.class);
        final Account account = accountService.findByLogin("testLogin");
        accountService.save(account);
        accountService.save(account);
    }

    @After
    public void after() {
        final IAccountService accountService = context.getBean(IAccountService.class);
        accountService.deleteById((long) 228);
    }
}
