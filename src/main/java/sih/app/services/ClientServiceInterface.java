package sih.app.services;

import sih.app.domain.people.Client;

public interface ClientServiceInterface {

    /**
     * adds client
     * @param client
     */
    void addClient(Client client);

    /**
     * reads the clients from a file with the filename and adds them
     * @param fileName
     */
    void readFromFile(String fileName);

    /**
     * writes all the clients in the file with the filename
     * @param fileName
     */
    void writeToFile(String fileName);
}
