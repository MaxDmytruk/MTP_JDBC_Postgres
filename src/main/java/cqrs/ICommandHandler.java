package cqrs;

import java.sql.SQLException;

public interface ICommandHandler<T extends ICommand> {
    void Execute(T command) throws ClassNotFoundException, SQLException;
}
