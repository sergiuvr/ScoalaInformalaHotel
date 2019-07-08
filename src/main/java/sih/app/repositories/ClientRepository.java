package sih.app.repositories;

import sih.app.domain.people.Client;

import java.util.HashSet;
import java.util.Set;

public class ClientRepository implements ClientRepositoryInterface {

    Set<Client> clients = new HashSet<>();

    @Override
    public void add(Client client) {
        clients.add(client);
    }

    @Override
    public Set<Client> getAll() {
        return clients;
    }
}
