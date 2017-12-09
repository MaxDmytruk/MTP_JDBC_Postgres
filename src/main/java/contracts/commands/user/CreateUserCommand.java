package contracts.commands.user;

import cqrs.ICommand;

public class CreateUserCommand implements ICommand{
    public String Login;
    public String Url;
    public int Score;
}
