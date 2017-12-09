package handlers.commands.language;

import contracts.commands.language.CreateLanguageCommand;
import contracts.commands.language.UpdateLanguageCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateLanguageCommandHandlerTest {
    UpdateLanguageCommandHandler handler;
    UpdateLanguageCommand command;
    @Before
    public void setup(){
        handler = new UpdateLanguageCommandHandler();
        command = new UpdateLanguageCommand();
        command.Name = "test name";
        command.Id = "123";
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