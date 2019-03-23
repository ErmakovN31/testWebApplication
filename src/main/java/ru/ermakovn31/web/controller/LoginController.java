package ru.ermakovn31.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ermakovn31.spring.dao.service.IAccountService;
import ru.ermakovn31.spring.dao.service.IRoleService;
import ru.ermakovn31.spring.model.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRoleService roleService;

    @GetMapping("/register")
    public String getRegisterForm(final Model model) {
        final Account account = new Account();
        account.setRole(roleService.getDefault());
        model.addAttribute("account", account);
        return "register";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(final Model model,
                              @ModelAttribute("account") @Valid final Account account,
                              final BindingResult result,
                              final Locale locale,
                              final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("account", account);
            model.addAttribute("message", messageSource.getMessage("register_fail", new Object[]{}, locale));
            return "register";
        }
        if (accountService.findByLogin(account.getLogin()) != null) {
            model.addAttribute("loginError",
                               messageSource.getMessage("register_login_error", new Object[]{}, locale));
            return "register";
        }
        if (accountService.findByEmail(account.getEmail()) != null) {
            model.addAttribute("emailError",
                               messageSource.getMessage("register_email_error", new Object[]{}, locale));
            return "register";
        }
        account.setRole(roleService.getDefault());
        account.setLogin(account.getLogin().toLowerCase());
        account.setEmail(account.getEmail().toLowerCase());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountService.save(account);
        redirectAttributes.addFlashAttribute("message",
                                             messageSource.getMessage("register_success", new Object[]{}, locale));
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginForm(final Model model) {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(final HttpServletRequest request, final HttpServletResponse response) {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping("/loginFailed")
    public String failLogin(final RedirectAttributes redirectAttributes, final Locale locale) {
        redirectAttributes.addFlashAttribute("message",
                                             messageSource.getMessage("login_failed", new Object[]{}, locale));
        return "redirect:/login";
    }
}
