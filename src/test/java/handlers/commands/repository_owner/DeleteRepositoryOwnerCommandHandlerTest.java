package handlers.commands.repository_owner;

import contracts.commands.repository_owner.CreateRepositoryOwnerCommand;
import contracts.commands.repository_owner.DeleteRepositoryOwnerCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteRepositoryOwnerCommandHandlerTest {
    DeleteRepositoryOwnerCommandHandler handler;
    DeleteRepositoryOwnerCommand command;
    @Before
    public void setup(){
        handler = new DeleteRepositoryOwnerCommandHandler();
        command = new DeleteRepositoryOwnerCommand();
        command.Id = "123321";

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