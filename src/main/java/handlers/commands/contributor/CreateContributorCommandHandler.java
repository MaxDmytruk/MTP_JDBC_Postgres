package handlers.commands.contributor;

import contracts.commands.contributor.CreateContributorCommand;
import cqrs.ICommandHandler;

import java.sql.*;
import java.util.UUID;

public class CreateContributorCommandHandler implements ICommandHandler<CreateContributorCommand> {
    @Override
    public void Execute(CreateContributorCommand command) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9",
                        "postgres", "maxmax");

        String query = "INSERT INTO \"Contributors\" (\"id\",\"login\",\"contributions\") VALUES (?, ?, ?)";

        PreparedStatement preparedStatement= c.prepareStatement(query);

        preparedStatement.setString(1, UUID.randomUUID().toString());
        preparedStatement.setString(2, command.Login);
        preparedStatement.setInt(3, command.ContributionCount);

        preparedStatement.executeUpdate();
    }
}
