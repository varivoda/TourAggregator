package controller.dao.interfaces;

import model.client.Client;

/**
 * Created by ivan on 28.03.16.
 */
public interface DaoClient extends DaoInterface<Client, Integer> {

    public Client findByEmail(String email);

}
