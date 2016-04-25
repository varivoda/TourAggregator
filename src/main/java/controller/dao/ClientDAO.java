package controller.dao;

import model.client.Client;

import javax.ejb.Local;

/**
 * Created by ivan on 28.03.16.
 */
@Local
public interface ClientDAO extends IDAO<Client, Integer> {

    Client findByEmail(String email);

}
