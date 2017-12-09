package contracts.commands.repository_owner;

import cqrs.ICommand;

public class CreateRepositoryOwnerCommand implements ICommand {
    public String Login;
    public String Url;
}
