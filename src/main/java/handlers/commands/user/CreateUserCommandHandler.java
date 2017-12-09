package handlers.commands.user;

import contracts.commands.user.CreateUserCommand;
import cqrs.ICommandHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class CreateUserCommandHandler implements ICommandHandler<CreateUserCommand> {
    @Override
    public void Execute(CreateUserCommand command) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9",
                        "postgres", "maxmax");

        String query = new StringBuilder("INSERT INTO \"Users\" (\"id\",\"login\",\"url\",\"score\") VALUES (")
                .append("'").append(UUID.randomUUID()).append("', ")
                .append("'").append(command.Login).append("', ")
                .append("'").append(command.Url).append("', ")
                .append(command.Score)
                .append(");").toString();


        Statement statement = c.createStatement();
        statement.executeUpdate(query);
    }
}
