package handlers.commands.contributor;

import contracts.commands.contributor.CreateContributorCommand;
import contracts.commands.contributor.DeleteContributorCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteContributorCommandHandlerTest {
    DeleteContributorCommandHandler handler;
    DeleteContributorCommand command;
    @Before
    public void setup(){
        handler = new DeleteContributorCommandHandler();
        command = new DeleteContributorCommand();
        command.Id = "test login";

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