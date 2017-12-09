package contracts.commands.language;

import cqrs.ICommand;

public class UpdateLanguageCommand implements ICommand{
    public String Id;
    public String Name;
}
