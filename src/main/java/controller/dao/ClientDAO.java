package controller.dao;

import model.client.Client;

/**
 * Created by ivan on 28.03.16.
 */
public interface ClientDAO extends IDAO<Client, Integer> {

    public Client findByEmail(String email);

}