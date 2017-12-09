package cqrs;

import contracts.commands.contributor.CreateContributorCommand;
import handlers.commands.contributor.CreateContributorCommandHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ICommandHandlerTest {
    ICommandHandler<CreateContributorCommand> createContributorCommandICommandHandler;
    CreateContributorCommand createContributorCommand;

    @Before
    public void setup(){
        createContributorCommandICommandHandler = new CreateContributorCommandHandler();
        createContributorCommand = new CreateContributorCommand();
        createContributorCommand.Login = "test login";
        createContributorCommand.ContributionCount = 1;
    }

    @Test
    public void execute() throws Exception {
        int exceptionCounter = 0;
        try {
            createContributorCommandICommandHandler.Execute(createContributorCommand);
        }
        catch (Exception ex){
            exceptionCounter++;
        }
        assertEquals(0, exceptionCounter);
    }

}