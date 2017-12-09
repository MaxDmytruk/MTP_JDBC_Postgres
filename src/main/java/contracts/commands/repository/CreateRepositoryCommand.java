package contracts.commands.repository;

import cqrs.ICommand;

public class CreateRepositoryCommand implements ICommand {
    public  String Url;
    public String Name;
    public  int StarsCount;
    public  String Description;
    public String Language;
    public  int CommitsNum;
}
