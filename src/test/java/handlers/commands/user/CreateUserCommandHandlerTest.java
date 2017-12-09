package handlers.commands.user;

import contracts.commands.contributor.CreateContributorCommand;
import contracts.commands.user.CreateUserCommand;
import handlers.commands.contributor.CreateContributorCommandHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateUserCommandHandlerTest {
    CreateUserCommandHandler handler;
    CreateUserCommand command;
    @Before
    public void setup(){
        handler = new CreateUserCommandHandler();
        command = new CreateUserCommand();
        command.Login = "test login";
    }

    @Test
    public void execute() throws Exception {
        int exceptionCounter = 0;
        try {
            handler.Execute(command);
        }
        catch (Exception ex){
            exceptionCounter++;
        }
        assertEquals(0, exceptionCounter);
    }
}