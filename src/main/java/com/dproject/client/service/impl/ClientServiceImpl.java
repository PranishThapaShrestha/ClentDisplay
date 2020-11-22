/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.client.service.impl;

import com.dproject.client.entity.Client;
import com.dproject.client.repository.ClientRepository;
import com.dproject.client.repository.impl.ClientRepositoryImpl;
import com.dproject.client.service.ClientService;

import java.util.List;

/**
 *
 * @author Pranish
 */
public class ClientServiceImpl implements ClientService {

    private List<Client> clients = null;
    private ClientRepository repository = new ClientRepositoryImpl();

    @Override
    public List<Client> findall() throws Exception {
        if (clients == null) {
            clients = repository.findAll();
        }
        return clients;
    }

}
