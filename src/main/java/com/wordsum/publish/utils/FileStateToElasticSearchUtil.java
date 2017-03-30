package com.wordsum.publish.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordsum.read.models.text.FileState;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Open Story License
 *
 * Story: wordsum
 * Writer: Kalab J. Oster(TM)
 * Copyright Holders: Kalab J. Oster(TM)
 * copyright (C) 2017 Kalab J. Oster(TM)
 *
 * Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
 * and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
 * and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
 * list of this Open Story License.
 */
public class FileStateToElasticSearchUtil {


    public static void main(String[] args)  throws Exception {


    }

    public static void addJsonToIndex(String jsonFile, String index, String type, String id) throws IOException {

        File jsonFileState = new File(jsonFile);
        ObjectMapper mapper = new ObjectMapper();
        FileState fileState = mapper.readValue(jsonFileState, FileState.class);


        byte[] json = mapper.writeValueAsBytes(fileState);


        Settings settings = Settings.settingsBuilder().put("cluster.name", "elasticsearch").put("client.transport.sniff", true).build();

        Client client =   TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

        IndexResponse response = client.prepareIndex(index, type, id)
                .setSource(json)
                .get();

        client.close();


    }


    public static void createElasticSearchIndex(String index) throws UnknownHostException {

        Settings settings = Settings.settingsBuilder().put("cluster.name", "elasticsearch").put("client.transport.sniff", true).build();


        Client client =   TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

        CreateIndexResponse createResponse = client.admin().indices().create(Requests.createIndexRequest(index)).actionGet();

        client.close();

    }



    public static void deleteElasticSearchIndex(String index, String type, String id) throws UnknownHostException {

        Settings settings = Settings.settingsBuilder().put("cluster.name", "elasticsearch").put("client.transport.sniff", true).build();

        Client client =   TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

        DeleteResponse response = client.prepareDelete(index, type, id).get();

        client.close();

    }


}
