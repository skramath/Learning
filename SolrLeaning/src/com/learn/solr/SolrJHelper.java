package com.learn.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrJHelper {
    private static final HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/db");

    public static void main(String[] args) {
        SolrJHelper helper = new SolrJHelper();

        try {
            helper.indexSolrDocs();
            helper.searchSolr();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }

    private void indexSolrDocs()  throws IOException, SolrServerException {
        /*for (int i = 0; i < 1000; ++i) {
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("name", "HP Training DAY " + i);
            server.add(doc);
            if (i % 100 == 0) {
                server.commit(); // periodically flush
            }
        }
        server.commit();*/
    }


    private void searchSolr() {
        SolrQuery query = new SolrQuery();
        query.setQuery("sony digital camera");
        query.setFields("id","price","merchant","cat","store");
        query.setStart(0);
        query.set("defType", "edismax");

        try {
            QueryResponse response= server.query(query);
            SolrDocumentList results = response.getResults();
            for (int i = 0; i < results.size(); ++i) {
                System.out.println(results.get(i));
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }

}
