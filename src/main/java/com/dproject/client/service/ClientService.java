/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.client.service;

import com.dproject.client.entity.Client;
import java.util.List;

/**
 *
 * @author Pranish
 */
public interface ClientService {
     List<Client> findall() throws Exception;
}
