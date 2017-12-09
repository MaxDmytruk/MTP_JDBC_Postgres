package handlers.commands.language;

import contracts.commands.contributor.CreateContributorCommand;
import contracts.commands.language.CreateLanguageCommand;
import handlers.commands.contributor.CreateContributorCommandHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateLanguageCommandHandlerTest {
    CreateLanguageCommandHandler handler;
    CreateLanguageCommand command;
    @Before
    public void setup(){
        handler = new CreateLanguageCommandHandler();
        command = new CreateLanguageCommand();
        command.Name = "test name";

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