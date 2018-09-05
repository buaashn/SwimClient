package model.dao;

/**
 *
 * @author sdushn
 */
public interface IMqDAO {
    public boolean sendMessageByMq(String message);
}
