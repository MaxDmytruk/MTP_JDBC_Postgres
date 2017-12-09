package cqrs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public interface IQueryHandler<T extends IQuery<K>, K extends IQueryResult> {
    K execute(T query) throws IOException, URISyntaxException, SQLException, ClassNotFoundException;
}
