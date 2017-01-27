package controller.dao;

import model.client.Client;

import javax.ejb.Local;

@Local
public interface ClientDAO extends IDAO<Client, Integer> {

    Client findByEmail(String email);

}
