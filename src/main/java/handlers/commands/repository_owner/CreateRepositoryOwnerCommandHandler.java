package handlers.commands.repository_owner;

import contracts.commands.repository_owner.CreateRepositoryOwnerCommand;
import cqrs.ICommandHandler;

import java.sql.*;
import java.util.UUID;

public class CreateRepositoryOwnerCommandHandler implements ICommandHandler<CreateRepositoryOwnerCommand> {
    @Override
    public void Execute(CreateRepositoryOwnerCommand command) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9",
                        "postgres", "maxmax");

        String query = "INSERT INTO \"RepositoryOwners\" (\"id\",\"login\",\"url\") VALUES (?, ?, ?)";

        PreparedStatement preparedStatement= c.prepareStatement(query);

        preparedStatement.setString(1, UUID.randomUUID().toString());
        preparedStatement.setString(2, command.Login);
        preparedStatement.setString(3, command.Url);

        preparedStatement.executeUpdate();
    }
}
