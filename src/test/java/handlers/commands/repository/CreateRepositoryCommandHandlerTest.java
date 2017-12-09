package handlers.commands.repository;

import contracts.commands.language.CreateLanguageCommand;
import contracts.commands.repository.CreateRepositoryCommand;
import handlers.commands.language.CreateLanguageCommandHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateRepositoryCommandHandlerTest {
    CreateRepositoryCommandHandler handler;
    CreateRepositoryCommand command;
    @Before
    public void setup(){
        handler = new CreateRepositoryCommandHandler();
        command = new CreateRepositoryCommand();
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