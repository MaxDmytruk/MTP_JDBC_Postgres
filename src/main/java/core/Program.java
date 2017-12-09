package core;

import contracts.commands.contributor.CreateContributorCommand;
import contracts.commands.contributor.DeleteContributorCommand;
import contracts.commands.language.UpdateLanguageCommand;
import contracts.commands.repository_owner.CreateRepositoryOwnerCommand;
import contracts.commands.repository_owner.DeleteRepositoryOwnerCommand;
import contracts.queries.repository.RepositoryByNameQuery;
import contracts.queries.repository.RepositoryByNameResult;
import contracts.queries.user.UserByLoginQuery;
import contracts.queries.user.UserByLoginResult;
import handlers.commands.contributor.CreateContributorCommandHandler;
import handlers.commands.contributor.DeleteContributorCommandHandler;
import handlers.commands.language.UpdateLanguageCommandHandler;
import handlers.commands.repository_owner.CreateRepositoryOwnerCommandHandler;
import handlers.commands.repository_owner.DeleteRepositoryOwnerCommandHandler;
import handlers.queries.repository.RepositoryByNameQueryHandler;
import handlers.queries.user.UserByLoginQueryHandler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class Program {
    public static void main(String args[]) {
        try {
            RepositoryByNameQuery query = new RepositoryByNameQuery();
            query.Name = "twbs/bootstrap";
            RepositoryByNameQueryHandler handler = new RepositoryByNameQueryHandler();
            RepositoryByNameResult result = handler.execute(query);

            UpdateLanguageCommand updateLanguageCommand = new UpdateLanguageCommand();
            updateLanguageCommand.Name = "BRAINFUCK";
            updateLanguageCommand.Id = "bc058a6f-0634-4e1b-b9c1-3e342b8ec20e";
            UpdateLanguageCommandHandler updateLanguageCommandHandler = new UpdateLanguageCommandHandler();
            updateLanguageCommandHandler.Execute(updateLanguageCommand);

            DeleteRepositoryOwnerCommand deleteRepositoryOwnerCommand = new DeleteRepositoryOwnerCommand();
            deleteRepositoryOwnerCommand.Id = "d806afa3-0d52-451a-8cd1-3d6d955c8686";
            DeleteRepositoryOwnerCommandHandler deleteRepositoryOwnerCommandHandler = new DeleteRepositoryOwnerCommandHandler();
            deleteRepositoryOwnerCommandHandler.Execute(deleteRepositoryOwnerCommand);

            CreateRepositoryOwnerCommand createRepositoryOwnerCommand = new CreateRepositoryOwnerCommand();
            createRepositoryOwnerCommand.Login = "command created owner";
            createRepositoryOwnerCommand.Url = "https://example.com";
            CreateRepositoryOwnerCommandHandler createRepositoryOwnerCommandHandler = new CreateRepositoryOwnerCommandHandler();
            createRepositoryOwnerCommandHandler.Execute(createRepositoryOwnerCommand);

            UserByLoginQuery userByLoginQuery = new UserByLoginQuery();
            userByLoginQuery.Login = "bestwpw";
            UserByLoginQueryHandler userByLoginQueryHandler = new UserByLoginQueryHandler();
            UserByLoginResult userByLoginResult = userByLoginQueryHandler.execute(userByLoginQuery);

            CreateContributorCommand createContributorCommand = new CreateContributorCommand();
            createContributorCommand.ContributionCount = 777;
            createContributorCommand.Login = "command create contributor";
            CreateContributorCommandHandler createContributorCommandHandler = new CreateContributorCommandHandler();
            createContributorCommandHandler.Execute(createContributorCommand);

            DeleteContributorCommand deleteContributorCommand = new DeleteContributorCommand();
            deleteContributorCommand.Id = "d2a8fddf-3ca1-4e9a-84b3-823257b37f6a";
            DeleteContributorCommandHandler deleteContributorCommandHandler = new DeleteContributorCommandHandler();
            deleteContributorCommandHandler.Execute(deleteContributorCommand);

            System.out.println( );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
