package handlers.commands.repository;

import contracts.commands.repository.CreateRepositoryCommand;
import cqrs.ICommandHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class CreateRepositoryCommandHandler implements ICommandHandler<CreateRepositoryCommand> {
    @Override
    public void Execute(CreateRepositoryCommand command) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9",
                        "postgres", "maxmax");

        String query = new StringBuilder("INSERT INTO \"Repositories\" (\"id\",\"name\",\"url\",\"stars\",\"description\",\"language\",\"commitsnum\") VALUES (" )
                .append("'").append(UUID.randomUUID()).append("'").append(", ")
                .append("'").append(command.Name).append("'").append(", ")
                .append("'").append(command.Url).append("'").append(", ")
                .append(command.StarsCount).append(", ")
                .append("'").append(command.Description).append("'").append(", ")
                .append("'").append(command.Language).append("'").append(", ")
                .append(command.CommitsNum).append(");")
                .toString();

        Statement statement = c.createStatement();
        statement.executeUpdate(query);
    }
}
