package handlers.commands.contributor;

import contracts.commands.contributor.CreateContributorCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateContributorCommandHandlerTest {
    CreateContributorCommandHandler handler;
    CreateContributorCommand command;
    @Before
    public void setup(){
        handler = new CreateContributorCommandHandler();
        command = new CreateContributorCommand();
        command.Login = "test login";
        command.ContributionCount = 12;

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