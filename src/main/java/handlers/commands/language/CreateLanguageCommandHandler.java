package handlers.commands.language;

import contracts.commands.language.CreateLanguageCommand;
import cqrs.ICommandHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class CreateLanguageCommandHandler implements ICommandHandler<CreateLanguageCommand> {
    @Override
    public void Execute(CreateLanguageCommand command) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/mtp_lab_9",
                        "postgres", "maxmax");

        String query = new StringBuilder("INSERT INTO \"Languages\" (\"id\",\"name\") VALUES (")
                .append("'").append(UUID.randomUUID()).append("', ")
                .append("'").append(command.Name).append("'")
                .append(");").toString();


        Statement statement = c.createStatement();
        statement.executeUpdate(query);
    }
}
