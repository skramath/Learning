package com.learn.solr;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gopis on 10/15/2015.
 */
public class SolrjPopulator {
    List<HashMap<String,String>> hashList = new ArrayList<HashMap<String, String>>();
    HttpSolrServer server = new HttpSolrServer("http://localhost:8983/solr/collection1/");
    public static void main(String[] args) throws Exception{
        SolrjPopulator solrJ = new SolrjPopulator();
        solrJ.indexSolr();
        solrJ.searchSolr();
    }

    private void indexSolr() throws Exception{
        for (int i=0;i<10;++i) {
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("uid", i+100);
            doc.addField("order_no", "order1-" + i);
            doc.addField("purchase_order_no", i*100);
            doc.addField("fuzzy_name", "Hewletpackard" + i);
            server.add(doc);
            server.commit();  // periodically flush
            System.out.println("Committed");
           }
        server.commit();
    }
    private void searchSolr() {
        SolrQuery query = new SolrQuery();
        query.setQuery("*");
        query.setFields("id","*");
        query.setStart(0);
        //query.setRows(1000);
        //query.set("wt","xml");
        query.set("defType", "edismax");
        HashMap<String,String> hashMap = new HashMap<String, String>();
        try {
            QueryResponse response= server.query(query);
            SolrDocumentList results = response.getResults();
            System.out.println("Result Size :"+results.size());
            for (int i = 0; i < results.size(); ++i) {
                //convertToHashMap()
                System.out.println(results.get(i));
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }
}
