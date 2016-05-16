package com.tr.risk.wco.admin.command;

import com.thomsonreuters.grc.fsp.ums.client.core.UserService;
import com.thomsonreuters.grc.fsp.ums.client.core.dto.CreateUserRequest;
import com.tr.risk.wco.Command;
import com.tr.risk.wco.admin.DefaultUser;
import com.tr.risk.wco.admin.User;

import javax.transaction.NotSupportedException;
import java.util.Map;
import java.util.ServiceLoader;


public class DefaultCreateUserCommand implements CreateUserCommand {

    private UserService userService;
    private User user;

    public DefaultCreateUserCommand(User user, UserService userService) {
        this.user = user;
        this.userService = userService;
    }

    public DefaultCreateUserCommand(Map<String, String> arguments, UserService userService) {
        throw new RuntimeException(new NotSupportedException());
    }


    public void execute() {

        System.out.println("Creating using in the system " + user);

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("Firstname");
        createUserRequest.setLastName("Lastname");
        createUserRequest.setEmail("testPerson@example.com");
        createUserRequest.setClientId("GROUP_1");
        createUserRequest.setOnePassUserName("Firstname.Lastname");
        createUserRequest.setClientId("1234");
        String id = userService.createUser(createUserRequest);

        user = new DefaultUser(userService.getUser(id));
    }

    public User getResult() {

        return user;
    }

    public static class Factory implements Command.Factory<User, CreateUserCommand> {
        private UserService userService;

        public Factory() {
            for (UserService us : ServiceLoader.load(UserService.class))
                userService = us;

        }

        @Override
        public boolean accepts(Object userCommand) {
            return userCommand instanceof User || CreateUserCommand.class.getSimpleName().equals(userCommand);

        }

        @Override
        public CreateUserCommand create(Map<String, String> arguments) {
            return new DefaultCreateUserCommand(arguments, userService);
        }

        public CreateUserCommand instantiateCreateCommandFor(User user) {
            return new DefaultCreateUserCommand(user, userService);
        }
    }

}
