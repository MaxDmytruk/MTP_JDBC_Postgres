package handlers.commands.repository_owner;

import contracts.commands.repository.CreateRepositoryCommand;
import contracts.commands.repository_owner.CreateRepositoryOwnerCommand;
import handlers.commands.repository.CreateRepositoryCommandHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateRepositoryOwnerCommandHandlerTest {
    CreateRepositoryOwnerCommandHandler handler;
    CreateRepositoryOwnerCommand command;
    @Before
    public void setup(){
        handler = new CreateRepositoryOwnerCommandHandler();
        command = new CreateRepositoryOwnerCommand();
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