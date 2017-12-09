package contracts.commands.contributor;

import cqrs.ICommand;

public class CreateContributorCommand implements ICommand {
    public String Login;
    public int ContributionCount;
}
